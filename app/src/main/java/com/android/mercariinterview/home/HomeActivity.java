package com.android.mercariinterview.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.mercariinterview.MercariApp;
import com.android.mercariinterview.R;
import com.android.mercariinterview.dependencyinjection.components.DaggerHomeComponent;
import com.android.mercariinterview.dependencyinjection.modules.HomeModule;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {

    @Inject Adapter adapter;

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
                .build()
                .inject(this);
    }
}
