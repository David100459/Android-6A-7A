package com.example.palettecolors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sbr_red = null;
    private SeekBar sbr_green = null;
    private SeekBar sbr_blue = null;
    private SeekBar sbr_alpha = null;
    private View vie_colors = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbr_red = findViewById(R.id.sbrRed);
        sbr_green = findViewById(R.id.sbrGreen);
        sbr_blue = findViewById(R.id.sbrBlue);
        sbr_alpha = findViewById(R.id.sbrAlpha);
        vie_colors = findViewById(R.id.vieColors);

        sbr_red.setOnSeekBarChangeListener(this);
        sbr_green.setOnSeekBarChangeListener(this);
        sbr_blue.setOnSeekBarChangeListener(this);
        sbr_alpha.setOnSeekBarChangeListener(this);

    }

    //Show options menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Actions option menu
    @Override
public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){

            case R.id.iteAboutOf:
                //Toast.makeText(this, "You' ve pressed About Of Option", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AboutOfActivity.class);
                startActivity(intent);
                break;


            case  R.id.iteHelp:
                //Toast.makeText(this, "You' ve pressed Help Option", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, HelpActivity.class);
                startActivity(intent2);
                break;

            case R.id.iteExit:
                Toast.makeText(this, "You' ve pressed Exit Option", Toast.LENGTH_SHORT).show();
                break;

            case R.id.iteSearch:
                Toast.makeText(this, "You' ve pressed Search Option", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.iteGreen:


        }

        return super.onOptionsItemSelected(item);
}

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
  int r = sbr_red.getProgress();
  int g = sbr_green.getProgress();
  int b = sbr_blue.getProgress();
  int a = sbr_alpha.getProgress();

  int color = Color.argb(a,r,g,b);
  vie_colors.setBackgroundColor(color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}