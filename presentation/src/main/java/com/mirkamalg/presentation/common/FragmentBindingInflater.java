package com.mirkamalg.presentation.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface FragmentBindingInflater<VB extends ViewBinding> {

    VB onInflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, boolean flag);
}
