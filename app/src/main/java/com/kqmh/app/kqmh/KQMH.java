package com.kqmh.app.kqmh;

import android.app.Application;

import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by ekirapa on 6/28/18 .
 */
public class KQMH extends Application {
    private static KQMH mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        FlowManager.init(FlowConfig.builder(this)
                .addDatabaseConfig(DatabaseConfig.builder(AppDatabase.class)
                        .databaseName("AppDatabase")
                        .build())
                .build());

    }
}
