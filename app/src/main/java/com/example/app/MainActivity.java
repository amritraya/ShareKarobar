package com.example.app;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Fragment.HomeFrag; 
import Fragment.MarketFrag;


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
        }
        if(fragmentnav != null){
            loadFragment(fragmentnav);
        }
        return true;
    }
    void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout,fragment).commit();
    }
    
}
