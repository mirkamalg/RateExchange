package com.mirkamalg.data.di;

import com.mirkamalg.data.data_source.remote.CurrenciesRemoteDataSource;
import com.mirkamalg.data.data_source.remote.ICurrenciesRemoteDataSource;
import com.mirkamalg.data.repositories.CurrenciesRepositoryImpl;
import com.mirkamalg.domain.repositories.CurrenciesRepository;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Module
public abstract class DataModule {

    @Binds
    abstract ICurrenciesRemoteDataSource bindCurrenciesRemoteDataSource(CurrenciesRemoteDataSource dataSource);

    @Binds
    abstract CurrenciesRepository bindCurrenciesRepositoryImpl(CurrenciesRepositoryImpl currenciesRepository);

}
