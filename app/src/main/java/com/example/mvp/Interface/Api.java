package com.example.mvp.Interface;

import com.example.mvp.Model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.myjson.com/bins/";
    @GET("j4ytq")
    Call<List<Item>> getItems();
}
