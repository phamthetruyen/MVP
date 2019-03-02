package com.example.mvp.Interface;

import com.example.mvp.Model.Item;

import java.util.List;

public interface MainMVP {
    interface  View{
         void showData(List<Item> newList);

    }
    interface Presenter{
        void loadJson();
    }
}
