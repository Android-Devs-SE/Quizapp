package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    CircleImageView img;
    TextView username;
    Button submit;
    int PICKIMAGE = 12;
    Uri uri;
    FirebaseStorage firebaseStorage;
    ProgressDialog loadingBar;
    StorageReference storageReference;
    private String downloadUrl;
    private FirebaseAuth mAuth;
    private DatabaseReference UsersRef;
    String currentUserID;
    TextView skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        skip = findViewById(R.id.skip);

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);

        img = (CircleImageView) findViewById(R.id.img);
        username = (EditText) findViewById(R.id.username);
        submit = (Button) findViewById(R.id.submit);

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();

        loadingBar = new ProgressDialog(this);




        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PICKIMAGE);


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveUserInfo();

            }
        });

        retrieveuserinfo();


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

            super.onActivityResult(requestCode, resultCode, data);

            // checking request code and result code
            // if request code is PICK_IMAGE_REQUEST and
            // resultCode is RESULT_OK
            // then set image in the image view
            if (requestCode == PICKIMAGE
                    && resultCode == RESULT_OK
                    && data != null
                    && data.getData() != null) {

                // Get the Uri of data
                uri = data.getData();
                try {

                    // Setting image on image view using Bitmap
                    Bitmap bitmap = MediaStore
                            .Images
                            .Media
                            .getBitmap(
                                    getContentResolver(),
                                    uri);
                    img.setImageBitmap(bitmap);
                } catch (IOException e) {
                    // Log the exception
                    e.printStackTrace();
                }

            }

        }




    private void saveUserInfo() {


        final String getusername = username.getText().toString();
        if(uri == null){


            UsersRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).hasChild("image")) {

                        saveInfowithoutimage();


                    }else {



                        Toast.makeText(ProfileActivity.this, "Please select image", Toast.LENGTH_SHORT).show();

                    }

                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });



        }else if (getusername.equals("")){

            Toast.makeText(this, "Please Enter Your Username...", Toast.LENGTH_SHORT).show();

        }else {

            loadingBar.setTitle("Creating Account");
            loadingBar.setMessage("Please Wait...");
            loadingBar.show();

            final StorageReference filepath = storageReference
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid());


            final UploadTask uploadTask = filepath.putFile(uri);

            uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {

                    if (!task.isSuccessful()){

                        throw task.getException();

                    }

                    downloadUrl = filepath.getDownloadUrl().toString();

                    return filepath.getDownloadUrl();
                }
            })
                    .addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {


                            if (task.isSuccessful()){

                                downloadUrl = task.getResult().toString();

                                HashMap<String,Object> Profilemap = new HashMap<>();

                                Profilemap.put("uid",FirebaseAuth.getInstance().getCurrentUser().getUid());

                                Profilemap.put("name",getusername);
                                Profilemap.put("image",downloadUrl);

                                UsersRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .updateChildren(Profilemap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful()){

                                            Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                                            startActivity(intent);
                                            finish();

                                            loadingBar.dismiss();

                                            Toast.makeText(ProfileActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                });

                            }
                        }
                    });

        }


    }

    private void saveInfowithoutimage() {

        final String getusername = username.getText().toString();


        if (getusername.equals("")){

            Toast.makeText(this, "Please Enter Your Username...", Toast.LENGTH_SHORT).show();

        }else {

            loadingBar.setTitle("Creating Account");
            loadingBar.setMessage("Please Wait...");
            loadingBar.show();

            HashMap<String,Object> Profilemap = new HashMap<>();

            Profilemap.put("uid",FirebaseAuth.getInstance().getCurrentUser().getUid());

            Profilemap.put("name",getusername);


            UsersRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .updateChildren(Profilemap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()){

                        Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                        loadingBar.dismiss();

                        Toast.makeText(ProfileActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }


    }

    private void retrieveuserinfo(){

        UsersRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()){

                            String imageDB = snapshot.child("image").getValue().toString();
                            String nameDB = snapshot.child("name").getValue().toString();

                            username.setText(nameDB);

                            Picasso.get().load(imageDB).placeholder(R.drawable.profile).into(img);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }

}





