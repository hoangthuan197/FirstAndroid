package winds.com.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateUserInfoActivity extends AppCompatActivity {

    EditText edtPhoneNumber, edtName, edtDOB, edtProvince, edtEmail;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);
        init();
        getData();
    }

    void init() {

        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtName = findViewById(R.id.edt_name);
        edtDOB = findViewById(R.id.edt_dob);
        edtProvince = findViewById(R.id.edt_province);
        edtEmail = findViewById(R.id.edt_email);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareData();
            }
        });
    }

    void prepareData() {
        // tao doi tuong user

        User user;

        // lay cac gia tri ma nguoi dung nhap vao
        String name = edtName.getText().toString();
        String province = edtProvince.getText().toString();
        String dob = edtDOB.getText().toString();
        String email = edtEmail.getText().toString();
        String phoneNumber = edtPhoneNumber.getText().toString();
        user = new User(name, phoneNumber, dob, email, province);
        Intent intent;
        intent = new Intent(UpdateUserInfoActivity.this, HomeActivity.class);
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
