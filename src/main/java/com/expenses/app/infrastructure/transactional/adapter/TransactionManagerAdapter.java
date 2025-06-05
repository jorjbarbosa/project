package com.expenses.app.infrastructure.transactional.adapter;

import com.expenses.app.domain.transactional.TransactionOperationOutputPort;
import com.expenses.app.domain.transactional.TransactionRunnableWithResult;
import com.expenses.app.domain.transactional.TransactionRunnableWithoutResult;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionManagerAdapter implements TransactionOperationOutputPort {
    private final TransactionTemplate transactionTemplate;

    @Qualifier("read-only")
    private final TransactionTemplate readOnlyTransactionTemplate;

    @Override
    public void rollback() {
        try {
            TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
            log.debug("[Transaction] Will roll back current transaction");
        } catch (NoTransactionException e) {
            // do nothing if not in transaction
        }
    }

    @Override
    public void doInTransaction(boolean readOnly, TransactionRunnableWithoutResult runnableWithoutResult) {
        log.debug("[Transaction] Executing runnable (without a result) in a transaction, read-only: {}", readOnly);
        if (readOnly) {
            readOnlyTransactionTemplate.executeWithoutResult(transactionStatus -> runnableWithoutResult.run());
        } else {
            transactionTemplate.executeWithoutResult(transactionStatus -> runnableWithoutResult.run());
        }
    }

    @Override
    public <R> R doInTransactionWithResult(boolean readOnly, TransactionRunnableWithResult<R> runnableWithResult) {
        log.debug("[Transaction] Executing runnable (with a result) in a transaction, read-only: {}", readOnly);
        if (readOnly) {
            return readOnlyTransactionTemplate.execute(transactionStatus -> runnableWithResult.run());
        } else {
            return transactionTemplate.execute(transactionStatus -> runnableWithResult.run());
        }
    }

    @Override
    public void doAfterCommit(TransactionRunnableWithoutResult runnableWithoutResult) {
        if (!TransactionSynchronizationManager.isActualTransactionActive()) {
            // not in transaction, just execute the runnable
            log.debug("[Transaction] Not in transaction, executing runnable (without a result) from \"doAfterCommit\" directly");
            runnableWithoutResult.run();
            return;
        }

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCompletion(int status) {
                if (status == TransactionSynchronization.STATUS_COMMITTED) {
                    log.debug("[Transaction][After commit] Executing runnable (without a result) after commit");
                    runnableWithoutResult.run();
                }
            }
        });
    }

    @Override
    public <R> R doAfterCommitWithResult(TransactionRunnableWithResult<R> runnableWithResult) {
        if (!TransactionSynchronizationManager.isActualTransactionActive()) {
            // not in transaction, just execute the runnable
            log.debug("[Transaction] Not in transaction, executing runnable (with a result) from \"doAfterCommitWithResult\" directly");
            return runnableWithResult.run();
        }

        final AtomicReference<R> result = new AtomicReference<>();
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {

            @Override
            public void afterCompletion(int status) {
                if (status == TransactionSynchronization.STATUS_COMMITTED) {
                    log.debug("[Transaction][After commit] Executing runnable (with a result) after commit");
                    result.set(runnableWithResult.run());
                }
            }

        });
        return result.get();
    }

    @Override
    public void doAfterRollback(TransactionRunnableWithoutResult runnableWithoutResult) {
        if (!TransactionSynchronizationManager.isActualTransactionActive()) {
            // not in transaction, just execute the runnable
            log.debug("[Transaction] Not in transaction, executing runnable (without a result) from \"doAfterRollback\" directly");
            runnableWithoutResult.run();
            return;
        }

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCompletion(int status) {
                if (status == TransactionSynchronization.STATUS_ROLLED_BACK) {
                    log.debug("[Transaction][After rollback] Executing runnable (without a result) after rollback");
                    runnableWithoutResult.run();
                }
            }
        });
    }

    @Override
    public <R> R doAfterRollbackWithResult(TransactionRunnableWithResult<R> runnableWithResult) {
        if (!TransactionSynchronizationManager.isActualTransactionActive()) {
            // not in transaction, just execute the runnable
            log.debug("[Transaction] Not in transaction, executing runnable (with a result) from \"doAfterRollbackWithResult\" directly");
            return runnableWithResult.run();
        }

        final AtomicReference<R> result = new AtomicReference<>();
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCompletion(int status) {
                if (status == TransactionSynchronization.STATUS_ROLLED_BACK) {
                    log.debug("[Transaction] Executing runnable (with a result) after rollback");
                    result.set(runnableWithResult.run());
                }
            }
        });
        return result.get();
    }
}
