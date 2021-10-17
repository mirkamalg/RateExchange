package com.mirkamalg.data.network;

import com.mirkamalg.data.dtos.AllCurrenciesDTO;
import com.mirkamalg.data.dtos.ConversionResultDTO;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface CurrenciesServices {

    @GET("currencies")
    Flowable<AllCurrenciesDTO> fetchAllCurrencies(
            @Query("api_key") String apiKey
    );

    @GET("convert")
    Flowable<ConversionResultDTO> fetchConversionResult(
            @Query("api_key") String apiKey,
            @Query("from") String from,
            @Query("to") String to,
            @Query("amount") double amount
    );

}
