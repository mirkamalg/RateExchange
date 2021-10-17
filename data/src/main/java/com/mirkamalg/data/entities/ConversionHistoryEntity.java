package com.mirkamalg.data.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Entity
public class ConversionHistoryEntity {
    private String from, fromAmount, to, result;
    @Generated(hash = 1413907372)
    public ConversionHistoryEntity(String from, String fromAmount, String to,
            String result) {
        this.from = from;
        this.fromAmount = fromAmount;
        this.to = to;
        this.result = result;
    }
    @Generated(hash = 1949539788)
    public ConversionHistoryEntity() {
    }
    public String getFrom() {
        return this.from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getFromAmount() {
        return this.fromAmount;
    }
    public void setFromAmount(String fromAmount) {
        this.fromAmount = fromAmount;
    }
    public String getTo() {
        return this.to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getResult() {
        return this.result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
