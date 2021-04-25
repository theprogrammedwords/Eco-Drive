package com.example.hp.ecodriveapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
public class circlerank extends Fragment {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    ListView list ;
    public circlerank() {
        // Required empty public constructor
    }
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] maintitle = {
                "Circle 1", "Circle 2",
                "Circle 3", "Circle 4",
                "Circle 5",
        };

        String[] subtitle = {
                "Members : ", "Members :",
                "Members :", "Members :",
                "Members :",
        };

        Integer[] imgid = {
                R.drawable.user, R.drawable.user,
                R.drawable.user, R.drawable.user, R.drawable.user,
        };

        Integer[] bdgid =
                {
                        R.drawable.userbadge, R.drawable.userbadge,
                        R.drawable.userbadge, R.drawable.userbadge, R.drawable.userbadge,
                };


        myListView adapter = new myListView(getActivity(), maintitle, subtitle, imgid, bdgid);
        View rootView = inflater.inflate(R.layout.fragment_circlerank, container, false);
        list = (ListView)rootView.findViewById(R.id.circlelist);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    //code specific to first list item
                    Toast.makeText(getContext(), "Place Your First Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getContext(), "Place Your Second Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {

                    Toast.makeText(getContext(), "Place Your Third Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {

                    Toast.makeText(getContext(), "Place Your Forth Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {

                    Toast.makeText(getContext(), "Place Your Fifth Option Code", Toast.LENGTH_SHORT).show();
                }

            }
        });



        return rootView;


    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView list = (ListView) getView().findViewById(R.id.circlelist);

    }

}