package com.example.hp.ecodriveapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/* A simple {@link Fragment} subclass.
 */
public class leaderboardFragment extends Fragment {

    public static leaderboardFragment newInstance()
    {
        leaderboardFragment leaderboardfragment = new leaderboardFragment();
        return leaderboardfragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        Button viewRank = rootView.findViewById(R.id.viewrank);
        Button shareRank = rootView.findViewById(R.id.shareRank);
        Button viewRewards = rootView.findViewById(R.id.viewRewards);

        shareRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,"My ranking is ");
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
            }
        });

        viewRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), tabbedrankings.class);
                startActivity(intent);
            }
        });

        viewRewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewRewards.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}
