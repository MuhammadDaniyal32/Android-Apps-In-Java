package com.example.cardview_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<Data_class.FlowerData> mFlowerList;
    Data_class.FlowerData mFlowerData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mFlowerList = new ArrayList<>();
        mFlowerData = new Data_class.FlowerData("Rose", getString(R.string.description_flower_rose),
                R.drawable.bambore);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Carnation", getString(R.string.description_flower_carnation),
                R.drawable.deosai);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Tulip", getString(R.string.description_flower_tulip),
                R.drawable.fairy);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Daisy", getString(R.string.description_flower_daisy),
                R.drawable.kaghan);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Sunflower", getString(R.string.description_flower_sunflower),
                R.drawable.hango);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Daffodil", getString(R.string.description_flower_daffodil),
                R.drawable.skardu);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Gerbera", getString(R.string.description_flower_gerbera),
                R.drawable.passu);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Orchid", getString(R.string.description_flower_orchid),
                R.drawable.bambore);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Iris", getString(R.string.description_flower_iris),
                R.drawable.fairy);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Lilac", getString(R.string.description_flower_lilac),
                R.drawable.kaghan);
        mFlowerList.add(mFlowerData);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, mFlowerList);
        mRecyclerView.setAdapter(myAdapter);

    }

}