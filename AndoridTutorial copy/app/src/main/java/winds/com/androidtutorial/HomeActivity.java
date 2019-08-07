package winds.com.androidtutorial;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {

    TextView tvName, tvPhone, tvFirstTitle;
    ImageView imgFirstNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        getData();
    }

    void init() {
        tvName = findViewById(R.id.tv_name);
        tvPhone = findViewById(R.id.tv_phone);
        imgFirstNews = findViewById(R.id.img_first_news);
        tvFirstTitle = findViewById(R.id.tv_first_title);
    }

    void getData() {
        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.home);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            JSONObject homeJSON = stringToJson(strData);
            JSONObject resultJSON = homeJSON.getJSONObject("result");
            JSONObject cusDetailJSON = resultJSON.getJSONObject("customerDetail");

            String phone = cusDetailJSON.getString("phone");
            String name = cusDetailJSON.getString("customerName");

            tvName.setText(name);
            tvPhone.setText("("+phone+ ")");


            JSONArray listNewJSON = resultJSON.getJSONArray("listNews");
            JSONObject firstNewsJSON = listNewJSON.getJSONObject(0);
            String urlImage = firstNewsJSON.getString("urlImage");
            tvFirstTitle.setText(firstNewsJSON.getString("title"));
            Picasso.get().load(urlImage).into(imgFirstNews);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    JSONObject stringToJson(String strData) {
        JSONObject homeJson;
        try {
            homeJson = new JSONObject(strData);
            return homeJson;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
