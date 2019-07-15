package com.example.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccountScreenActivity extends AppCompatActivity {

    TextView tvName, tvPhoneNumber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);
        init();
        getData();
    }
    void init(){
        tvPhoneNumber = findViewById(R.id.tv_phoneNumber);
        tvName = findViewById(R.id.tv_name);
    }

    void getData(){
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        tvName.setText(user.name);
        tvPhoneNumber.setText(user.phoneNumber);
    }

}
