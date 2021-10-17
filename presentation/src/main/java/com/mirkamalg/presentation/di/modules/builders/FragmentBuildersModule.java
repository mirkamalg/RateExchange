package com.mirkamalg.presentation.di.modules.builders;

import com.mirkamalg.presentation.di.modules.mvp_modules.ConversionMVPModule;
import com.mirkamalg.presentation.di.modules.mvp_modules.HistoryMVPModule;
import com.mirkamalg.presentation.di.scopes.FragmentScope;
import com.mirkamalg.presentation.fragments.history.HistoryFragment;
import com.mirkamalg.presentation.fragments.conversion.ConversionFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Module
public abstract class FragmentBuildersModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {
            ConversionMVPModule.class
    })
    abstract ConversionFragment contributeConversionFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {
            HistoryMVPModule.class
    })
    abstract HistoryFragment contributeHistoryFragment();

}
