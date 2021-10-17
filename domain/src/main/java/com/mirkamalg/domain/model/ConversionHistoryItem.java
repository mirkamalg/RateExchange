package com.mirkamalg.domain.model;

import androidx.annotation.Nullable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class ConversionHistoryItem extends ConversionResult {

    public ConversionHistoryItem(String from, String fromAmount, String to, String result) {
        super(from, fromAmount, to, result);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ConversionHistoryItem)) return false;
        ConversionHistoryItem other = (ConversionHistoryItem) obj;
        return this.getFrom().equals(other.getFrom()) &&
                this.getFromAmount().equals(other.getFromAmount()) &&
                this.getTo().equals(other.getTo()) &&
                this.getResult().equals(other.getResult());
    }
}
