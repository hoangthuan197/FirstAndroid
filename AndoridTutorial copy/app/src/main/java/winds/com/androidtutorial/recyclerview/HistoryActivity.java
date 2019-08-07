package winds.com.androidtutorial.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.model.History;
import winds.com.androidtutorial.util.Util;

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


        // Doc file history.json
        JSONObject jsonHistory = Util.fileToJson(R.raw.history, this);


        try {
            // lay Jsonarray : result
            JSONArray jsonArrayResult = jsonHistory.getJSONArray("result");

            // for jsonArray -> lay tung tung json  => History
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                JSONObject jsonObject = jsonArrayResult.getJSONObject(i);
                String title = jsonObject.getString("title");
                String icon = jsonObject.getString("icon");
                int point = jsonObject.getInt("point");
                History history = new History(title, icon, point);

                // add doi tuong history vua tao vao data
                data.add(history);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("", "prepareData: ");
    }

    void configRv() {
        HistoryAdapter historyAdapter = new HistoryAdapter();
        historyAdapter.data = data;
        historyAdapter.context = this;

        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false);

        rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.setAdapter(historyAdapter);
    }

    void justForFun() {
        int a = 1;
        int b = 2;
        int c = 3;

        a = b; // 2
        c = b; // 5
        b = 5; // 2

        Log.d("aaa", "justForFun: ");


        History ha = new History("a", 1);
        History hb = new History("b", 2);
        History hc = new History("c", 3);

        ha = hb; // 2
        hc = hb; // 5
//        hb.point = 5; // 2


        Log.d("aaa", "justForFun: ");


    }


}
