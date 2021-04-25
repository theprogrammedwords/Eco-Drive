package com.example.hp.ecodriveapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.ecodriveapplication.R;
import com.example.hp.ecodriveapplication.models.UserDetails;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class statsFragment extends Fragment {


    Button fprintstats, savingstats ;
    TextView mynametxt;
    public static statsFragment newInstance(){
        statsFragment statsfragment = new statsFragment();
        return statsfragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_stats, container, false);
        fprintstats = (Button) rootView.findViewById(R.id.viewfpstat);
        savingstats = (Button) rootView.findViewById(R.id.viewmsstat);
        mynametxt = (TextView) rootView.findViewById(R.id.name_tv);

        fprintstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),footprintgraph.class);
                startActivity(intent);
            }
        });

        savingstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),savings.class);
                startActivity(intent);
            }
        });

        return  rootView;
    }


}

