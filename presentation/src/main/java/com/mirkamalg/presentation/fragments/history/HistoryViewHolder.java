package com.mirkamalg.presentation.fragments.history;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirkamalg.domain.model.ConversionHistoryItem;
import com.mirkamalg.presentation.databinding.ItemHistoryBinding;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@SuppressLint("SetTextI18n")
public class HistoryViewHolder extends RecyclerView.ViewHolder {

    private final ItemHistoryBinding binding;

    private HistoryViewHolder(@NonNull ItemHistoryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(ConversionHistoryItem item) {
        binding.textViewResult.setText(
                item.getFromAmount() + " " + item.getFrom() + " is " + item.getResult() + " " + item.getTo()
        );
    }

    public static HistoryViewHolder from(ViewGroup parent) {
        return new HistoryViewHolder(
                ItemHistoryBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }
}
