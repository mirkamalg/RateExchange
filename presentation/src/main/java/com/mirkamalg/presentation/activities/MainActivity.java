package com.mirkamalg.presentation.activities;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.mirkamalg.presentation.R;
import com.mirkamalg.presentation.common.ActivityBindingInflater;
import com.mirkamalg.presentation.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private NavController navController;


    @Override
    ActivityBindingInflater<ActivityMainBinding> getBindingInflater() {
        return ActivityMainBinding::inflate;
    }

    @Override
    void onBind(ActivityMainBinding binding) {
        navController =
                ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .getNavController();
    }
}