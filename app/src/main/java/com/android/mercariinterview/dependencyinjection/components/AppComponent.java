package com.android.mercariinterview.dependencyinjection.components;

import com.android.mercariinterview.MercariApp;
import com.android.mercariinterview.dependencyinjection.modules.AppModule;
import com.android.mercariinterview.dependencyinjection.scope.AppScope;
import com.android.mercariinterview.home.HomeActivity;

import dagger.Component;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MercariApp app);
}
