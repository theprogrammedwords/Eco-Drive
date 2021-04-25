package com.example.hp.ecodriveapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hp.ecodriveapplication.R;


public class circleFragment extends Fragment {

    public static circleFragment newInstance(){
        circleFragment circlefragment = new circleFragment();
        return circlefragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        CardView createCircle, exploreCircle, myCircle;
        View rootView = inflater.inflate(R.layout.fragment_circle, container, false);
        createCircle =  (CardView)(rootView.findViewById(R.id.createCircle));
        exploreCircle = (CardView)(rootView.findViewById(R.id.explore));
        myCircle = (CardView) (rootView.findViewById(R.id.viewCircles));
        createCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("I AM HERE", "?");
                Intent intent = new Intent(getActivity(),createCircle.class);
                startActivity(intent);
            }
        });

        exploreCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("I AM HERE", "?");
                Intent intent = new Intent(getActivity(),exploreCircle.class);
                startActivity(intent);
            }
        });

        myCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),circlePreview.class );
                startActivity(intent);
            }
        });

    return rootView;
    }

}
