package com.example.hp.ecodriveapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.ecodriveapplication.models.Circle;
import com.example.hp.ecodriveapplication.models.User;
import com.example.hp.ecodriveapplication.models.UserDetails;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class createCircle extends AppCompatActivity {
        EditText circleName, cityName;
        Button invite, share, create;
        FirebaseFirestore firestore;
        UserDetails user;
        DocumentReference documentReference;
        Circle myCircle;

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        circleName = findViewById(R.id.circleName);
        cityName = findViewById(R.id.cityName);
        invite = findViewById(R.id.invite);
        share= findViewById(R.id.share);
        create = findViewById(R.id.create_Circle);
        user = UserDetails.getInstance();
        myCircle = new Circle();
        firestore = FirebaseFirestore.getInstance();
        create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        String cname = circleName.getText().toString();
                        String cyname = cityName.getText().toString();
                        if(circleName.equals(""))
                                circleName.setError("Field Empty");
                        if(cityName.equals(""))
                                cityName.setError("Field Empty");
                        if(!circleName.equals("") && !cityName.equals(""))
                        {
                                String circleId = "";
                                circleId = firestore.collection("Circle List").document().getId();
                                if(circleId!="") {
                                        documentReference = firestore.collection("Circle List").document(circleId);
                                        user.updateFirestoreInstance(documentReference);
                                        user.setCircleId(circleId);
                                        myCircle.setCircleId(circleId);
                                        myCircle.setCircleName(cname);
                                        myCircle.setCityName(cyname);
                                        myCircle.setMemberCount(myCircle.getMemberCount()+1);
                                        ArrayList<String> useridlist = myCircle.getUserIdList();
                                        useridlist.add(user.getUserId());
                                        myCircle.setUserIdList(useridlist);
                                        documentReference.set(myCircle);
                                }
                        }
                        Intent intent = new Intent(createCircle.this,homeScreen.class);
                        startActivity(intent);
                        finish();
                }
        });

    }
}