package com.example.hp.ecodriveapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class circlePreview extends AppCompatActivity {

    ArrayList<circleData> CData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        RecyclerView rvCircle = (RecyclerView) findViewById(R.id.rvCircleData);

        CData = circleData.createCircleData(12);
        circleAdapter cAdapter = new circleAdapter(CData);
        rvCircle.setAdapter(cAdapter);
        rvCircle.setLayoutManager(new GridLayoutManager(this,2));

    }
}
