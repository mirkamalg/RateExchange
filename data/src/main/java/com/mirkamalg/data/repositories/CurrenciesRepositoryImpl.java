package com.mirkamalg.data.repositories;

import com.mirkamalg.data.data_source.remote.CurrenciesRemoteDataSource;
import com.mirkamalg.data.dtos.AllCurrenciesDTO;
import com.mirkamalg.data.entities.ConversionHistoryEntity;
import com.mirkamalg.data.entities.DaoSession;
import com.mirkamalg.domain.model.ConversionHistoryItem;
import com.mirkamalg.domain.model.ConversionResult;
import com.mirkamalg.domain.model.Currency;
import com.mirkamalg.domain.repositories.CurrenciesRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class CurrenciesRepositoryImpl implements CurrenciesRepository {

    private final CurrenciesRemoteDataSource dataSource;
    private final DaoSession session;

    @Inject
    public CurrenciesRepositoryImpl(CurrenciesRemoteDataSource dataSource, DaoSession session) {
        this.dataSource = dataSource;
        this.session = session;
    }

    @Override
    public Flowable<List<Currency>> fetchCurrencies() {
        return dataSource.fetchAllCurrencies()
                .map(AllCurrenciesDTO::getCurrencies)
                .map((currenciesMap) -> {
                    List<Currency> currencies = new ArrayList<>();
                    for (String key : currenciesMap.keySet()) {
                        currencies.add(new Currency(key));
                    }
                    return currencies;
                });
    }

    @Override
    public Flowable<ConversionResult> fetchConversionResult(String from, String to, double amount) {
        return dataSource.fetchConversionResult(from, to, amount)
                .map(dto -> new ConversionResult(
                        dto.getFrom(),
                        String.valueOf(amount),
                        to,
                        String.valueOf(dto.getResult().get(to))
                ));
    }

    @Override
    public Flowable<List<ConversionHistoryItem>> fetchSavedConversions() {
        return Flowable.just(session.getConversionHistoryEntityDao().loadAll()).map(entities -> {
            List<ConversionHistoryItem> items = new ArrayList<>();
            for (ConversionHistoryEntity entity : entities) {
                items.add(new ConversionHistoryItem(
                        entity.getFrom(),
                        entity.getFromAmount(),
                        entity.getTo(),
                        entity.getResult())
                );
            }
            return items;
        });
    }

    @Override
    public void insertNewConversionResult(ConversionHistoryItem newItem) {
        session.getConversionHistoryEntityDao().insert(
                new ConversionHistoryEntity(
                        newItem.getFrom(), newItem.getFromAmount(), newItem.getTo(), newItem.getResult()
                )
        );
    }
}
