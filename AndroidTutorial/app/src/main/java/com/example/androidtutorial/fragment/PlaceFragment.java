package com.example.androidtutorial.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidtutorial.R;
import com.example.androidtutorial.placeRecyclerView.ListPlaceResponse;
import com.example.androidtutorial.placeRecyclerView.Places;
import com.example.androidtutorial.placeRecyclerView.PlacesAdapter;
import com.example.androidtutorial.placeRecyclerView.ServiceAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceFragment extends Fragment {

    RecyclerView rvPlaces;
    ArrayList<Places> data = new ArrayList<>();
    View vRoot ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vRoot = inflater.inflate(R.layout.fragment_place, container, false);
        init();
        prepareData();
        return vRoot;
    }
    void init() {
        rvPlaces = vRoot.findViewById(R.id.rv_places);
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
                        Log.d("", "onFailure: ");
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
        placesAdapter.context = getActivity();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvPlaces.setLayoutManager(linearLayoutManager);
        rvPlaces.setAdapter(placesAdapter);
    }
}
