package com.example.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class UpdateUserInfoActivity extends AppCompatActivity {

    EditText edtPhoneNumber, edtName, edtDOB, edtProvince, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);
        init();
        getData();
    }

    public void init() {
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtName = findViewById(R.id.edt_name);
        edtDOB = findViewById(R.id.edt_dob);
        edtProvince = findViewById(R.id.edt_province);
        edtEmail = findViewById(R.id.edt_email);


        RelativeLayout rlAgreeButton;
        rlAgreeButton = findViewById(R.id.rl_agree_btn);
        rlAgreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareData();
            }
        });
    }

    void prepareData() {
        //tao doi tuong user

        User user;


        //lay cac gia tri nguoi dung nhap vap
        String name = edtName.getText().toString();
        String phoneNumber = edtPhoneNumber.getText().toString();
        String province = edtProvince.getText().toString();
        String email = edtEmail.getText().toString();
        String dOB = edtDOB.getText().toString();

        //gan gia tri
        user = new User(name, phoneNumber, dOB, email, province);

//        user.name = name;
//        user.province = province;
//        user.phoneNumber = phoneNumber;
//        user.email = email;
//        user.dOB = dob;
//

        //nem vao intent

        Intent intent;
        intent = new Intent(UpdateUserInfoActivity.this, AccountScreenActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);

        finish();

    }


    void getData() {
        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("phoneNumberPassWord");
        edtPhoneNumber.setText(phoneNumber);
    }


}