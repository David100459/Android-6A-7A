package com.david.mydog.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.david.mydog.R;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    Context context;
    EditText et_reg, et_con, et_name, et_ape;
    String usr, pwd, name, ape;
    SharedPreferences sharedPref;
    final int MY_PERMISSIONS_REQUEST_CAMERA = 1000;
    final int OPEN_CAM = 1;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;
        activity = this;

        sharedPref = context.getSharedPreferences("File", context.MODE_PRIVATE);

        usr = sharedPref.getString("n_usr", "-");
        pwd = sharedPref.getString("pwd_usr", "-");
        name = sharedPref.getString("name", "-");
        ape = sharedPref.getString("ape", "-");

        et_reg = findViewById(R.id.et_reg);
        et_con = findViewById(R.id.et_con);
        et_name = findViewById(R.id.et_name);
        et_ape = findViewById(R.id.et_ape);

    }

    public void back(View v) {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
    }

    public void cam(View v) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            Toast.makeText(context, "Se abre la cámara desde OPEN_CAM \n Boton Derecho", Toast.LENGTH_LONG).show();
            startActivityForResult(camIntent, OPEN_CAM);

            //Verifica el dialogo de los permisos
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {
            Toast.makeText(context, "No se han asignado permisos", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);

        } else {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //   Bundle extras = data.getExtras();

        Bitmap bmp;

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case OPEN_CAM:
                    Toast.makeText(context, "Se interpreta la respuesta desde OPEN_CAM \n Boton Derecho", Toast.LENGTH_LONG).show();


                    // bmp = extras.getParcelable("data");
                    bmp = data.getParcelableExtra("data");

/*
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("imagen", String.valueOf(bmp));
                    editor.commit();*/

                    //iv.setImageBitmap(bmp);

                    break;
                default:
                    Toast.makeText(context, "No se pudo interpretar la respuesta", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void dialogR(View v){

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

    public void SaveData(View v) {

        String usr = et_reg.getText().toString().trim();
        String pwd = et_con.getText().toString().trim();
        String name = et_name.getText().toString().trim();
        String ape = et_ape.getText().toString().trim();

        int usrL = usr.length();
        int pwdL = pwd.length();
        int nameL = name.length();
        int apeL = ape.length();

        if (nameL > 3) {
            if (apeL > 3) {
                if (usrL > 4) {
                    if (pwdL > 4) {

                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("n_usr", usr);
                        editor.putString("pwd_usr", pwd);
                        editor.putString("name", name);
                        editor.putString("ape", ape);
                        editor.commit();
                        et_reg.setText("");
                        et_con.setText("");
                        et_name.setText("");
                        et_ape.setText("");
                        Snackbar.make(v, "Datos guardados, cierre y abra nuevamente la app", Snackbar.LENGTH_SHORT)
                                .show();
                    } else {
                        et_reg.setText("");
                        et_con.setText("");
                        et_name.setText("");
                        et_ape.setText("");
                        Snackbar.make(v, "La contraseña debe tener mínimo 5 digitos", Snackbar.LENGTH_SHORT)
                                .show();
                    }
                } else {
                    et_reg.setText("");
                    et_con.setText("");
                    et_name.setText("");
                    et_ape.setText("");
                    Snackbar.make(v, "El Usuario debe tener mínimo 5 caracteres", Snackbar.LENGTH_SHORT)
                            .show();
                }
            } else {
                et_reg.setText("");
                et_con.setText("");
                et_name.setText("");
                et_ape.setText("");
                Snackbar.make(v, "El Apellido debe tener mínimo 4 caracteres", Snackbar.LENGTH_SHORT)
                        .show();
            }
        } else {
            et_reg.setText("");
            et_con.setText("");
            et_name.setText("");
            et_ape.setText("");
            Snackbar.make(v, "El Nombre debe tener mínimo 4 caracteres", Snackbar.LENGTH_SHORT)
                    .show();
        }
    }
}