package com.mirkamalg.data.data_source.local;

import com.mirkamalg.data.entities.ConversionHistoryEntity;
import com.mirkamalg.data.entities.DaoSession;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public class ConversionHistoryDataSource implements IConversionHistoryDataSource {

    private final DaoSession session;

    @Inject
    public ConversionHistoryDataSource(DaoSession session) {
        this.session = session;
    }

    @Override
    public Flowable<List<ConversionHistoryEntity>> fetchSavedConversionData() {
        return Flowable.just(session.loadAll(ConversionHistoryEntity.class));
    }

    @Override
    public void addConversionData(ConversionHistoryEntity newEntity) {
        session.getConversionHistoryEntityDao().insert(newEntity);
    }
}
