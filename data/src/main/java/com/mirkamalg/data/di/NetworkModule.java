package com.mirkamalg.data.di;

import com.mirkamalg.data.BuildConfig;
import com.mirkamalg.data.network.CurrenciesServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(
                    new HttpLoggingInterceptor().setLevel(
                            HttpLoggingInterceptor.Level.BODY
                    )
            );
        }
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitClient(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.fastforex.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    CurrenciesServices provideCurrenciesServices(Retrofit retrofit) {
        return retrofit.create(CurrenciesServices.class);
    }
}
