package com.example.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {

    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        init();
        getData();
    }
    void init(){
        tvName = findViewById(R.id.tv_name);
    }

    void getData(){
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        tvName.setText(user.name);
    }

}
