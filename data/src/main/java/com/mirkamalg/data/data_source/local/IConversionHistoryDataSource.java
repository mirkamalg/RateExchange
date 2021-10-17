package com.mirkamalg.data.data_source.local;

import com.mirkamalg.data.entities.ConversionHistoryEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface IConversionHistoryDataSource {

    Flowable<List<ConversionHistoryEntity>> fetchSavedConversionData();

    void addConversionData(ConversionHistoryEntity newEntity);
}
