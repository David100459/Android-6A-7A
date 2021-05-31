package com.example.sharedpreferences_davidmunoz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        sharedPref = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE);

        String usr = sharedPref.getString("n_usr", "-");
        String pwd = sharedPref.getString("pwd_usr", "-");

        if (!(usr.compareTo("-") == 0 && pwd.compareTo("-") == 0)) {
            Intent intent = new Intent(this, Wellcome.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(context, "Aún no se han configurado credenciales", Toast.LENGTH_LONG).show();
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void saveData(View v) {

        Log.d("CLIC", "Si se reconoce el click");
        EditText etU = findViewById(R.id.et_usr);
        EditText etP = findViewById(R.id.et_pwd);

        String usr = etU.getText().toString().trim();
        String pwd = etP.getText().toString().trim();

        int usrL = usr.length();
        int pwdL = pwd.length();

        if (usrL > 4) {
            if (pwdL > 4) {

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("n_usr", usr);
                editor.putString("pwd_usr", pwd);
                editor.commit();
                Toast.makeText(context, "Datos guardados, cierre y abra nuevamente la app", Toast.LENGTH_LONG).show();
            } else {
                Snackbar.make(v, "La contraseña debe tener mínimo 5 digitos", Snackbar.LENGTH_SHORT)
                        .show();
            }
        } else {
            Snackbar.make(v, "El usuario debe tener mínimo 5 caracteres", Snackbar.LENGTH_SHORT)
                    .show();
        }


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