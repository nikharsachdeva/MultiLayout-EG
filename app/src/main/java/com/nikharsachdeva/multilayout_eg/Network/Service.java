package com.nikharsachdeva.multilayout_eg.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class Service {


    public static final String BASE_SERVER_URL = "http://103.146.176.51/";
    public static Retrofit getClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static APIinterface apIinterface() {
        return getClient().create(APIinterface.class);
    }

}
