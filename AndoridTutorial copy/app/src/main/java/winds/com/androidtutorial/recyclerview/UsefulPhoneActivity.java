package winds.com.androidtutorial.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.model.ListUsefulPhoneResponse;
import winds.com.androidtutorial.recyclerview.model.UsefulPhone;
import winds.com.androidtutorial.recyclerview.network.RetrofitClient;
import winds.com.androidtutorial.recyclerview.network.ServiceAPI;

public class UsefulPhoneActivity extends AppCompatActivity {
    RecyclerView rvUsefulPhone;
    ArrayList<UsefulPhone> data = new ArrayList<>();
    UsefulPhoneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_phone);
        init();
        prepareData();

    }

    void init() {
        rvUsefulPhone = findViewById(R.id.rv_useful_phone);
    }

    void prepareData() {
        // lay du lieu tu file json co san
//        JSONObject placeJson = Util.fileToJson(R.raw.places, this);

        // len server va lay du lieu

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("contactID", 0);
            jsonObject.put("searchKey", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RetrofitClient.getRetrofitClient().create(ServiceAPI.class).getListUsefulPhone(jsonObject).enqueue(new Callback<ListUsefulPhoneResponse>() {
            @Override
            public void onResponse(Call<ListUsefulPhoneResponse> call, Response<ListUsefulPhoneResponse> response) {
                data.addAll(response.body().result);
                configRV();
            }

            @Override
            public void onFailure(Call<ListUsefulPhoneResponse> call, Throwable t) {

            }
        });

    }

    void configRV() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUsefulPhone.setLayoutManager(linearLayoutManager);
        adapter = new UsefulPhoneAdapter(data, this);
        rvUsefulPhone.setAdapter(adapter);

    }

}
