package com.mirkamalg.data.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class AllCurrenciesDTO {

    @SerializedName("currencies")
    private Map<String, String> currencies;

    public AllCurrenciesDTO(Map<String, String> currencies) {
        this.currencies = currencies;
    }

    public Map<String, String> getCurrencies() {
        return currencies;
    }
}
