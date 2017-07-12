package com.android.mercariinterview.home.mvp;

import android.content.Context;

import com.android.mercariinterview.data.Item;
import com.android.mercariinterview.data.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

public class HomeInteractor {

    private Context context;

    public HomeInteractor(Context context) {
        this.context = context;
    }

    public String getJsonString() {
        String json;
        try {
            InputStream is = context.getAssets().open("file.json");
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

    public List<Item> getItemList() {
        Gson gson = new Gson();
        Response response = gson.fromJson(getJsonString(), Response.class);
        return response.data;
    }
}
