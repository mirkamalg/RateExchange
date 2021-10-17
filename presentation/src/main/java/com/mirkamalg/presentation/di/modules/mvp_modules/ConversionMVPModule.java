package com.mirkamalg.presentation.di.modules.mvp_modules;

import com.mirkamalg.presentation.contractor.ConverterContractor;
import com.mirkamalg.presentation.di.scopes.FragmentScope;
import com.mirkamalg.presentation.fragments.conversion.ConversionFragment;
import com.mirkamalg.presentation.presenter.ConverterPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Module
public abstract class ConversionMVPModule {

    @FragmentScope
    @Binds
    abstract ConverterContractor.View bindConversionView(ConversionFragment fragment);

    @FragmentScope
    @Binds
    abstract ConverterContractor.Presenter bindConversionPresenter(ConverterPresenter presenter);
}
