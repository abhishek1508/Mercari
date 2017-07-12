package com.android.mercariinterview.dependencyinjection.components;

import com.android.mercariinterview.dependencyinjection.modules.AppModule;
import com.android.mercariinterview.dependencyinjection.modules.NetworkModule;
import com.android.mercariinterview.dependencyinjection.scope.AppScope;

import dagger.Component;

/**
 * Created by AbhishekKejriwal on 7/12/2017.
 */

@AppScope
@Component (modules = {NetworkModule.class, AppModule.class})
public interface NetworkComponent {
}
