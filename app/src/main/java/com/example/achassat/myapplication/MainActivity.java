package com.example.achassat.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;



public class MainActivity extends Activity {

    Button btnVue1;
    Button btnVue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("Projet android");

        // Création du listener du bouton permetant d'afficher la vue 1
        btnVue1 =(Button)findViewById(R.id.buttonVue1);
        btnVue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vue1 = new Intent(MainActivity.this, ActivityVue1.class);
                startActivity(vue1);
            }
        });

        //Création du listener du bouton permetant d'afficher la vue 1
        btnVue2 =(Button)findViewById(R.id.buttonVue2);
        btnVue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vue2 = new Intent(MainActivity.this, ActivityVue2.class);
                startActivity(vue2);
            }
        });

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Connection a NMEA simulator
        try {
            new Connection("86.209.9.188", 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
