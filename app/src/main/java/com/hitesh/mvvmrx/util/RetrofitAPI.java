package com.hitesh.mvvmrx.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitAPI {


    public static Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constatnts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

}
