package com.example.androidtutorial.placeRecyclerView;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPlaceResponse {

@SerializedName("status")
@Expose
public Integer status;
@SerializedName("code")
@Expose
public Integer code;
@SerializedName("result")
@Expose
public List<Places> result = null;
@SerializedName("message")
@Expose
public String message;

}