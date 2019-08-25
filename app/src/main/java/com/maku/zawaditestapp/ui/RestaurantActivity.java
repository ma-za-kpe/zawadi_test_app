package com.maku.zawaditestapp.ui;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maku.zawaditestapp.R;
import com.maku.zawaditestapp.adapter.MyRestaurantViewAdapt0er;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity implements MyRestaurantViewAdapt0er.ItemClickListener {

    private static final String TAG = "RestaurantActivity";

    MyRestaurantViewAdapt0er adapter;
    ArrayList<String> animalNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        // data to populate the RecyclerView with
        animalNames = new ArrayList<>();
        animalNames.add("Chicken Inn");
        animalNames.add("Pizza Inn");
        animalNames.add("Galito");
        animalNames.add("Steers");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRestaurantViewAdapt0er(RestaurantActivity.this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View v, int i) {
        Log.d(TAG, "onItemClick: you have clicked ");
    }
}
