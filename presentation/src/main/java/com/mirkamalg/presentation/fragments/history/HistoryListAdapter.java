package com.mirkamalg.presentation.fragments.history;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.mirkamalg.domain.model.ConversionHistoryItem;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class HistoryListAdapter extends ListAdapter<ConversionHistoryItem, HistoryViewHolder> {


    protected HistoryListAdapter() {
        super(new DiffUtil.ItemCallback<ConversionHistoryItem>() {
            @Override
            public boolean areItemsTheSame(@NonNull ConversionHistoryItem oldItem, @NonNull ConversionHistoryItem newItem) {
                return oldItem.getResult().equals(newItem.getResult());
            }

            @Override
            public boolean areContentsTheSame(@NonNull ConversionHistoryItem oldItem, @NonNull ConversionHistoryItem newItem) {
                return oldItem.equals(newItem);
            }
        });
    }


    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return HistoryViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
