package com.example.hp.ecodriveapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.ecodriveapplication.models.UserDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class signUpActivity extends Activity {
    private FirebaseAuth firebaseAuth;
    Button signUp;
    EditText userName, userEmailID, userPassword, confirmUserPassword;
    Intent intent;
    private UserDetails userDetails;
    private FirebaseFirestore firebaseFirestore;
    private DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        userName = findViewById(R.id.nameField);
        userEmailID = findViewById(R.id.emailField);
        userPassword = findViewById(R.id.passwordField);
        confirmUserPassword = findViewById(R.id.confirmPassword);
        signUp = findViewById(R.id.signupButton);
        userDetails=UserDetails.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = userName.getText().toString();
                String emailId = userEmailID.getText().toString();
                String password = userPassword.getText().toString();
                String confirmPassword = confirmUserPassword.getText().toString();
                if (password.equals(confirmPassword))
                    createUser(emailId,password);
            }
        });
    }

    private void createUser(final String emailId,final String password) {
        firebaseAuth.createUserWithEmailAndPassword(emailId, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registered Successfully !", Toast.LENGTH_SHORT).show();
                    documentReference = firebaseFirestore.collection("User List").document(firebaseAuth.getCurrentUser().getUid());
                    userDetails.setUserId(firebaseAuth.getCurrentUser().getUid());
                    userDetails.setEmailAddress(firebaseAuth.getCurrentUser().getEmail());
                    userDetails.updateFirestoreInstance(documentReference);
                    signInUser(emailId,password);

                } else {
                    Toast.makeText(getApplicationContext(), "Registration not completed !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void signInUser(String emailId, String password) {
        firebaseAuth.signInWithEmailAndPassword(emailId, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getBaseContext(), "Sign In Successful", Toast.LENGTH_SHORT).show();
                    intent = new Intent(signUpActivity.this, registerActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getBaseContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signUpActivity.this, loginActivity.class);
                    startActivity(intent);
                }
            }
        });



    }
}
