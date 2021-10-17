package com.mirkamalg.data.data_source.remote;

import com.mirkamalg.data.dtos.AllCurrenciesDTO;
import com.mirkamalg.data.dtos.ConversionResultDTO;

import io.reactivex.rxjava3.core.Flowable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface ICurrenciesRemoteDataSource {

    Flowable<AllCurrenciesDTO> fetchAllCurrencies();

    Flowable<ConversionResultDTO> fetchConversionResult(
            String from,
            String to,
            double amount
    );
}
