package com.android.mercariinterview;

import android.app.Application;

import com.android.mercariinterview.dependencyinjection.components.AppComponent;
import com.android.mercariinterview.dependencyinjection.components.DaggerAppComponent;
import com.android.mercariinterview.dependencyinjection.modules.AppModule;

import timber.log.Timber;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

public class MercariApp extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public AppComponent getAppComponent() {
        return component;
    }
}

