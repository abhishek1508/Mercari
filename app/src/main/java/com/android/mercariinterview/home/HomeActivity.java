package com.android.mercariinterview.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.mercariinterview.MercariApp;
import com.android.mercariinterview.R;
import com.android.mercariinterview.dependencyinjection.components.DaggerHomeComponent;
import com.android.mercariinterview.dependencyinjection.modules.HomeModule;
import com.android.mercariinterview.dependencyinjection.modules.NetworkModule;
import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {

    @Inject Adapter adapter;
    @Inject Gson gson;
    @Inject Retrofit retrofit;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDagger();
    }

    private void setDagger() {
        DaggerHomeComponent
                .builder()
                .appComponent(((MercariApp)getApplication()).getAppComponent())
                .homeModule(new HomeModule(this))
                .networkModule(new NetworkModule("baseUrl"))
                .build()
                .inject(this);
    }
}
