package com.example.androidtutorial.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidtutorial.R;
import com.example.androidtutorial.recyclerView.History;
import com.example.androidtutorial.recyclerView.HistoryAdapter;
import com.example.androidtutorial.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    RecyclerView rvHistory;
    ArrayList<History> data = new ArrayList<>();
    View vRoot;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vRoot = inflater.inflate(R.layout.fragment_history, container, false);
        init();
        prepareData();
        configRv();
        return vRoot;
    }

    void init() {
        rvHistory = vRoot.findViewById(R.id.rv_history);
    }

    void prepareData() {

        //doc json
        JSONObject jsonHistory = Utils.fileToJson(R.raw.history, getActivity());

        try {
            //lay jssonarray : result
            JSONArray jsonArrayResult = jsonHistory.getJSONArray("result");

            //for jsonarray ==> lay tung json ==> history
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                JSONObject jsonObject = jsonArrayResult.getJSONObject(i);
                String title = jsonObject.getString("title");
                String icon = jsonObject.getString("icon");
                int point = jsonObject.getInt("point");
                History history = new History(icon, title, point);

                //add tung doi tuong history vua tao vao data
                data.add(history);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void configRv() {
        HistoryAdapter historyAdapter = new HistoryAdapter();
        historyAdapter.data = data;
        historyAdapter.context = getActivity();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.setAdapter(historyAdapter);
    }

}
