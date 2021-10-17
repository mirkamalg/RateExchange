package com.mirkamalg.domain.model;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class ConversionResult {

    private final String from, fromAmount, to, result;

    public ConversionResult(String from, String fromAmount, String to, String result) {
        this.from = from;
        this.fromAmount = fromAmount;
        this.to = to;
        this.result = result;
    }

    public String getFrom() {
        return from;
    }

    public String getFromAmount() {
        return fromAmount;
    }

    public String getTo() {
        return to;
    }

    public String getResult() {
        return result;
    }
}
