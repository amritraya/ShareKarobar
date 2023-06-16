package com.example.app.userProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.app.MainActivity;
import com.example.app.R;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        //initializing AppCompatButton
        final AppCompatButton backButton = findViewById(R.id.back_Button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navigate back to MainActivity
                Intent backHome = new Intent(UserProfile.this, MainActivity.class);
                startActivity(backHome);
            }
        });
    }

}
