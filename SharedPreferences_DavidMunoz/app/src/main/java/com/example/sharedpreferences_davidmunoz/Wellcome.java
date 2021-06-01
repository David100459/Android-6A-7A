package com.example.sharedpreferences_davidmunoz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.widget.TextView;

public class Wellcome extends AppCompatActivity {

    Context context;
    SharedPreferences sharedPref, sharedPrefColor;
    FloatingActionButton fab;
    CoordinatorLayout cl;
    TextView tv;

    // Constants
    private static final String COLORFONDO = "colorFondo";
    private static final String COLORTEXTO = "colorTexto";
    private static final String COLORBOTON = "colorBoton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cl = findViewById(R.id.cl_wellcome);
        tv = findViewById(R.id.tv_wb);
        fab = findViewById(R.id.fab);

        context = this;

        sharedPrefColor = context.getSharedPreferences("color", Context.MODE_PRIVATE);
        // Retrieve saved colors
        int colorFondo = sharedPrefColor.getInt(COLORFONDO, 0);
        int colorTexto = sharedPrefColor.getInt(COLORTEXTO, 0);
        int colorBoton = sharedPrefColor.getInt(COLORBOTON, 0);

        sharedPref = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        String usr = sharedPref.getString("n_usr", "-");
        tv.setText("Bienvenido usuario " + usr);

        // Apply color settings
        cl.setBackgroundColor(colorFondo);
        tv.setTextColor(colorTexto);
        fab.setBackgroundTintList(ColorStateList.valueOf(colorBoton));

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