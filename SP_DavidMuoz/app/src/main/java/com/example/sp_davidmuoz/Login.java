package com.example.sp_davidmuoz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Login extends AppCompatActivity {

    Context context;
    SharedPreferences sharedPref, sharedPrefColor;
    String usr;
    String pwd;
    ConstraintLayout cl;
    TextView name, pass;
    Button login;

    // Constants
    private static final String COLORFONDO = "colorFondo";
    private static final String COLORTEXTO = "colorTexto";
    private static final String COLORBOTON = "colorBoton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cl = findViewById(R.id.cl_contlogin);
        name = findViewById(R.id.tvName);
        pass = findViewById(R.id.tvPass);
        login = findViewById(R.id.login);

        context = this;

        sharedPrefColor = getSharedPreferences("color", Context.MODE_PRIVATE);
        int colorFondo = sharedPrefColor.getInt(COLORFONDO, 0);
        int colorTexto = sharedPrefColor.getInt(COLORTEXTO, 0);
        int colorBoton = sharedPrefColor.getInt(COLORBOTON, 0);


        sharedPref = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE);

        usr = sharedPref.getString("n_usr", "-");
        pwd = sharedPref.getString("pwd_usr", "-");

        cl.setBackgroundColor(colorFondo);
        name.setTextColor(colorTexto);
        pass.setTextColor(colorTexto);
        login.setBackgroundColor(colorBoton);
    }

    public void login(View v) {
        EditText etU = findViewById(R.id.et_usr);
        EditText etP = findViewById(R.id.et_pwd);

        String u = etU.getText().toString();
        String p = etP.getText().toString();

        if (u.compareTo(usr) == 0 && p.compareTo(pwd) == 0) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            finish();
        }
    }
}