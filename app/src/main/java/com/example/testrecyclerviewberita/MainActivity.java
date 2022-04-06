package com.example.testrecyclerviewberita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testrecyclerviewberita.adapter.NewsAdapter;
import com.example.testrecyclerviewberita.model.Weather;
import com.example.testrecyclerviewberita.sevice.NewsApiClient;
import com.example.testrecyclerviewberita.sevice.NewsApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button btnSearch;
    EditText editSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsApiInterface newsApiInterface = NewsApiClient.getRetrofit().create(NewsApiInterface.class);
        Call<Weather> call = newsApiInterface.getTopHeadLinesNewsByCountry("ca","aad702f0427fc26055b6fa9a304674ea");

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                NewsAdapter adapter = new NewsAdapter(MainActivity.this, response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                rvBerita.setLayoutManager(layoutManager);
                rvBerita.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                System.out.println(t);
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cari = editSearch.getText().toString();
                String input = "chile";
                if(cari.isEmpty() ) {
                    cari = input;
                }
                Call<Weather> call2 = newsApiInterface.getTopHeadLinesNewsBySearch(cari,"59430faa9546448da7de3786ace4bdab");
                call2.enqueue(new Callback<Weather>()

                {

                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        NewsAdapter adapter = new NewsAdapter(MainActivity.this, response.body());
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                        rvBerita.setLayoutManager(layoutManager);
                        rvBerita.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {

                    }
                });
            }
        });


    }
}