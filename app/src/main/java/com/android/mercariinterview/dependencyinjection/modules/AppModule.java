package com.android.mercariinterview.dependencyinjection.modules;

import com.android.mercariinterview.MercariApp;
import com.android.mercariinterview.dependencyinjection.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

@Module
public class AppModule {

    private MercariApp context;

    public AppModule(MercariApp context) {
        this.context = context;
    }

    @Provides
    @AppScope
    public MercariApp getContext() {
        return context;
    }
}
