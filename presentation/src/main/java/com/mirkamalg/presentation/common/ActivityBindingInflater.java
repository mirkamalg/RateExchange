package com.mirkamalg.presentation.common;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface ActivityBindingInflater<VB extends ViewBinding> {

    VB onInflate(@NonNull LayoutInflater inflater);
}
