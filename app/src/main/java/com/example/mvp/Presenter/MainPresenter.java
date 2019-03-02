package com.example.mvp.Presenter;

import com.example.mvp.Interface.MainMVP;
import com.example.mvp.Interface.Api;
import com.example.mvp.Model.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter implements MainMVP.Presenter {
    MainMVP.View view;


    public MainPresenter(MainMVP.View view) {
        this.view = view;
    }



    @Override
    public void loadJson() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<Item>> call =api.getItems();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item>items =response.body();
                List<Item> newList = new ArrayList<>();
                for(Item item:items){
                    newList.add(item);
                }
                view.showData(newList);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });

    }
}
