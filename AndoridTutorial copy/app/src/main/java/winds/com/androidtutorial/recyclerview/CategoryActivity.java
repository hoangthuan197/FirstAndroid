package winds.com.androidtutorial.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.model.Category;
import winds.com.androidtutorial.recyclerview.model.CategoryResponse;
import winds.com.androidtutorial.recyclerview.model.ListUsefulPhoneResponse;
import winds.com.androidtutorial.recyclerview.network.RetrofitClient;
import winds.com.androidtutorial.recyclerview.network.ServiceAPI;

public class CategoryActivity extends AppCompatActivity {

    ArrayList<Category> data = new ArrayList<>();
    RecyclerView rvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        init();
        getData();
    }

    void init(){
        rvCategory = findViewById(R.id.rv_category);
    }

    void getData(){
        RetrofitClient.getRetrofitClient().create(ServiceAPI.class)
                .getCategory().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                Log.d("", "onResponse: ");

                data.addAll(response.body().result.listCate);
                configRV();
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Log.d("", "onResponse: ");
            }
        });
    }

    void configRV(){
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(this,4);
        rvCategory.setLayoutManager(gridLayoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(data,this);
        rvCategory.setAdapter(categoryAdapter);
    }

}
