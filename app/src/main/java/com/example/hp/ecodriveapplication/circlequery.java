package com.example.hp.ecodriveapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.core.FirestoreClient;

public class circlequery extends Activity {
    Button create, join;
    LinearLayout ll;
    EditText input;
    Button submit;
    LinearLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circlequery);

        ll = (LinearLayout) findViewById(R.id.linearLayout);

        create = findViewById(R.id.create);
        join = findViewById(R.id.join);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(circlequery.this,createCircle.class);
                startActivity(intent);
                finish();
            }
        });
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll.removeAllViews();


                input = new EditText(circlequery.this);
                input.setHint("Enter circle ID");
                input.setVisibility(View.VISIBLE);

                ll.addView(input);

                submit = new Button(circlequery.this);
                submit.setText("Submit");
                submit.setVisibility(View.VISIBLE);
                submit.setBackgroundResource(R.drawable.greenbutton);
                ll.addView(submit);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),homeScreen.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
    }
}