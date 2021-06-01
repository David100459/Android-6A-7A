package com.example.sp_davidmuoz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class Setting extends AppCompatActivity {

    Context mContext;
    SharedPreferences sharedPref, sharedPrefColor;
    ConstraintLayout cl;
    CardView cvFondo, cvTexto, cvBoton;
    FloatingActionButton fab;
    TextView tv;

    // Constants
    private static final String COLORFONDO = "colorFondo";
    private static final String COLORTEXTO = "colorTexto";
    private static final String COLORBOTON = "colorBoton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContext = this;

        sharedPrefColor = getSharedPreferences("color", Context.MODE_PRIVATE);
        // read saved data
        int colorFondo = sharedPrefColor.getInt(COLORFONDO, 0);
        int colorTexto = sharedPrefColor.getInt(COLORTEXTO, 0);
        int colorBoton = sharedPrefColor.getInt(COLORBOTON, 0);


        cl = findViewById(R.id.cl_setting);
        cvFondo = findViewById(R.id.colorFondo);
        cvBoton = findViewById(R.id.colorBoton);
        cvTexto = findViewById(R.id.colorTexto);
        fab = findViewById(R.id.fab);
        tv = findViewById(R.id.tv_w);

        sharedPref = mContext.getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        String usr = sharedPref.getString("n_usr", "-");
        tv.setText("Bienvenido usuario " + usr);

        int[] Cards = new int[]{R.id.colorFondo, R.id.colorBoton, R.id.colorTexto};
        int[] colors = new int[]{colorFondo, colorBoton, colorTexto};

        for (int i = 0; i < Cards.length; i++) {
            CardView xx = findViewById(Cards[i]);
            xx.setCardBackgroundColor(colors[i]);
            Log.d("CRSI IDS", "onCreate: " + xx.getCardBackgroundColor());
        }

        // Show Dialog to save color
        cvFondo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ColorPickerDialog.Builder builder = new ColorPickerDialog.Builder(mContext);
                builder.setTitle("Seleccione:");
                builder.setPreferenceName(COLORFONDO);
                builder.setPositiveButton(getString(R.string.confirm), new ColorEnvelopeListener() {
                    @Override
                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                        cvFondo.setCardBackgroundColor(envelope.getColor());
                        Log.d("CRSI", "onColorSelected: " + envelope.getColor());
                        saveColor(envelope.getColor(), COLORFONDO);

                    }
                });
                builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
        cvBoton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ColorPickerDialog.Builder builder = new ColorPickerDialog.Builder(mContext);
                builder.setTitle("Seleccione:");
                builder.setPreferenceName(COLORBOTON);
                builder.setPositiveButton(getString(R.string.confirm), new ColorEnvelopeListener() {
                    @Override
                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                        cvBoton.setCardBackgroundColor(envelope.getColor());
                        Log.d("CRSI", "onColorSelected: " + envelope.getColor());
                        saveColor(envelope.getColor(), COLORBOTON);

                    }
                });
                builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
        cvTexto.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ColorPickerDialog.Builder builder = new ColorPickerDialog.Builder(mContext);
                builder.setTitle("Seleccione:");
                builder.setPreferenceName(COLORTEXTO);
                builder.setPositiveButton(getString(R.string.confirm), new ColorEnvelopeListener() {
                    @Override
                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                        cvTexto.setCardBackgroundColor(envelope.getColor());
                        Log.d("CRSI", "onColorSelected: " + envelope.getColor());
                        saveColor(envelope.getColor(), COLORTEXTO);

                    }
                });
                builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        fab.setBackgroundTintList(ColorStateList.valueOf(colorBoton));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Wellcome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });


    }

    // Method to save the color value
    private void saveColor(int color, String name) {
        SharedPreferences.Editor editor = sharedPrefColor.edit();
        editor.putInt(name, color);
        editor.apply();
    }
}