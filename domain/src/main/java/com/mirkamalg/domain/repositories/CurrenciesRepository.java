package com.mirkamalg.domain.repositories;

import com.mirkamalg.domain.model.ConversionHistoryItem;
import com.mirkamalg.domain.model.ConversionResult;
import com.mirkamalg.domain.model.Currency;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface CurrenciesRepository {

    Flowable<List<Currency>> fetchCurrencies();

    Flowable<ConversionResult> fetchConversionResult(String from, String to, double amount);

    Flowable<List<ConversionHistoryItem>> fetchSavedConversions();

    void insertNewConversionResult(ConversionHistoryItem newItem);
}
