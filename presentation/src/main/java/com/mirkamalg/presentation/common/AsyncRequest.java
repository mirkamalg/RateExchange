package com.mirkamalg.presentation.common;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface AsyncRequest<T> {

    Flowable<T> flow();

    void onSubscribe(Disposable disposable);

    void onNext(T t);

    void onError(Throwable throwable);

    void onCompleted();
}
