package com.example.hp.ecodriveapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hp.ecodriveapplication.models.UserDetails;
import com.example.hp.ecodriveapplication.models.Vehicles;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class vehicledetails extends Activity {
    private EditText vehicleCCEdt,vehicleRegEdt,vehicleNameEdt;
    private RadioGroup vehicleTypeRg,fuelTypeRg;
    private Button saveVehicleDetailsBtn;

    private FirebaseAuth firebaseAuth;
    private DocumentReference documentReference;
    private FirebaseFirestore firebaseFirestore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicledetails);

        vehicleCCEdt = findViewById(R.id.vehicleCC);
        vehicleRegEdt = findViewById(R.id.vehicleRegisterationNo);
        vehicleNameEdt = findViewById(R.id.vehicleName);
        vehicleTypeRg = findViewById(R.id.vehicleType);
        fuelTypeRg = findViewById(R.id.fuelType);
        saveVehicleDetailsBtn = findViewById(R.id.saveVehicleDetails);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        saveVehicleDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton vtypebtn = findViewById(vehicleTypeRg.getCheckedRadioButtonId());
                RadioButton ftypebtn = findViewById(fuelTypeRg.getCheckedRadioButtonId());

                if(vtypebtn!=null && ftypebtn!=null && !vehicleCCEdt.getText().toString().equals("")
                        && !vehicleRegEdt.getText().toString().equals("") && !vehicleNameEdt.getText().toString().equals("")) {
                    String vType = vtypebtn.getText().toString();
                    String fType = ftypebtn.getText().toString();
                    int cc = Integer.parseInt(vehicleCCEdt.getText().toString());
                    String vReg = vehicleRegEdt.getText().toString();
                    String vName = vehicleNameEdt.getText().toString();

                    Vehicles vehicleObj = new Vehicles(fType,vType,cc,vName,vReg);
                    addVehicle(vehicleObj);
                    Intent intent = new Intent(vehicledetails.this,circlequery.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Fields Empty !",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void addVehicle(Vehicles vehicleObj)
    {
        documentReference = firebaseFirestore.collection("User List")
                .document(firebaseAuth.getCurrentUser().getUid())
                .collection("Vehicle List")
                .document(vehicleObj.getVehicleRegistrationNo());
        documentReference.set(vehicleObj);
    }
}
