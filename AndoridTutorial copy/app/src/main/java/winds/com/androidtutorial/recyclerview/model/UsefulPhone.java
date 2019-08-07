package winds.com.androidtutorial.recyclerview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsefulPhone {

@SerializedName("contactID")
@Expose
public Integer contactID;
@SerializedName("name")
@Expose
public String name;
@SerializedName("phone")
@Expose
public String phone;
@SerializedName("description")
@Expose
public String description;

}