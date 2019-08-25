package com.maku.zawaditestapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maku.zawaditestapp.R;
import com.maku.zawaditestapp.adapter.MyRecyclerViewAdapter;
import com.maku.zawaditestapp.model.formules;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;
    ArrayList<formules> formularModelArraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         formularModelArraylist =  new ArrayList<>();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyRecyclerViewAdapter(MainActivity.this, formularModelArraylist);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        
        //get the json data
        getJsonFileFromLocally();

    }

    private void getJsonFileFromLocally() {

        try {

            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());

            JSONArray jsonArray = jsonObject.getJSONArray("formules");                  //TODO pass array object name
            Log.e("fotmular", "m_jArry -->" + jsonArray.length());


            for (int i = 0; i < jsonArray.length(); i++)
            {
                formules formulesModel = new formules();

                JSONObject jsonObjectEmployee = jsonArray.getJSONObject(i);


                String formule = jsonObjectEmployee.getString("formule");
                String url = jsonObjectEmployee.getString("url");

                formulesModel.setFormule(""+formule);
                formulesModel.setUrl(""+url);

                formularModelArraylist.add(formulesModel);

            }       // for

            if(formularModelArraylist!=null) {
                adapter.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String loadJSONFromAsset() {

        String json = null;
        try {
            InputStream is = MainActivity.this.getAssets().open("data.json");       //TODO Json File  name from assets folder
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

}