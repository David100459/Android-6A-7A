package com.example.ejemplologin.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ejemplologin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* seccion e atributos */
    FloatingActionButton fab;
    EditText etUser;
    EditText etPass;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lounchWidgets();
        lounchEvents();

    }

    //conecta interfaz con logica
    private void lounchWidgets() {

        context = this;

        fab = findViewById(R.id.fab);
        etUser = findViewById(R.id.et_user);
        etPass = findViewById(R.id.et_pass);

    }

    //agrega eventos a objetos de interfaz
    private void lounchEvents() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = etUser.getText().toString();
                String p = etPass.getText().toString();
                Toast.makeText(view.getContext(), " Envío Usr: " + u + " Pass: " + p, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, MainMenu.class);
                i.putExtra("User", u);
                i.putExtra("Pass", p);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}