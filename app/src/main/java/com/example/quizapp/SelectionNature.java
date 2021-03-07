package com.example.quizgitfinale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectionNature extends AppCompatActivity {
    Button b;
    RadioButton c10,c20,ce,cm,ch;
    RadioGroup radioGroup1,radioGroup2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_page);
        c10 = findViewById(R.id.c10);
        c20 = findViewById(R.id.c20);
        ce = findViewById(R.id.ce);
        cm = findViewById(R.id.cm);
        ch = findViewById(R.id.ch);
        b = findViewById(R.id.bselect);
        radioGroup1 = findViewById(R.id.rg);
        radioGroup2 = findViewById(R.id.rgb);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c10.isChecked() && ce.isChecked())
                {
                    Intent intent = new Intent(SelectionNature.this, Nature_10_easy.class);
                    startActivity(intent);
                }

                else if(c10.isChecked() && cm.isChecked())
                {
                    Intent intent = new Intent(SelectionNature.this, Nature_10_medium.class);
                    startActivity(intent);
                }

                else if(c10.isChecked() && ch.isChecked())
                {
                    Intent intent = new Intent(SelectionNature.this, Nature_10_hard.class);
                    startActivity(intent);
                }

                else if(c20.isChecked() && ch.isChecked())
                {
                    Intent intent = new Intent(SelectionNature.this, Nature_20_hard.class);
                    startActivity(intent);
                }


                else if(c20.isChecked() && ce.isChecked())
                {
                    Intent intent = new Intent(SelectionNature.this, Nature_20_easy.class);
                    startActivity(intent);
                }

                else if(c20.isChecked() && cm.isChecked())
                {
                    Intent intent = new Intent(SelectionNature.this, Nature_20_medium.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(SelectionNature.this,"Error in selection!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
