package com.example.androidtutorial.recyclerView;

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

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;
    ArrayList<History> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        init();
        prepareData();
        configRv();
    }

    void init() {
        rvHistory = findViewById(R.id.rv_history);
    }

    void prepareData() {

        //doc json
        JSONObject jsonHistory = Utils.fileToJson(R.raw.history, this);

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
        historyAdapter.context = this;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.setAdapter(historyAdapter);
    }
}
