package com.mirkamalg.data.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class ConversionResultDTO {

    @SerializedName("base")
    private final String from;

    @SerializedName("result")
    private final Map<String, Double> result;

    public ConversionResultDTO(String from, Map<String, Double> result) {
        this.from = from;
        this.result = result;
    }

    public String getFrom() {
        return from;
    }

    public Map<String, Double> getResult() {
        return result;
    }
}
