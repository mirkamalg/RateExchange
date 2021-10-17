package com.mirkamalg.presentation.di.modules.builders;

import com.mirkamalg.presentation.activities.MainActivity;
import com.mirkamalg.presentation.di.scopes.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Module
    public abstract class ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {
            FragmentBuildersModule.class
    })
    abstract MainActivity contributeMainActivity();

}
