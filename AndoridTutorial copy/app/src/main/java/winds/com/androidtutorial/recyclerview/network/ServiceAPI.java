package winds.com.androidtutorial.recyclerview.network;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import winds.com.androidtutorial.recyclerview.model.CategoryResponse;
import winds.com.androidtutorial.recyclerview.model.ListPlaceResponse;
import winds.com.androidtutorial.recyclerview.model.ListUsefulPhoneResponse;

public interface ServiceAPI {

    @POST("Service/GetListPlace")
    Call<ListPlaceResponse> getListPlace(@Body JSONObject body);

    @POST("Service/GetListContact")
    Call<ListUsefulPhoneResponse> getListUsefulPhone(@Body JSONObject body);

    @POST("Service/GetListCategoryAndBanner")
    Call<CategoryResponse> getCategory();

}
