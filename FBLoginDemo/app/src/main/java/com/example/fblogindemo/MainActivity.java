package com.example.fblogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;

public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupFBLogin();
        setupGGLogin();
    }

    void  setupGGLogin(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

    }

     void setupFBLogin() {
        callbackManager = CallbackManager.Factory.create();

         LoginButton loginButton = findViewById(R.id.btn_fb_login);
         loginButton.setPermissions("email");
         loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
             @Override
             public void onSuccess(LoginResult loginResult) {
                 Toast.makeText(MainActivity.this, "Ơ rê ka ơ rê ka", Toast.LENGTH_SHORT).show();

             }

             @Override
             public void onCancel() {
                 Toast.makeText(MainActivity.this, "Tự cmn hủy !", Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onError(FacebookException error) {
                 Toast.makeText(MainActivity.this,"Lỗi !" , Toast.LENGTH_SHORT).show();
                 Log.d("err", error.toString());
             }
         });
     }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
