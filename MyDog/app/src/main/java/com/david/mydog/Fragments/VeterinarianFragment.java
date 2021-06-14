package com.david.mydog.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.david.mydog.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VeterinarianFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VeterinarianFragment extends Fragment {

    View view;
    Context context;

    Button btn_tel, btn_yellow1, btn_yellow2, btn_yellow3, btn_yellow4, btn_yellow5, btn_yellow6,
            btn_yellow7, btn_yellow8, btn_yellow9, btn_yellow10, btn_yellow11, btn_yellow12,
            btn_yellow13, btn_yellow14, btn_yellow15, btn_yellow16, btn_yellow17, btn_yellow18,
            btn_yellow19, btn_yellow20, btn_yellow21, btn_yellow22, btn_yellow23, btn_yellow24,
            btn_yellow25, btn_clear, btn_clear2, btn_clear3, btn_clear4, btn_clear5;

    String bcl1, bcl2, bcl3, bcl4, bcl5, bcl6, bcl7, bcl8, bcl9, bcl10, bcl11, bcl12, bcl13, bcl14,
            bcl15, bcl16, bcl17, bcl18, bcl19, bcl20, bcl21, bcl22, bcl23, bcl24, bcl25, bcl;

    SharedPreferences sharedPref;

    public VeterinarianFragment() {

    }

    public static VeterinarianFragment newInstance(String param1, String param2) {
        VeterinarianFragment fragment = new VeterinarianFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_veterinarian, container, false);
        context = view.getContext();

        sharedPref = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        bcl = sharedPref.getString("btnCol26", "#000000");
        bcl1 = sharedPref.getString("btnCol", "#000000");
        bcl2 = sharedPref.getString("btnCol2", "#000000");
        bcl3 = sharedPref.getString("btnCol3", "#000000");
        bcl4 = sharedPref.getString("btnCol4", "#000000");
        bcl5 = sharedPref.getString("btnCol5", "#000000");
        bcl6 = sharedPref.getString("btnCol6", "#000000");
        bcl7 = sharedPref.getString("btnCol7", "#000000");
        bcl8 = sharedPref.getString("btnCol8", "#000000");
        bcl9 = sharedPref.getString("btnCol9", "#000000");
        bcl10 = sharedPref.getString("btnCol10", "#000000");
        bcl11 = sharedPref.getString("btnCol11", "#000000");
        bcl12 = sharedPref.getString("btnCol12", "#000000");
        bcl13 = sharedPref.getString("btnCol13", "#000000");
        bcl14 = sharedPref.getString("btnCol14", "#000000");
        bcl15 = sharedPref.getString("btnCol15", "#000000");
        bcl16 = sharedPref.getString("btnCol16", "#000000");
        bcl17 = sharedPref.getString("btnCol17", "#000000");
        bcl18 = sharedPref.getString("btnCol18", "#000000");
        bcl19 = sharedPref.getString("btnCol19", "#000000");
        bcl20 = sharedPref.getString("btnCol20", "#000000");
        bcl21 = sharedPref.getString("btnCol21", "#000000");
        bcl22 = sharedPref.getString("btnCol22", "#000000");
        bcl23 = sharedPref.getString("btnCol23", "#000000");
        bcl24 = sharedPref.getString("btnCol24", "#000000");
        bcl25 = sharedPref.getString("btnCol25", "#000000");

        lounchWidgets();
        lounchEvents();

        return view;
    }

    public void lounchWidgets() {

        context = view.getContext();

        btn_yellow1 = view.findViewById(R.id.btn_yellow1);
        btn_yellow2 = view.findViewById(R.id.btn_yellow2);
        btn_yellow3 = view.findViewById(R.id.btn_yellow3);
        btn_yellow4 = view.findViewById(R.id.btn_yellow4);
        btn_yellow5 = view.findViewById(R.id.btn_yellow5);
        btn_yellow6 = view.findViewById(R.id.btn_yellow6);
        btn_yellow7 = view.findViewById(R.id.btn_yellow7);
        btn_yellow8 = view.findViewById(R.id.btn_yellow8);
        btn_yellow9 = view.findViewById(R.id.btn_yellow9);
        btn_yellow10 = view.findViewById(R.id.btn_yellow10);
        btn_yellow11 = view.findViewById(R.id.btn_yellow11);
        btn_yellow12 = view.findViewById(R.id.btn_yellow12);
        btn_yellow13 = view.findViewById(R.id.btn_yellow13);
        btn_yellow14 = view.findViewById(R.id.btn_yellow14);
        btn_yellow15 = view.findViewById(R.id.btn_yellow15);
        btn_yellow16 = view.findViewById(R.id.btn_yellow16);
        btn_yellow17 = view.findViewById(R.id.btn_yellow17);
        btn_yellow18 = view.findViewById(R.id.btn_yellow18);
        btn_yellow19 = view.findViewById(R.id.btn_yellow19);
        btn_yellow20 = view.findViewById(R.id.btn_yellow20);
        btn_yellow21 = view.findViewById(R.id.btn_yellow21);
        btn_yellow22 = view.findViewById(R.id.btn_yellow22);
        btn_yellow23 = view.findViewById(R.id.btn_yellow23);
        btn_yellow24 = view.findViewById(R.id.btn_yellow24);
        btn_yellow25 = view.findViewById(R.id.btn_yellow25);
        btn_clear = view.findViewById(R.id.btn_clear);
        btn_clear2 = view.findViewById(R.id.btn_clear2);
        btn_clear3 = view.findViewById(R.id.btn_clear3);
        btn_clear4 = view.findViewById(R.id.btn_clear4);
        btn_clear5 = view.findViewById(R.id.btn_clear5);

        int t = bcl1.length();

        if (t > 1) {
            btn_yellow1.setBackgroundColor(Color.parseColor(bcl1));
            btn_yellow2.setBackgroundColor(Color.parseColor(bcl2));
            btn_yellow3.setBackgroundColor(Color.parseColor(bcl3));
            btn_yellow4.setBackgroundColor(Color.parseColor(bcl4));
            btn_yellow5.setBackgroundColor(Color.parseColor(bcl5));
            btn_yellow6.setBackgroundColor(Color.parseColor(bcl6));
            btn_yellow7.setBackgroundColor(Color.parseColor(bcl7));
            btn_yellow8.setBackgroundColor(Color.parseColor(bcl8));
            btn_yellow9.setBackgroundColor(Color.parseColor(bcl9));
            btn_yellow10.setBackgroundColor(Color.parseColor(bcl10));
            btn_yellow11.setBackgroundColor(Color.parseColor(bcl11));
            btn_yellow12.setBackgroundColor(Color.parseColor(bcl12));
            btn_yellow13.setBackgroundColor(Color.parseColor(bcl13));
            btn_yellow14.setBackgroundColor(Color.parseColor(bcl14));
            btn_yellow15.setBackgroundColor(Color.parseColor(bcl15));
            btn_yellow16.setBackgroundColor(Color.parseColor(bcl16));
            btn_yellow17.setBackgroundColor(Color.parseColor(bcl17));
            btn_yellow18.setBackgroundColor(Color.parseColor(bcl18));
            btn_yellow19.setBackgroundColor(Color.parseColor(bcl19));
            btn_yellow20.setBackgroundColor(Color.parseColor(bcl20));
            btn_yellow21.setBackgroundColor(Color.parseColor(bcl21));
            btn_yellow22.setBackgroundColor(Color.parseColor(bcl22));
            btn_yellow23.setBackgroundColor(Color.parseColor(bcl23));
            btn_yellow24.setBackgroundColor(Color.parseColor(bcl24));
            btn_yellow25.setBackgroundColor(Color.parseColor(bcl25));

        }

    }

    public void lounchEvents() {

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow1.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow2.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow3.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow4.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow5.setBackgroundColor(Color.parseColor("#000000"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol26", "#000000");
                editor.putString("btnCol", "#000000");
                editor.putString("btnCol2", "#000000");
                editor.putString("btnCol3", "#000000");
                editor.putString("btnCol4", "#000000");
                editor.putString("btnCol5", "#000000");
                editor.commit();
            }
        });

        btn_clear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow6.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow7.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow8.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow9.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow10.setBackgroundColor(Color.parseColor("#000000"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol26", "#000000");
                editor.putString("btnCol6", "#000000");
                editor.putString("btnCol7", "#000000");
                editor.putString("btnCol8", "#000000");
                editor.putString("btnCol9", "#000000");
                editor.putString("btnCol10", "#000000");
                editor.commit();
            }
        });

        btn_clear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow11.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow12.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow13.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow14.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow15.setBackgroundColor(Color.parseColor("#000000"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol26", "#000000");
                editor.putString("btnCol11", "#000000");
                editor.putString("btnCol12", "#000000");
                editor.putString("btnCol13", "#000000");
                editor.putString("btnCol14", "#000000");
                editor.putString("btnCol15", "#000000");
                editor.commit();
            }
        });

        btn_clear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow16.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow17.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow18.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow19.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow20.setBackgroundColor(Color.parseColor("#000000"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol26", "#000000");
                editor.putString("btnCol16", "#000000");
                editor.putString("btnCol17", "#000000");
                editor.putString("btnCol18", "#000000");
                editor.putString("btnCol19", "#000000");
                editor.putString("btnCol20", "#000000");
                editor.commit();
            }
        });

        btn_clear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow21.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow22.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow23.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow24.setBackgroundColor(Color.parseColor("#000000"));
                btn_yellow25.setBackgroundColor(Color.parseColor("#000000"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol26", "#000000");
                editor.putString("btnCol21", "#000000");
                editor.putString("btnCol22", "#000000");
                editor.putString("btnCol23", "#000000");
                editor.putString("btnCol24", "#000000");
                editor.putString("btnCol25", "#000000");
                editor.commit();
            }
        });

        btn_yellow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow1.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow2.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol2", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow3.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol3", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow4.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol4", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow5.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol5", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow6.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol6", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow7.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol7", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow8.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol8", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow9.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol9", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow10.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol10", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow11.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol11", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow12.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol12", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow13.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol13", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow14.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol14", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow15.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol15", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow16.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol16", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow17.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol17", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow18.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol18", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow19.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol19", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow20.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol20", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow21.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol21", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow22.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol22", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow23.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol23", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow24.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol24", "#12DBF4");
                editor.commit();
            }
        });

        btn_yellow25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_yellow25.setBackgroundColor(Color.parseColor("#12DBF4"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("btnCol25", "#12DBF4");
                editor.commit();
            }
        });
    }
}
