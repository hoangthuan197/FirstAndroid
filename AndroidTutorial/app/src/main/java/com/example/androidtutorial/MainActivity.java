package com.example.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //TẠO ĐỐI TƯỢNG TỪ KHUÔN Student
        
        Student sv1 ; //B1: KHAI BÁO:
        sv1 = new Student(); //B2: KHỞI TẠO:

        //B3: GÁN GIÁ TRỊ:
        sv1.name = "Tú";
        sv1.age = 22;
        sv1.schoolName = "Unknown";
        sv1.id = 1997;

        Toast.makeText(this, sv1.name, Toast.LENGTH_SHORT).show();
        
    }
}
