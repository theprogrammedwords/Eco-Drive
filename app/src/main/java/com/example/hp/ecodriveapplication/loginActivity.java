package com.example.hp.ecodriveapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.ecodriveapplication.models.UserDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loginActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passEditText;
    private Button login;
    TextView newText;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;
    String email,password;
    UserDetails userDetails;


    //ActionBar title;
    Intent intent;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        context = getApplicationContext();
        FirebaseApp.initializeApp(context);
        firebaseAuth= FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        emailEditText = findViewById(R.id.usernameField);
        passEditText = findViewById(R.id.passwordField);
        login =  findViewById(R.id.loginButton);
        newText = findViewById(R.id.newuserlabel);
        userDetails = UserDetails.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                login.setVisibility(View.INVISIBLE);
                email = emailEditText.getText().toString();
                password = passEditText.getText().toString();

                if(email.isEmpty()){
                    emailEditText.setError("Invalid Email");
                }
                if(password.isEmpty()){
                    passEditText.setError("Password cannot be empty");
                }
                else if(!(password.isEmpty() && email.isEmpty())){
                    signInUser(email,password);
                }
            }
        });

        newText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("OnClick","Detected");
                intent = new Intent(getApplicationContext(),signUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        /*FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Intent intent = new Intent(getBaseContext(),homeScreen.class);
            startActivity(intent);*/
        //}
    }


    private void signInUser(String emailId, String password) {

        firebaseAuth.signInWithEmailAndPassword(emailId, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    DocumentReference documentReference = firestore.collection("User List").document(firebaseAuth.getCurrentUser().getUid());

                    documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                            DocumentSnapshot docsnap = task.getResult();
                            if(docsnap!=null)
                            {
                                Log.d("NICKNAME",docsnap.get("nickName").toString());
                                userDetails.setNickName(docsnap.get("nickName").toString());
                            }
                        }
                    });


                    Toast.makeText(getBaseContext(), "Sign In Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), homeScreen.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

}