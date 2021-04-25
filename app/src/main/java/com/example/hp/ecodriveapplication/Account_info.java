package com.example.hp.ecodriveapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class Account_info extends AppCompatActivity {

    ImageView iv_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_info);

        iv_edit = (ImageView) findViewById(R.id.iv_edit);

        iv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),registerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}