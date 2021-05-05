package com.example.ejemplologin.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejemplologin.Fragments.DialogosFragment;
import com.example.ejemplologin.Fragments.ComponentesuiFragment;
import com.example.ejemplologin.Fragments.AnimacionesFragment;
import com.example.ejemplologin.Fragments.TestFragment;
import com.example.ejemplologin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    Context context;
    private String title;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        context = this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Cambiar nombre de usuario
        TextView tvUN = navigationView.getHeaderView(0).findViewById(R.id.user_name);
        //Cambiar imagen de usuario
        ImageView iv = navigationView.getHeaderView(0).findViewById(R.id.imageView);


        Bundle b = getIntent().getExtras();
        String user = b.getString("UserName");
        int userPic = b.getInt("UserPic");
        tvUN.setText(user);
        iv.setImageDrawable(getDrawable(userPic));

        //String pass = b.getString("Pass");

        Toast.makeText(this, " Recibo Usr: " + user, Toast.LENGTH_SHORT).show();
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id_menu = item.getItemId();




        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id_menu = item.getItemId();
        Fragment fragment = null;
        String title = "Menú principal";

        switch (id_menu) {

            case R.id.nav_componentesIU:
                fragment = new ComponentesuiFragment();
                title = "Menú componentes UI";
                break;
            case R.id.nav_dialogos:
                fragment = new DialogosFragment();
                title = "Menú dialogos";
                break;
            case R.id.nav_animaciones:
                fragment = new AnimacionesFragment();
                title = "Menú animaciones";
                break;
            case R.id.nav_test:
                fragment = new TestFragment();
                title = "Menú Evaluación";
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_fragment, fragment);
            ft.commit();
            getSupportActionBar().setTitle(title);
            drawer.closeDrawer(GravityCompat.START);
        }


        return true;
    }
}