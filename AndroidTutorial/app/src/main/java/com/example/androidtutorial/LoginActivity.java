package com.example.androidtutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

//        TẠO ĐỐI TƯỢNG TỪ KHUÔN Student
//
//        Student sv1 ; //B1: KHAI BÁO:
//        sv1 = new Student(); //B2: KHỞI TẠO:
//
//        //B3: GÁN GIÁ TRỊ:
//        sv1.name = "Tú";
//        sv1.age = 22;
//        sv1.schoolName = "Nguyen Hue 2";
//        sv1.id = 1997;
//
//        Toast.makeText(this, sv1.schoolName, Toast.LENGTH_SHORT).show();
//
    }

    public void init() {
        // Khai bao cho nao~ biet dau la TextView co chu Hello
        TextView tvHello;

        // Khoi tao bang cach lien ket vs xml
        tvHello = findViewById(R.id.tv_hello);

        // Gan gia tri
        tvHello.setText("Hello");

        //Again
        final EditText edtPhoneNumber;
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtPhoneNumber.setHint("Your Phone Number");

        TextView tvLogIn;
        tvLogIn = findViewById(R.id.tv_login);
        tvLogIn.setText("Login");

        TextView tvLoginWithPn;
        tvLoginWithPn = findViewById(R.id.tv_login_with_pn);
        tvLoginWithPn.setText("Log in with your phone number");

        TextView tvLoginBtn;
        tvLoginBtn = findViewById(R.id.tv_login_btn);
        tvLoginBtn.setText("Log in");

        TextView tvSocialLogin;
        tvSocialLogin = findViewById(R.id.tv_social_login);
        tvSocialLogin.setText("With Socila Login");

        RelativeLayout rlLoginButton;
        rlLoginButton = findViewById(R.id.rl_login_btn);
        rlLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edtPhoneNumber.getText().toString();
                int phoneNumberChecker = phoneNumber.length();
                if (phoneNumberChecker > 9) {
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                    Intent intent;
                    intent = new Intent(LoginActivity.this, UpdateUserInfoActivity.class);
                    //thêm dữ liệu vào intent(nhét phoneNumber vào intent)
                    intent.putExtra("phoneNumberPassWord", phoneNumber);
                    intent.putExtra("name", "ThuanHV");

                    //Luu trang thai dang nhap
                    setLogin();


                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this, "Your phone number is too short", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void setLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("dekko", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogin", true);
        editor.apply();
    }
}
