package com.mirkamalg.data.di;

import android.app.Application;

import com.mirkamalg.data.entities.DaoMaster;
import com.mirkamalg.data.entities.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

@Module
public class DatabaseModule {

    @Singleton
    @Provides
    DaoSession provideDaoSession(Application application) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, "currency-db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }
}
