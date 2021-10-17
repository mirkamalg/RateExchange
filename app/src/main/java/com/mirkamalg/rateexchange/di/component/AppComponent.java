package com.mirkamalg.rateexchange.di.component;

import android.app.Application;

import com.mirkamalg.data.di.DataModule;
import com.mirkamalg.data.di.DatabaseModule;
import com.mirkamalg.data.di.NetworkModule;
import com.mirkamalg.presentation.di.modules.builders.ActivityBuildersModule;
import com.mirkamalg.presentation.di.modules.builders.FragmentBuildersModule;
import com.mirkamalg.rateexchange.App;
import com.mirkamalg.rateexchange.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBuildersModule.class,
        DataModule.class,
        NetworkModule.class,
        DatabaseModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
