package com.mirkamalg.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.mirkamalg.presentation.common.FragmentBindingInflater;
import com.mirkamalg.presentation.common.IPresenter;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public abstract class BaseFragment<VB extends ViewBinding, P extends IPresenter>
        extends DaggerFragment {

    private VB binding;

    @Inject
    protected P presenter;

    private boolean isLoading;

    public abstract FragmentBindingInflater<VB> getBindingInflater();

    public abstract void onBind(VB binding);

    @Inject
    protected Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = getBindingInflater().onInflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onBind(binding);
        Log.e("HERE", this.getClass().getSimpleName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.doCleanUp();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public VB getBinding() {
        return binding;
    }

    public void setBinding(VB binding) {
        this.binding = binding;
    }

    protected void onError(Throwable error) {
        String message = error.getMessage();
        Log.e("FRAGMENT", message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public P getPresenter() {
        return presenter;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
}
