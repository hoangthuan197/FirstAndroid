package winds.com.androidtutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    }

    void init() {
        //B1 Khai bao cho nao biet dau la cai textview co chu hello
        TextView tvHello;
        //B2 Khoi tao bang cach lien ket vs xml
        tvHello = findViewById(R.id.tv_hello);
        //B3 Gan gia tri
        tvHello.setText("Hello");

        final EditText edtPhoneNumber;
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtPhoneNumber.setText("");

        RelativeLayout rlLoginButton;
        rlLoginButton = findViewById(R.id.rl_login_button);
        rlLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edtPhoneNumber.getText().toString();
                int phoneNumberLength = phoneNumber.length();
                if (phoneNumberLength > 9) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                    Intent intent;
                    intent = new Intent(LoginActivity.this, UpdateUserInfoActivity.class);
                    // them du lieu vao trong intent (nhet thang phoneNumber vào itent)
                    intent.putExtra("phoneNumberPassWord", phoneNumber);
                    intent.putExtra("name", "ThangNT");
                    // Luu trang thai dang nhap
                    setLogin();
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Của bạn quá ngắn", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void setLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("dekko", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogin",true);
        editor.apply();
    }
}
