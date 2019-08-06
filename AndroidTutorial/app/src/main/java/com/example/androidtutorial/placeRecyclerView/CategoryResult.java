package com.example.androidtutorial.placeRecyclerView;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryResult {

@SerializedName("listCate")
@Expose
public List<CategoryResponse> listCate = null;

}