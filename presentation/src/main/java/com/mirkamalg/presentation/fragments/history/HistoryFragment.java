package com.mirkamalg.presentation.fragments.history;

import com.mirkamalg.domain.model.ConversionHistoryItem;
import com.mirkamalg.presentation.common.FragmentBindingInflater;
import com.mirkamalg.presentation.contractor.HistoryContractor;
import com.mirkamalg.presentation.databinding.FragmentHistoryBinding;
import com.mirkamalg.presentation.fragments.BaseFragment;

import java.util.List;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding, HistoryContractor.Presenter>
        implements HistoryContractor.View {

    private HistoryListAdapter adapter;

    @Override
    public FragmentBindingInflater<FragmentHistoryBinding> getBindingInflater() {
        return FragmentHistoryBinding::inflate;
    }

    @Override
    public void onBind(FragmentHistoryBinding binding) {
        adapter = new HistoryListAdapter();
        binding.recyclerView.setAdapter(adapter);

        getPresenter().fetchSavedResults();
    }


    @Override
    public void showError(Throwable throwable) {
        onError(throwable);
    }

    @Override
    public void showLoading(boolean isLoading) {
        setLoading(isLoading);
    }

    @Override
    public void onShowSavedResults(List<ConversionHistoryItem> results) {
        adapter.submitList(results);
    }
}
