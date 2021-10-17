package com.mirkamalg.presentation.fragments.conversion;

import android.view.View;
import android.widget.ArrayAdapter;

import androidx.navigation.fragment.NavHostFragment;

import com.mirkamalg.presentation.common.FragmentBindingInflater;
import com.mirkamalg.presentation.contractor.ConverterContractor;
import com.mirkamalg.presentation.databinding.FragmentConversionBinding;
import com.mirkamalg.presentation.fragments.BaseFragment;

import java.util.List;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class ConversionFragment extends BaseFragment<FragmentConversionBinding, ConverterContractor.Presenter>
        implements ConverterContractor.View {


    @Override
    public FragmentBindingInflater<FragmentConversionBinding> getBindingInflater() {
        return FragmentConversionBinding::inflate;
    }

    @Override
    public void onBind(FragmentConversionBinding binding) {
        binding.buttonConvert.setOnClickListener((v) -> getPresenter().fetchConversionResults(
                binding.spinnerFrom.getSelectedItem().toString(),
                Double.parseDouble(binding.editTextFromAmount.getText().toString()),
                binding.spinnerTo.getSelectedItem().toString()
        ));
        binding.buttonShowHistory.setOnClickListener(v -> NavHostFragment.findNavController(this).navigate(
                ConversionFragmentDirections.actionConversionFragmentToHistoryFragment()
        ));

        getPresenter().fetchAllCurrencies();
    }

    @Override
    public void showError(Throwable throwable) {
        onError(throwable);
    }

    @Override
    public void showLoading(boolean isLoading) {
        handleLoading(isLoading);
    }

    @Override
    public void onCurrenciesFetched(List<String> result) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                result
        );
        getBinding().spinnerFrom.setAdapter(adapter);
        getBinding().spinnerTo.setAdapter(adapter);
    }

    @Override
    public void onShowResult(String result) {
        getBinding().textViewResult.setText(result);
    }

    private void handleLoading(boolean isLoading) {
        if (super.isLoading() == isLoading) return;
        super.setLoading(isLoading);

        if (super.isLoading()) getBinding().overlayLoading.setVisibility(View.VISIBLE);
        else getBinding().overlayLoading.setVisibility(View.GONE);
    }
}
