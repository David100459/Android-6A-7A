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
import android.widget.TextView;

import com.david.mydog.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VaccineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VaccineFragment extends Fragment {

    View view;
    Context context;
    Button btn_black, btn_red, btn_black2, btn_red2, btn_black3, btn_red3,
            btn_black4, btn_red4, btn_black5, btn_red5, btn_black6, btn_red6;
    String tcl1, tcl2, tcl3, tcl4, tcl5, tcl6;
    TextView tv_vc1, tv_vc2, tv_vc3, tv_vc4, tv_vc5, tv_vc6;
    SharedPreferences sharedPref;

    public VaccineFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static VaccineFragment newInstance(String param1, String param2) {
        VaccineFragment fragment = new VaccineFragment();
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

        view = inflater.inflate(R.layout.fragment_vaccine, container, false);
        context = view.getContext();

        sharedPref = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        tcl1 = sharedPref.getString("texCol", "#EC1010");
        tcl2 = sharedPref.getString("texCol2", "#EC1010");
        tcl3 = sharedPref.getString("texCol3", "#EC1010");
        tcl4 = sharedPref.getString("texCol4", "#EC1010");
        tcl5 = sharedPref.getString("texCol5", "#EC1010");
        tcl6 = sharedPref.getString("texCol6", "#EC1010");

        lounchWidgets();
        lounchEvents();

        return view;
    }

    public void lounchWidgets() {

        context = view.getContext();

        btn_black = view.findViewById(R.id.btn_black);
        btn_red = view.findViewById(R.id.btn_red);
        btn_black2 = view.findViewById(R.id.btn_black2);
        btn_red2 = view.findViewById(R.id.btn_red2);
        btn_black3 = view.findViewById(R.id.btn_black3);
        btn_red3 = view.findViewById(R.id.btn_red3);
        btn_black4 = view.findViewById(R.id.btn_black4);
        btn_red4 = view.findViewById(R.id.btn_red4);
        btn_black5 = view.findViewById(R.id.btn_black5);
        btn_red5 = view.findViewById(R.id.btn_red5);
        btn_black6 = view.findViewById(R.id.btn_black6);
        btn_red6 = view.findViewById(R.id.btn_red6);

        tv_vc1 = view.findViewById(R.id.tv_vc1);
        tv_vc2 = view.findViewById(R.id.tv_vc2);
        tv_vc3 = view.findViewById(R.id.tv_vc3);
        tv_vc4 = view.findViewById(R.id.tv_vc4);
        tv_vc5 = view.findViewById(R.id.tv_vc5);
        tv_vc6 = view.findViewById(R.id.tv_vc6);

        int t = tcl1.length();

        if (t > 1) {
            tv_vc1.setTextColor(Color.parseColor(tcl1));
            tv_vc2.setTextColor(Color.parseColor(tcl2));
            tv_vc3.setTextColor(Color.parseColor(tcl3));
            tv_vc4.setTextColor(Color.parseColor(tcl4));
            tv_vc5.setTextColor(Color.parseColor(tcl5));
            tv_vc6.setTextColor(Color.parseColor(tcl6));
        }
    }

    public void lounchEvents() {

        btn_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc1.setTextColor(Color.parseColor("#2B2A26"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol", "#2B2A26");
                editor.commit();
            }
        });

        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc1.setTextColor(Color.parseColor("#EC1010"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol", "#EC1010");
                editor.commit();
            }
        });

        btn_black2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc2.setTextColor(Color.parseColor("#2B2A26"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol2", "#2B2A26");
                editor.commit();
            }
        });

        btn_red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc2.setTextColor(Color.parseColor("#EC1010"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol2", "#EC1010");
                editor.commit();
            }
        });

        btn_black3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc3.setTextColor(Color.parseColor("#2B2A26"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol3", "#2B2A26");
                editor.commit();
            }
        });

        btn_red3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc3.setTextColor(Color.parseColor("#EC1010"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol3", "#EC1010");
                editor.commit();
            }
        });

        btn_black4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc4.setTextColor(Color.parseColor("#2B2A26"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol4", "#2B2A26");
                editor.commit();
            }
        });

        btn_red4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc4.setTextColor(Color.parseColor("#EC1010"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol4", "#EC1010");
                editor.commit();
            }
        });

        btn_black5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc5.setTextColor(Color.parseColor("#2B2A26"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol5", "#2B2A26");
                editor.commit();
            }
        });

        btn_red5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc5.setTextColor(Color.parseColor("#EC1010"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol5", "#EC1010");
                editor.commit();
            }
        });

        btn_black6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc6.setTextColor(Color.parseColor("#2B2A26"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol6", "#2B2A26");
                editor.commit();
            }
        });

        btn_red6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_vc6.setTextColor(Color.parseColor("#EC1010"));

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("texCol6", "#EC1010");
                editor.commit();
            }
        });
    }
}
