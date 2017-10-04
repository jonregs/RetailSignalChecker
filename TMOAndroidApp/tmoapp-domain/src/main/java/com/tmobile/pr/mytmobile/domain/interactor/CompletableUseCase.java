package com.tmobile.pr.mytmobile.domain.interactor;

import com.tmobile.pr.mytmobile.domain.executor.PostExecutionThread;
import com.tmobile.pr.mytmobile.domain.executor.ThreadExecutor;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;

/**
 * Abstract class for a UseCase that returns an instance of a [Completable].
 */
public abstract class CompletableUseCase<Params> {

    private final Disposable subscription;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    public CompletableUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.subscription = Disposables.empty();
    }

    /**
     * Builds a [Completable] which will be used when the current [CompletableUseCase] is executed.
     */
    protected abstract Completable buildUseCaseObservable(Params params);

    /**
     * Executes the current use case.
     */
    public final Completable execute(Params params) {
        return this.buildUseCaseObservable(params).subscribeOn(Schedulers.from(this.threadExecutor)).observeOn(this.postExecutionThread.getScheduler());
    }

    /**
     * Unsubscribes from current [Disposable].
     */
    public final void unsubscribe() {
        if (!this.subscription.isDisposed()) {
            this.subscription.dispose();
        }
    }
}
