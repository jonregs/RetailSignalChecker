package com.tmobile.pr.mytmobile.domain.interactor;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Default [SingleObserver] base class to define
 */
public class BaseSingleObserver<T> implements SingleObserver<T> {
    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onSuccess(T value) {
    }

    @Override
    public void onError(Throwable e) {
    }
}
