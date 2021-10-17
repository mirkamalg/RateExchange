package com.mirkamalg.presentation.presenter;

import com.mirkamalg.domain.model.ConversionHistoryItem;
import com.mirkamalg.domain.repositories.CurrenciesRepository;
import com.mirkamalg.presentation.common.AsyncRequest;
import com.mirkamalg.presentation.contractor.HistoryContractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class HistoryPresenter extends BasePresenter<HistoryContractor.View> implements HistoryContractor.Presenter {

    private final CurrenciesRepository repository;

    @Inject
    public HistoryPresenter(CurrenciesRepository repository, HistoryContractor.View view) {
        this.repository = repository;
        setView(view);
    }

    @Override
    public void fetchSavedResults() {
        makeRequest(new AsyncRequest<List<ConversionHistoryItem>>() {
            @Override
            public Flowable<List<ConversionHistoryItem>> flow() {
                return repository.fetchSavedConversions();
            }

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(List<ConversionHistoryItem> conversionHistoryItems) {
                getView().onShowSavedResults(conversionHistoryItems);
            }

            @Override
            public void onError(Throwable throwable) {
                showErrorToast(throwable.getMessage());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public void doCleanUp() {
        super.doCleanUp();
    }
}
