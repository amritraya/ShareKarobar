package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.app.splashScreen.SplashScreen;
import com.example.app.userProfile.UserProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.app.fragment.HomeFrag;
import com.example.app.fragment.MarketFrag;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //initializing View
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstancesState){
    super.onCreate(savedInstancesState);
    setContentView(R.layout.activity_main);

    bottomNavigationView=findViewById(R.id.bottonnav);
    bottomNavigationView.setOnNavigationItemSelectedListener(this);
    loadFragment(new HomeFrag());

    }
// Fragment Navigation
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        Fragment fragmentnav =null;
        switch(item.getItemId()){
            case R.id.home:
                fragmentnav= new HomeFrag();
                break;
            case R.id.market:
                fragmentnav= new MarketFrag();
                break;
            case R.id.profile:
                Intent userProfile=new Intent(MainActivity.this, UserProfile.class);
                startActivity(userProfile);
                break;
        }
        if(fragmentnav != null){
            loadFragment(fragmentnav);
        }
        return true;
    }
    //loading fragment view when click on specific item
    void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout,fragment).commit();
    }
    @Override
    public void onBackPressed(){
        FragmentManager fragmentManager =getSupportFragmentManager();
        Fragment fragment= fragmentManager.findFragmentById(R.id.home);

    }
    
}
