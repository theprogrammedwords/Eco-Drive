package com.example.hp.ecodriveapplication;

import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

import com.example.hp.ecodriveapplication.About_Us;
import com.example.hp.ecodriveapplication.FAQ;
import com.example.hp.ecodriveapplication.R;

public class Help_center  extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_center);

        listView = (ListView) findViewById(R.id.listview_help_center);
        String[] values = new String[]{"FAQ",
                "About Us"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.helpcenter_list, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), FAQ.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), About_Us.class);
                    startActivityForResult(myIntent, 0);
                }

            }
        });
    }
}