package com.example.hp.ecodriveapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hp.ecodriveapplication.R;
import com.example.hp.ecodriveapplication.models.Constants;

public class commuteFragment extends Fragment {


    public static commuteFragment newInstance(){
        commuteFragment commutefragment = new commuteFragment();
        return commutefragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button poolingButton, publicTrans, liveTrack;
        View rootview = inflater.inflate(R.layout.fragment_commute, container, false);

        poolingButton = (Button)rootview.findViewById(R.id.pooling);
        publicTrans = (Button)rootview.findViewById(R.id.publictrans);
        liveTrack = (Button) rootview.findViewById(R.id.livetrack);
        poolingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = Constants.context.getPackageManager().getLaunchIntentForPackage("com.example.newpoolingmodule");
                startActivity(i);
            }
        });

        publicTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = Constants.context.getPackageManager().getLaunchIntentForPackage("com.example.nearbyplaces");
                startActivity(i);
            }
        });

        liveTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = Constants.context.getPackageManager().getLaunchIntentForPackage("com.example.ecodrive.gmap");
                startActivity(i);
            }
        });

        return rootview;
    }

}
