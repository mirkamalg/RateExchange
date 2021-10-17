package com.mirkamalg.presentation.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.mirkamalg.presentation.common.ActivityBindingInflater;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public abstract class BaseActivity<VB extends ViewBinding> extends DaggerAppCompatActivity {

    private VB binding;

    abstract ActivityBindingInflater<VB> getBindingInflater();

    abstract void onBind(VB binding);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getBindingInflater().onInflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onBind(binding);
        Log.e("HERE", this.getClass().getName());
    }

    @Inject
    protected Context context;

//    @Inject
//    protected LoadingDialog loadingDialog;

    public VB getBinding() {
        return binding;
    }

    public void setBinding(VB binding) {
        this.binding = binding;
    }
}
