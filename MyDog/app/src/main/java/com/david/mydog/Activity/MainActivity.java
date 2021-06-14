package com.david.mydog.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.david.mydog.R;
import com.david.mydog.models.Pets;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context;
    SharedPreferences sharedPref;
    String usr, pwd, name, ape;
    EditText et_reg, et_con;

    public static ArrayList<Pets> petsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        petsList= new ArrayList<Pets>();

        context = this;

        sharedPref = context.getSharedPreferences("File", context.MODE_PRIVATE);

        usr = sharedPref.getString("n_usr", "-");
        pwd = sharedPref.getString("pwd_usr", "-");
        name = sharedPref.getString("name", "-");
        ape = sharedPref.getString("ape", "-");

        et_reg = findViewById(R.id.et_reg);
        et_con = findViewById(R.id.et_con);


    }

    public void dialog(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_presentation, null);

        builder.setView(view)
                .setCancelable(false)
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(v, "Gracias por su atención\t"+name+"\t"+ape, Snackbar.LENGTH_SHORT)
                                .show();
                    }
                });
        builder.show();

    }

    public void exit(View v) {
        finish();
    }

    public void next(View v) {
        Intent intent = new Intent(context, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View v) {

        String u = et_reg.getText().toString();
        String p = et_con.getText().toString();


        if (u.compareTo(usr) == 0) {
            if (p.compareTo(pwd) == 0) {

                Intent intent = new Intent(context, MenuActivity.class);
                startActivity(intent);
                Toast.makeText(context, "Bienvenido" + "\t\t" + name + "\t\t" + ape, Toast.LENGTH_SHORT).show();
                et_reg.setText("");
                et_con.setText("");
            } else {
                Snackbar.make(v, "La contraseña debe tener mínimo 5 digitos", Snackbar.LENGTH_SHORT)
                        .show();
                et_reg.setText("");
                et_con.setText("");
            }
        } else {
            Snackbar.make(v, "Datos incorrectos", Snackbar.LENGTH_SHORT)
                    .show();
            et_reg.setText("");
            et_con.setText("");
        }
    }

    public void start(View v) {
        Intent intent = new Intent(context, MenuActivity.class);
        startActivity(intent);
    }
}