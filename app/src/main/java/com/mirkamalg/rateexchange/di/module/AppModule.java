package com.mirkamalg.rateexchange.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Module
abstract public class AppModule {

    @Singleton
    @Binds
    abstract Context bindContext(Application application);

}
