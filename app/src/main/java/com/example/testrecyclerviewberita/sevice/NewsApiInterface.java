package com.example.testrecyclerviewberita.sevice;

import com.example.recyclerviewberita.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiInterface {

    @GET("/v2/top-headlines")
    Call<weather> getTopHeadLinesNewsByCountry(@Query("country") String country, @Query("apiKey")String apiKey);


}
