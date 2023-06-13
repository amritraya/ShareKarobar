package com.example.app.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.app.MainActivity;
import com.example.app.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //this method is called when timer ends
                Intent i=new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
                finish();
            }
        },3000);
    }
}
