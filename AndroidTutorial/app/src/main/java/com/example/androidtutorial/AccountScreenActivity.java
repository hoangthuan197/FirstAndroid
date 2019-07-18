package com.example.androidtutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class AccountScreenActivity extends AppCompatActivity {

    TextView tvName, tvPhoneNumber;
    RelativeLayout tvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);
        init();
        getData();
    }

    void init() {
        tvPhoneNumber = findViewById(R.id.tv_phoneNumber);
        tvName = findViewById(R.id.tv_name);
        tvLogout = findViewById(R.id.rl_logout_btn);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(AccountScreenActivity.this, LoginActivity.class);
                setLogout();
                startActivity(intent);
                finish();
            }
        });
    }

    void setLogout() {
        SharedPreferences sharedPreferences = getSharedPreferences("dekko", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogin", false);
        editor.apply();
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
            tvPhoneNumber.setText("("+phone+")");

            JSONArray listNewJSON = resultJSON.getJSONArray("listNew");
            JSONObject firstNewJSON = listNewJSON.getJSONObject(0);

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
