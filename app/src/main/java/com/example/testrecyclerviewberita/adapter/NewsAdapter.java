package com.example.testrecyclerviewberita.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.testrecyclerviewberita.R;
import com.example.testrecyclerviewberita.model.Main;
import com.example.testrecyclerviewberita.model.Weather;

public class NewsAdapter {

    private Context context;
    private Weather weather;
    private Main main;

    public NewsAdapter(Context context, Weather weather, Main main) {
        this.context = context;
        this.weather = weather;
        this.main = main;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_main,parent,false); // wajib ganti layout
        return new NewsAdapter.NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        holder.txtMain.setText(weather.getWeather().get(position).getMain());
        holder.txtTemperatur.setText(String.valueOf(weather.getMain().getTemp());
        holder.txtDeskripsi.setText(weather.getWeather().get(position).getDescription());
        holder.txtHumadity.setText(weather.getMain().getHumidity());
        Glide.with(context).load(weather.getWeather().get(position).getIcon()).into(holder.imageIcon);
    }


    //INI PENTING
    @Override
    public int getItemCount() {
        return 1;
    }


    public class NewsHolder {


        TextView txtMain,txtDeskripsi,txtTemperatur,txtHumadity;
        CardView cardButton;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            cardButton = itemView.findViewById(R.id.cardButton);
            txtMain = itemView.findViewById(R.id.txtMain);
            txtDeskripsi = itemView.findViewById(R.id.txtDeskripsi);
            txtTemperatur = itemView.findViewById(R.id.txtTemperatur);
            txtHumadity = itemView.findViewById(R.id.txtHumadity);
        }
    }
}
