package com.android.mercariinterview.dependencyinjection.components;

import com.android.mercariinterview.dependencyinjection.modules.AppModule;
import com.android.mercariinterview.dependencyinjection.modules.HomeModule;
import com.android.mercariinterview.dependencyinjection.modules.NetworkModule;
import com.android.mercariinterview.dependencyinjection.scope.HomeScope;
import com.android.mercariinterview.home.HomeActivity;

import dagger.Component;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

@HomeScope
@Component(modules = {HomeModule.class, NetworkModule.class}, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeActivity target);
}
