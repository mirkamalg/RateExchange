package com.mirkamalg.presentation.di.modules.mvp_modules;

import com.mirkamalg.presentation.contractor.HistoryContractor;
import com.mirkamalg.presentation.di.scopes.FragmentScope;
import com.mirkamalg.presentation.fragments.history.HistoryFragment;
import com.mirkamalg.presentation.presenter.HistoryPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Module
public abstract class HistoryMVPModule {

    @FragmentScope
    @Binds
    abstract HistoryContractor.View bindHistoryView(HistoryFragment fragment);

    @FragmentScope
    @Binds
    abstract HistoryContractor.Presenter bindHistoryPresenter(HistoryPresenter presenter);
}
