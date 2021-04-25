package com.example.hp.ecodriveapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.LineChartView;

public class footprintgraph extends AppCompatActivity {

    LineChartView lineChartView;
    Button viewsavings;

    String[] axisData = {"Mon", "Tue", "Wed", "Thurs", "Fri", "Sat", "Sun"};
    int[] yAxisData = {50, 20, 15, 30, 20, 60, 15};
    int[] speed = new int[]{40,55,45,63,48, 70, 65};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();


        Line line = new Line(yAxisValues).setColor(Color.parseColor("#84bc32"));
        viewsavings = findViewById(R.id.savings);
        lineChartView = findViewById(R.id.chart);

        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#677b14"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("Generated footprint");
        yAxis.setTextColor(Color.parseColor("#677b14"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 100;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);

        /*viewsavings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), savings.class);
                startActivity(intent);
            }
        });*/
    }

}

