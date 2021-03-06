package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference UsersRef;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private Toolbar mToolbar;
    String currentUserID;
    CardView gk,videogames,celebs,gadgets,sports,film,vehicles,comics,computers,maths;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gk = findViewById(R.id.gk);
        videogames = findViewById(R.id.videogames);
        celebs = findViewById(R.id.celebrities);
        gadgets = findViewById(R.id.gadgets);
        sports = findViewById(R.id.Sports);
        film = findViewById(R.id.film);
        vehicles = findViewById(R.id.vehicles);
        comics = findViewById(R.id.comics);
        computers = findViewById(R.id.computers);
        maths = findViewById(R.id.maths);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        navigationView = findViewById(R.id.nav_view);
        mAuth = FirebaseAuth.getInstance();



        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,mToolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case  R.id.profile :

                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this,ProfileActivity2.class);
                        startActivity(intent);
                        break;

                    case R.id.home:

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();

                        Intent intent1 = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent1);


                }

                return false;
            }
        });




    }








    @Override
    protected void onStart() {

        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu2, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.logout:

                mAuth.signOut();
                finish();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));

                Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_LONG).show();
                break;



        }

        return true;
    }



}



