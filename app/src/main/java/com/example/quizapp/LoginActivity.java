package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText logemail,logpass,forgotpassword;
    Button login;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    TextView register,forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logemail = findViewById(R.id.logemail);
        logpass = findViewById(R.id.logpassword);
        login = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();
        register = findViewById(R.id.register);
        forgotpass = findViewById(R.id.forgotpassword);
        forgotpassword = findViewById(R.id.forgotpass1);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);


        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = new EditText(v.getContext());


                AlertDialog.Builder passwordrester = new AlertDialog.Builder(v.getContext());
                passwordrester.setTitle("Reset Password");
                passwordrester.setMessage("Enter Your Email To Reset Your Password");
                passwordrester.setView(editText);

                passwordrester.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        String mail = editText.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()){

                                    Toast.makeText(LoginActivity.this, "Reset Link Set To Your Email", Toast.LENGTH_SHORT).show();

                                }else {

                                    String Message = task.getException().getMessage();
                                    Toast.makeText(LoginActivity.this, ""+Message, Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                        }
                });

                passwordrester.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                passwordrester.create().show();


            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String logmail = logemail.getText().toString();
                String logpassword = logpass.getText().toString();

                if (TextUtils.isEmpty(logmail)) {

                    logemail.setError("Please Enter Your Email");
                    return;


                } else if (TextUtils.isEmpty(logpassword)) {

                    logpass.setError("Please Enter Your Password");
                    return;
                } else if (logpass.length() < 6) {

                    Toast.makeText(LoginActivity.this, "Password should contain at least 6 characters", Toast.LENGTH_SHORT).show();


                }else {



                    signinuserwith(logmail,logpassword);

                }
            }
        });

    }

    private void signinuserwith(String logmail, String logpassword) {

        progressDialog.setTitle(" Login");
        progressDialog.setMessage("Please Wait");
        progressDialog.show();


        mAuth.signInWithEmailAndPassword(logmail,logpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    sendusertoProfileActivity();
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                e.printStackTrace();
                Toast.makeText(LoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });

    }

    private void sendusertoProfileActivity() {

        Intent intent = new Intent(LoginActivity.this,ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();


    }
}