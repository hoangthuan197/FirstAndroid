package winds.com.androidtutorial.recyclerview.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryResult {

@SerializedName("listCate")
@Expose
public List<Category> listCate = null;

}