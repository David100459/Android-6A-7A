package com.example.sharedpreferences_davidmunoz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Wellcome extends AppCompatActivity {

    Context context;
    SharedPreferences sharedPref, sharedPrefColor;
    FloatingActionButton fab;
    Window window;
    CoordinatorLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cl = findViewById(R.id.cl_wellcome);

        context = this;

        sharedPrefColor = context.getSharedPreferences("color", Context.MODE_PRIVATE);
        String previous = sharedPrefColor.getString("background", "#ffffff");

        sharedPref = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        String usr = sharedPref.getString("n_usr", "-");

        TextView tv = findViewById(R.id.tv_w);
        tv.setText("Bienvenido usuario " + usr);

        cl.setBackgroundColor(Color.parseColor(previous));

        fab = findViewById(R.id.fab);
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(context, Login.class);
                startActivity(intent);
                return false;
            }
        });
    }

    public void goToLogin() {

    }


}