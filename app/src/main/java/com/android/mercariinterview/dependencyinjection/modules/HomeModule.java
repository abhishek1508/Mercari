package com.android.mercariinterview.dependencyinjection.modules;

import android.support.v7.app.AppCompatActivity;

import com.android.mercariinterview.dependencyinjection.scope.HomeScope;
import com.android.mercariinterview.home.Adapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

@Module
public class HomeModule {

    private AppCompatActivity appCompatActivity;

    public HomeModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @HomeScope
    public Adapter getAdapter() {
        return new Adapter(appCompatActivity);
    }
}
