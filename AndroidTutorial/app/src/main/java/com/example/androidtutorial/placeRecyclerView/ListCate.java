package com.example.androidtutorial.placeRecyclerView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListCate {

@SerializedName("categoryID")
@Expose
public Integer categoryID;
@SerializedName("name")
@Expose
public String name;
@SerializedName("urlCategory")
@Expose
public String urlCategory;
@SerializedName("type")
@Expose
public Integer type;

}