package com.android.mercariinterview.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.mercariinterview.MercariApp;
import com.android.mercariinterview.R;
import com.android.mercariinterview.data.Response;
import com.android.mercariinterview.dependencyinjection.components.DaggerHomeComponent;
import com.android.mercariinterview.dependencyinjection.modules.HomeModule;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {

    @Inject Adapter adapter;

    private Response response;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDagger();
        parseJson(readFromAssets());
    }

    private void setDagger() {
        DaggerHomeComponent
                .builder()
                .appComponent(((MercariApp)getApplication()).getAppComponent())
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    private String readFromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("file.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void parseJson(String jsonString) {
        Gson gson = new Gson();
        response = gson.fromJson(jsonString, Response.class);
        Log.d("lll", "parseJson: ");
    }
}
