package com.maku.zawaditestapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maku.zawaditestapp.Intefaces.MyApiEndpointInterface;
import com.maku.zawaditestapp.POJO.Search;
import com.maku.zawaditestapp.POJO.Search;
import com.maku.zawaditestapp.POJO.SearchedByName;
import com.maku.zawaditestapp.R;
import com.maku.zawaditestapp.adapter.MyRestaurantViewAdapt0er;
import com.maku.zawaditestapp.adapter.RestaurantDetailAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "RestaurantDetailAct";

    //INTENT EXTRAS
    private String restaurant;

//  vars


//    widgets
    private TextView mTextViewName;
    private RecyclerView mRecyclerViewRest;
    RestaurantDetailAdapter mRestaurantDetailAdapter;
    private TextView mActivityHeading;
    private RelativeLayout mBackArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

//        initializa widgets
        mRecyclerViewRest = findViewById(R.id.restDetails);
        mBackArrow = findViewById(R.id.back_arrow);
        mActivityHeading = findViewById(R.id.fragment_heading);

        //restaurant
        restaurant = getIntent().getExtras().getString("restaurant");
        Log.d(TAG, "onCreate: restaurant " + restaurant);

        Toast.makeText(RestaurantDetailActivity.this, "rrr" + restaurant, Toast.LENGTH_LONG).show();

        getRestaurant(restaurant);
        initToolbar();
    }

    private void initToolbar() {
        Log.d(TAG, "initToolbar: initializing toolbar.");
        mBackArrow.setOnClickListener(this);
        mActivityHeading.setText(restaurant);
    }

    private void getRestaurant(String restaurant) {

        Log.d(TAG, "getRestaurant: name = " + restaurant);

        String url = "https://sleepy-garden-51801.herokuapp.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApiEndpointInterface service = retrofit.create(MyApiEndpointInterface.class);


        Call<Search> call = service.getByRestaurant(restaurant);
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, retrofit2.Response<Search> response) {

                Log.d(TAG, "onResponse: " + response);
                process(response);
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                Log.d("onFailure", t.toString());
                t.printStackTrace();
            }
        });

    }

    private void process(Response<Search> response) {

        List<SearchedByName> rest =  response.body().getSearchedByName();

        for (int y=0; y <rest.size(); y++) {
            Log.d(TAG, "process: items " + rest.get(y).getName());
            Log.d(TAG, "process: items " + rest.get(y).getCategory());
            Log.d(TAG, "process: items " + rest.get(y).getPrice());
        }

        mRecyclerViewRest.setLayoutManager(new LinearLayoutManager(this));
        mRestaurantDetailAdapter = new RestaurantDetailAdapter( rest, RestaurantDetailActivity.this);
        mRecyclerViewRest.setAdapter(mRestaurantDetailAdapter);

        Log.d(TAG, "process: " + response.body().getSearchedByName().size());

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_arrow) {

            Intent intent = new Intent(RestaurantDetailActivity.this, RestaurantActivity.class);
            startActivity(intent);


        }
    }
}