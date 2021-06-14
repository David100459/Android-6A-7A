package com.david.mydog.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.david.mydog.Adapters.PetsAdapter;
import com.david.mydog.R;
import com.david.mydog.models.Pets;
import com.david.mydog.utils.DBM;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    public TextView textView;
    public RecyclerView rv;
    public List<Pets> list;
    public PetsAdapter adapter;

    Context context;
    DBM dbm;
    String data;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_gallery, container, false);

        lounchData();
        lounchWidgets();
        lounchEvents();

        return root;
    }

    public void lounchWidgets() {
        //textView = root.findViewById(R.id.text_gallery);
        //textView.setText(data);

        rv = root.findViewById(R.id.pets_rv);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);

        adapter = new PetsAdapter(context, list, this);

        rv.setAdapter(adapter);
        Log.d("Data", data);
    }

    public void lounchEvents() {

    }


    public void lounchData() {
        context = root.getContext();
        dbm = new DBM(context);
        list = dbm.listPets();
        data = "";
        //ArrayList<Pets> l = dbm.listPets();
        for (int i = 0; i < list.size(); i++) {
            data += "\n\t***\tDatos de la mascota " + (i + 1) + "\t***\n";
            data += list.get(i).toString();
        }
    }
}