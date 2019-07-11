package com.example.androidtutorial;

import java.io.Serializable;

public class User implements Serializable {
    String name, phoneNumber, dOB, email, province;

    public User( String name, String phoneNumber, String dOB, String email,String province){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.province = province;
        this.email = email;
        this.dOB = dOB;
    }
}
