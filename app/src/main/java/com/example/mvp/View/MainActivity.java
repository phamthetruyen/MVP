package com.example.mvp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mvp.Model.Item;
import com.example.mvp.Presenter.ItemAdapter;
import com.example.mvp.Interface.MainMVP;
import com.example.mvp.Presenter.MainPresenter;
import com.example.mvp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainMVP.View, View.OnClickListener {

   private RecyclerView recyclerView;
   private  MainMVP.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        presenter.loadJson();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        presenter =  new MainPresenter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void showData(List<Item> newList) {
        recyclerView.setAdapter(new ItemAdapter(getApplicationContext(),newList));
        recyclerView.smoothScrollToPosition(0);

    }
}
