package com.example.androidtutorial.placeRecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidtutorial.R;
import com.example.androidtutorial.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {

    RecyclerView rvPlaces;
    ArrayList<Places> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        init();
        prepareData();
        configRv();
    }

    void init() {
        rvPlaces = findViewById(R.id.rv_places);
    }

    void prepareData() {

        //doc json
        JSONObject jsonPlaces = Utils.fileToJson(R.raw.places, this);

        try {
            //lay jssonarray : result
            JSONArray jsonArrayResult = jsonPlaces.getJSONArray("result");

            //for jsonarray ==> lay tung json ==> history
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                JSONObject jsonObject = jsonArrayResult.getJSONObject(i);
                String placeName = jsonObject.getString("placeName");
                int isMoreDetail = jsonObject.getInt("isMoreDetail");
                int isPromotion = jsonObject.getInt("isPromotion");
                Places places = new Places(placeName, isMoreDetail, isPromotion);

                //add tung doi tuong history vua tao vao data
                data.add(places);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void configRv() {
        PlacesAdapter placesAdapter = new PlacesAdapter();
        placesAdapter.data = data;
        placesAdapter.context = this;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPlaces.setLayoutManager(linearLayoutManager);
        rvPlaces.setAdapter(placesAdapter);
    }
}
