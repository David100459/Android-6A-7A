package com.example.internallogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Wellcome extends AppCompatActivity {
    Context context;
    SharedPreferences sharedPref;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        sharedPref = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        String usr = sharedPref.getString("n_usr", "-");

        TextView tv = findViewById(R.id.tv_w);
        tv.setText("Bienvenido usuario " + usr);

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

    public void goToLogin(){

    }
}