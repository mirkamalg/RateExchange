package com.mirkamalg.data.data_source.remote;

import com.mirkamalg.data.dtos.AllCurrenciesDTO;
import com.mirkamalg.data.dtos.ConversionResultDTO;
import com.mirkamalg.data.network.CurrenciesServices;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class CurrenciesRemoteDataSource implements ICurrenciesRemoteDataSource {

    private final CurrenciesServices services;

    public static final String API_KEY = "9f60790d1a-0ae910ee9b-r118ad";

    @Inject
    public CurrenciesRemoteDataSource(CurrenciesServices services) {
        this.services = services;
    }

    @Override
    public Flowable<AllCurrenciesDTO> fetchAllCurrencies() {
        return services.fetchAllCurrencies(API_KEY);
    }

    @Override
    public Flowable<ConversionResultDTO> fetchConversionResult(
            String from,
            String to,
            double amount
    ) {
        return services.fetchConversionResult(
                API_KEY, from, to, amount
        );
    }
}
