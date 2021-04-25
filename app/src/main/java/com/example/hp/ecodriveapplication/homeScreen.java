package com.example.hp.ecodriveapplication;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.ecodriveapplication.R;
import com.example.hp.ecodriveapplication.models.Constants;
import com.example.hp.ecodriveapplication.models.UserDetails;
import com.google.firebase.auth.FirebaseAuth;

public class homeScreen extends AppCompatActivity {

    TextView mTextMessage;

    Fragment selectedFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        Constants.context=getApplicationContext();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        mTextMessage = findViewById(R.id.text);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("Navigation", "detected");
                switch (item.getItemId()) {
                    case R.id.navigation_stats:
                        Log.d("Navi", "Stats");
                        selectedFragment = statsFragment.newInstance();
                        break;

                    case R.id.navigation_commute:
                        Log.d("Navi", "Commute");
                        selectedFragment = commuteFragment.newInstance();
                        break;

                    case R.id.navigation_circles:
                        Log.d("Navi", "Circles");
                        selectedFragment = circleFragment.newInstance();
                        break;

                    case R.id.navigation_leaderboard:
                        Log.d("Navi", "LeaderBoard");
                        selectedFragment = leaderboardFragment.newInstance();
                        break;

                    case R.id.navigation_profile:
                        selectedFragment = settingsFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, statsFragment.newInstance());
        transaction.commit();

    }
    boolean back = false;
    @Override
    public void onBackPressed() {
        if (back) {
            super.onBackPressed();

            return;
        }

        this.back = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

    }

}

