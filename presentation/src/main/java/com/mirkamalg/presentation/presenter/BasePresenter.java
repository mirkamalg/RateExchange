package com.mirkamalg.presentation.presenter;

import android.widget.Toast;

import com.mirkamalg.presentation.common.AsyncRequest;
import com.mirkamalg.presentation.common.IView;
import com.mirkamalg.presentation.fragments.BaseFragment;
import com.mirkamalg.presentation.fragments.conversion.ConversionFragment;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public abstract class BasePresenter<V extends IView> {

    private V view;

    private boolean isLoading;

    private final CompositeDisposable disposable = new CompositeDisposable();

    protected <T> void makeRequest(AsyncRequest<T> request) {
        setLoading(true);
        request.flow().toObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        request.onSubscribe(d);
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull T t) {
                        request.onNext(t);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        request.onError(e);
                        view.showError(e);
                    }

                    @Override
                    public void onComplete() {
                        setLoading(false);
                        request.onCompleted();
                    }
                });
    }

    public void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
        view.showLoading(isLoading);
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void doCleanUp() {
        disposable.clear();
    }

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }

    void showErrorToast(String error) {
        Toast.makeText(((BaseFragment) getView()).requireContext(), error, Toast.LENGTH_SHORT).show();
    }
}
