package com.example.testrecyclerviewberita.sevice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApiClient {

    public static Retrofit retrofit;
    public static final String URL = "https://openweathermap.org/";

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
