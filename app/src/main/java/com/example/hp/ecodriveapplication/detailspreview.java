package com.example.hp.ecodriveapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class detailspreview extends Activity {
    Button save, add, skip;
    LinearLayout ll;
    Button create, join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailspreview);
        save = findViewById(R.id.home);
        add = findViewById(R.id.addvehicle);
        skip = findViewById(R.id.skip);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),homeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),vehicledetails.class);
                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),circlequery.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
