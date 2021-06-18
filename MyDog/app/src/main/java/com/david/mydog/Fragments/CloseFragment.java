package com.david.mydog.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.david.mydog.Activity.MainActivity;
import com.david.mydog.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CloseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CloseFragment extends Fragment {

    View view;
    Context context;

    public CloseFragment() {

    }

    public static CloseFragment newInstance(String param1, String param2) {
        CloseFragment fragment = new CloseFragment();
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


        view = inflater.inflate(R.layout.fragment_close, container, false);
        context = view.getContext();

        lounchWidgets();
        lounchEvents();

        return view;
    }

    public void lounchWidgets(){


    }

    public void lounchEvents(){

        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);

    }
}