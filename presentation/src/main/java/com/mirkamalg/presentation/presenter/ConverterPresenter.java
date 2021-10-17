package com.mirkamalg.presentation.presenter;

import com.mirkamalg.domain.model.ConversionHistoryItem;
import com.mirkamalg.domain.model.ConversionResult;
import com.mirkamalg.domain.model.Currency;
import com.mirkamalg.domain.repositories.CurrenciesRepository;
import com.mirkamalg.presentation.common.AsyncRequest;
import com.mirkamalg.presentation.contractor.ConverterContractor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class ConverterPresenter extends BasePresenter<ConverterContractor.View> implements ConverterContractor.Presenter {

    private final CurrenciesRepository repository;

    @Inject
    public ConverterPresenter(CurrenciesRepository repository, ConverterContractor.View view) {
        this.repository = repository;
        setView(view);
    }

    @Override
    public void doCleanUp() {
        super.doCleanUp();
    }

    @Override
    public void fetchAllCurrencies() {
        makeRequest(new AsyncRequest<List<Currency>>() {

            @Override
            public Flowable<List<Currency>> flow() {
                return repository.fetchCurrencies();
            }

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(List<Currency> currency) {
                List<String> result = new ArrayList<>();
                for (Currency c : currency) {
                    result.add(c.getName());
                }
                getView().onCurrenciesFetched(result);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
            }
        });
    }

    @Override
    public void fetchConversionResults(String from, double fromAmount, String to) {
        makeRequest(new AsyncRequest<ConversionResult>() {
            @Override
            public Flowable<ConversionResult> flow() {
                return repository.fetchConversionResult(from, to, fromAmount);
            }

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(ConversionResult conversionResult) {
                getView().onShowResult(conversionResult.getResult());
                insertConversionResultsToDatabase(
                        conversionResult.getFrom(), conversionResult.getFromAmount(),
                        conversionResult.getTo(), conversionResult.getResult()
                );
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
    public void insertConversionResultsToDatabase(String from, String fromAmount, String to, String result) {
        repository.insertNewConversionResult(
                new ConversionHistoryItem(
                        from, fromAmount, to, result
                )
        );
    }
}
