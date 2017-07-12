package com.android.mercariinterview.dependencyinjection.modules;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.android.mercariinterview.dependencyinjection.scope.HomeScope;
import com.android.mercariinterview.home.Adapter;
import com.android.mercariinterview.home.mvp.HomeContract;
import com.android.mercariinterview.home.mvp.HomeInteractor;
import com.android.mercariinterview.home.mvp.HomePresenter;

import dagger.Module;
import dagger.Provides;

import static com.android.mercariinterview.util.Constants.NUMBER_OF_COLUMNS;

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

    @Provides
    @HomeScope
    public HomeContract.Presenter providePresenter(HomeInteractor homeInteractor) {
        return new HomePresenter(homeInteractor);
    }

    @Provides
    @HomeScope
    public HomeInteractor provideInteractor() {
        return new HomeInteractor(appCompatActivity);
    }

    @Provides
    @HomeScope
    public GridLayoutManager provideGridLayoutManager() {
        return new GridLayoutManager(appCompatActivity, NUMBER_OF_COLUMNS);
    }
}
