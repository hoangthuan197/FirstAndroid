package winds.com.androidtutorial.recyclerview.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListUsefulPhoneResponse {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("result")
    @Expose
    public List<UsefulPhone> result = null;
    @SerializedName("message")
    @Expose
    public String message;

}