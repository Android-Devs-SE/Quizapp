package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button register;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private TextView haveaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = findViewById(R.id.emailet);
        password = findViewById(R.id.passwordet);
        register = findViewById(R.id.Registerbt);
        haveaccount = findViewById(R.id.haveaccout);

        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);

        haveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = email.getText().toString();
                String pass = password.getText().toString();


                if (TextUtils.isEmpty(mail)) {

                    email.setError("Please Enter Your Email");
                    return;


                } else if (TextUtils.isEmpty(pass)) {

                    password.setError("Please Enter Your Password");
                    return;
                } else if (password.length() < 6) {

                    Toast.makeText(RegistrationActivity.this, "Password should contain at least 6 characters", Toast.LENGTH_SHORT).show();


                }else {



                    signupuserwith(mail,pass);

                }
            }

        });

    }

    private void signupuserwith(String mail, String pass) {

        progressDialog.setTitle("Account creating");
        progressDialog.setMessage("Please Wait");
        progressDialog.show();


        mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    sendUsertoLoginActivity();
                    Toast.makeText(RegistrationActivity.this, "Registerd Successfully", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                progressDialog.dismiss();

                e.printStackTrace();
                Toast.makeText(RegistrationActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    private void sendUsertoLoginActivity() {

        Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();


    }


}