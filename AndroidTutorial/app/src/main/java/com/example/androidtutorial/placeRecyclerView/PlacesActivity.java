package com.example.androidtutorial.placeRecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.androidtutorial.R;
import com.example.androidtutorial.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlacesActivity extends AppCompatActivity {

    RecyclerView rvPlaces;
    ArrayList<Places> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        init();
        prepareData();
    }

    void init() {
        rvPlaces = findViewById(R.id.rv_places);
    }

    void prepareData() {

        //doc du lieu tu file json
//        JSONObject jsonPlaces = Utils.fileToJson(R.raw.places, this);

        //Len Server lay du liẹu
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cateID", 0);
            jsonObject.put("placeID", 0);
            jsonObject.put("searchKey", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();

        retrofit.create(ServiceAPI.class).getListPlace(jsonObject)
                .enqueue(new Callback<ListPlaceResponse>() {
                    @Override
                    public void onResponse(Call<ListPlaceResponse> call, Response<ListPlaceResponse> response) {
                        data.addAll(response.body().result);
                        configRv();
                    }

                    @Override
                    public void onFailure(Call<ListPlaceResponse> call, Throwable t) {

                    }
                });

//        retrofit.create(ServiceAPI.class).
//                getListPlace(jsonObject).
//                enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        try {
//                            String res = response.body().string();
//                            JSONObject jsonPlaces = new JSONObject(res);
//                            JSONArray jsonArrayResult = jsonPlaces.getJSONArray("result");
//                            for (int i = 0; i < jsonArrayResult.length(); i++) {
//                                JSONObject jsonObject = jsonArrayResult.getJSONObject(i);
//                                String placeName = jsonObject.getString("placeName");
//                                int isMoreDetail = jsonObject.getInt("isMoreDetail");
//                                int isPromotion = jsonObject.getInt("isPromotion");
//                                Places places = new Places(placeName, isMoreDetail, isPromotion);
//
//                                //add tung doi tuong history vua tao vao data
//                                data.add(places);
//                            }
//                            configRv();
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        //TH that bai
//                    }
//                });


//        try {
//            //lay jssonarray : result
//            JSONArray jsonArrayResult = jsonPlaces.getJSONArray("result");
//
//            //for jsonarray ==> lay tung json ==> history
//            for (int i = 0; i < jsonArrayResult.length(); i++) {
//                JSONObject jsonObject = jsonArrayResult.getJSONObject(i);
//                String placeName = jsonObject.getString("placeName");
//                int isMoreDetail = jsonObject.getInt("isMoreDetail");
//                int isPromotion = jsonObject.getInt("isPromotion");
//                Places places = new Places(placeName, isMoreDetail, isPromotion);
//
//                //add tung doi tuong history vua tao vao data
//                data.add(places);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
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
