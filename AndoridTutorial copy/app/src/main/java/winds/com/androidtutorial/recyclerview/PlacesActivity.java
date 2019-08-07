package winds.com.androidtutorial.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.model.ListPlaceResponse;
import winds.com.androidtutorial.recyclerview.model.Place;
import winds.com.androidtutorial.recyclerview.network.RetrofitClient;
import winds.com.androidtutorial.recyclerview.network.ServiceAPI;

public class PlacesActivity extends AppCompatActivity {
    RecyclerView rvPlace;
    ArrayList<Place> data = new ArrayList<>();
    PlaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        init();
        prepareData();

    }

    void init() {
        rvPlace = findViewById(R.id.rv_place);
    }

    void prepareData() {
        // lay du lieu tu file json co san
//        JSONObject placeJson = Util.fileToJson(R.raw.places, this);

        // len server va lay du lieu

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cateID", 0);
            jsonObject.put("placeID", 0);
            jsonObject.put("searchKey", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        RetrofitClient.getRetrofitClient().create(ServiceAPI.class).getListPlace(jsonObject)
                .enqueue(new Callback<ListPlaceResponse>() {
                    @Override
                    public void onResponse(Call<ListPlaceResponse> call, Response<ListPlaceResponse> response) {
                        data.addAll(response.body().result);
                        configRV();
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
//                        // truong hop thanh cong
//                        try {
//                            String res = response.body().string();
//                            JSONObject placeJson = new JSONObject(res);
//                            JSONArray jsonArrayResult = placeJson.getJSONArray("result");
//                            for (int i = 0; i < jsonArrayResult.length(); i++) {
//                                JSONObject jsonPlace = jsonArrayResult.getJSONObject(i);
//                                String placeName = jsonPlace.getString("placeName");
//                                int isMoreDetail = jsonPlace.getInt("isMoreDetail");
//                                int isPromotion = jsonPlace.getInt("isPromotion");
//                                Place place = new Place(placeName, isMoreDetail, isPromotion);
//                                data.add(place);
//                            }
//                            configRV();
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        // truong hop that bai
//                    }
//                });

    }

    void configRV() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPlace.setLayoutManager(linearLayoutManager);
        adapter = new PlaceAdapter(data, this);
        rvPlace.setAdapter(adapter);

    }

}
