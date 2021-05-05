package com.example.ejemplologin.Fragments;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejemplologin.Activities.MainActivity;
import com.example.ejemplologin.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogosFragment extends Fragment {

    View view;
    Context context;
    Button btnCustomDialog;


    public DialogosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GaleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DialogosFragment newInstance(String param1, String param2) {
        DialogosFragment fragment = new DialogosFragment();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dialogos, container, false);
        context = view.getContext();

        lounchWidgets();
        louncEvents();

        return view;
    }

    public void lounchWidgets() {


        btnCustomDialog = view.findViewById(R.id.btn_custom_dialog);

    }

    public void louncEvents() {

        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);

                LayoutInflater inflater = getLayoutInflater();

                View vw = inflater.inflate(R.layout.dialog_layout, null);
                final EditText et_in_cd = vw.findViewById(R.id.et_in_cd);


                builder.setView(vw)
                        .setTitle("Dialogo Personalizado")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context, et_in_cd.getText().toString(), Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(), "Gracias", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();

            }
        });

    }
}