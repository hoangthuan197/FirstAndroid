package winds.com.androidtutorial.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.PlaceAdapter;
import winds.com.androidtutorial.recyclerview.model.ListPlaceResponse;
import winds.com.androidtutorial.recyclerview.model.Place;
import winds.com.androidtutorial.recyclerview.network.RetrofitClient;
import winds.com.androidtutorial.recyclerview.network.ServiceAPI;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment {


    RecyclerView rvPlace;
    ArrayList<Place> data = new ArrayList<>();
    PlaceAdapter adapter;
    View vRoot;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vRoot = inflater.inflate(R.layout.fragment_place, container, false);
        init();
        prepareData();
        return  vRoot;
    }


    void init() {
        rvPlace = vRoot.findViewById(R.id.rv_place);
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


    }

    void configRV() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvPlace.setLayoutManager(linearLayoutManager);
        adapter = new PlaceAdapter(data, getActivity());
        rvPlace.setAdapter(adapter);

    }

}
