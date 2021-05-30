package com.example.internallogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class Configurations extends AppCompatActivity {

    Context context;
    SharedPreferences sharedPref, sharedPrefColor;
    private Window window;
    ConstraintLayout cl;
    Button btn_baGreen;
    Button btn_baBlue;
    Button btn_baYellow;

    Button btn_txtGreen;
    Button btn_txtBlue;
    Button btn_txtYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cl = findViewById(R.id.cl_configurations);
        btn_baGreen = findViewById(R.id.btn_baGreen);
        btn_baBlue = findViewById(R.id.btn_baBlue);
        btn_baYellow = findViewById(R.id.btn_baYellow);

        btn_txtGreen = findViewById(R.id.btn_txtGreen);

        context = this;
        this.window = getWindow();

        sharedPrefColor = context.getSharedPreferences("color", Context.MODE_PRIVATE);
        String previous = sharedPrefColor.getString("background", "#ffffff");

        sharedPref = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        String usr = sharedPref.getString("n_usr", "-");

        cl.setBackgroundColor(Color.parseColor(previous));

        TextView tv = findViewById(R.id.tv_w);
        tv.setText("Bienvenido usuario " + usr);

        btn_baGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String background = "#4CAF50";
                changeBackground(background);
            }
        });

        btn_baBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String background = "#00BCD4";
                changeBackground(background);
            }
        });

       btn_baYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String background = "#FFEB3B";
                changeBackground(background);
            }
        });

       btn_txtGreen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Wellcome.class);
                startActivity(intent);
            }
        });

    }

    private void changeBackground(String background) {
        cl.setBackgroundColor(Color.parseColor(background));
        SharedPreferences.Editor editor = sharedPrefColor.edit();
        editor.putString("background", background);
        editor.commit();
    }

}