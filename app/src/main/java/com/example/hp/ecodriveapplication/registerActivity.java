package com.example.hp.ecodriveapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hp.ecodriveapplication.models.User;
import com.example.hp.ecodriveapplication.models.UserDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import id.zelory.compressor.Compressor;


public class registerActivity  extends Activity {
    Button register;
    final static int requestCode=123;
    Uri imagePickerUri;
    ImageView addUserImage;
    ImageView userProfilePhoto;
    EditText nickNameEdt,phoneNoEdt;
    RadioGroup genderRg;
    private static final String TAG = registerActivity.class.getName();
    private FirebaseAuth firebaseAuth;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private DocumentReference documentReference;
    private FirebaseFirestore firebaseFirestore;
    UserDetails userDetails;
    Uri downloadUri;
    //private Bitmap compressed;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);
        register = findViewById(R.id.registerButton);
        addUserImage=findViewById(R.id.addImage);
        userProfilePhoto=findViewById(R.id.userImage);
        nickNameEdt = findViewById(R.id.nickName);
        phoneNoEdt = findViewById(R.id.phoneno);
        genderRg = findViewById(R.id.genderRg);
        firebaseAuth = FirebaseAuth.getInstance();
        userDetails = UserDetails.getInstance();
        storageReference=FirebaseStorage.getInstance().getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();

        addUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForPermission();
                //chooseImage();//check permission and pick image
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton genderbtn = findViewById(genderRg.getCheckedRadioButtonId());
                if(genderbtn!=null && !nickNameEdt.getText().toString().equals("") && !phoneNoEdt.getText().toString().equals("")) {
                    String nickname = nickNameEdt.getText().toString();
                    String phoneno = phoneNoEdt.getText().toString();
                    String gender = genderbtn.getText().toString();
                    if (!nickname.equals("") && !phoneno.equals("")) {
                        updateUserInfo(nickname, phoneno, gender);
                    }
                    Intent intent = new Intent(getApplicationContext(), detailspreview.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(),"Fields Empty !",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void chooseImage() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1, 1)
                .start(registerActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Log.d(TAG, "OnActivityResult");
                imagePickerUri = result.getUri();
                userProfilePhoto.setImageURI(imagePickerUri);
                //CompressImageAndUpload(imagePickerUri);

            }
        }
    }
    public void checkForPermission(){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else{
            chooseImage();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                chooseImage();
            }
        }
    }
    private void updateUserInfo(String nickname,String phoneNo,String gender)
    {
        documentReference = firebaseFirestore.collection("User List").document(firebaseAuth.getCurrentUser().getUid());
        userDetails.setNickName(nickname);
        userDetails.setPhoneNumber(phoneNo);
        userDetails.setGender(gender);
        userDetails.updateFirestoreInstance(documentReference);
        //code for image uri getDownloadurl goes here

//        storageReference.child("users_profile_photos/"+firebaseAuth.getCurrentUser().getUid()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                downloadUri=uri;
//                userProfilePhoto.setImageURI(downloadUri);
//                userDetails.updateFirestoreInstance(documentReference);
//                Log.d(TAG,"Download uri set");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                downloadUri=imagePickerUri;
//                userProfilePhoto.setImageURI(downloadUri);
//                userDetails.updateFirestoreInstance(documentReference);
//                Log.d(TAG,"original uri set "+exception.getMessage());
//            }
//        });
    }
    private void CompressImageAndUpload(final Uri imagePickerUri)
    {
        File newFile = new File(imagePickerUri.getPath());
        if(newFile!=null) {
            try {

                Bitmap compressed = new Compressor(this)
                        .setMaxHeight(125)
                        .setMaxWidth(125)
                        .setQuality(70)
                        .compressToBitmap(newFile);

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                compressed.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
                byte[] thumbData = byteArrayOutputStream.toByteArray();
                //Bitmap bitmap = BitmapFactory.decodeByteArray(thumbData, 0, thumbData.length);
                //userProfilePhoto.setImageBitmap(bitmap);
                UploadTask image_path = storageReference.child("user_profile_photos").child(firebaseAuth.getCurrentUser().getUid()).putBytes(thumbData);
                image_path.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "Image uploaded successfully !", Toast.LENGTH_SHORT).show();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getApplicationContext(), "(IMAGE Error) : " + error, Toast.LENGTH_LONG).show();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}