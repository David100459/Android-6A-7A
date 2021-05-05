package com.example.btnrecycerview.ui.gallery;

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

import com.example.btnrecycerview.Adapters.StudentAdapter;
import com.example.btnrecycerview.R;
import com.example.btnrecycerview.models.Student;
import com.example.btnrecycerview.utils.DBM;

import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView rv;
    List<Student> list;
    StudentAdapter adapter;

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

        rv = root.findViewById(R.id.students_rv);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);

        adapter = new StudentAdapter(context, list);

        rv.setAdapter(adapter);
        Log.d("Data", data);
    }

    public void lounchEvents() {

    }

    public void lounchData() {
        context = root.getContext();
        dbm = new DBM(context);
        list = dbm.listStudents();
        data = "";
        //ArrayList<Student> l = dbm.listStudents();
        for (int i = 0; i < list.size(); i++) {
            data += "\n\t***\tDatos del estudiante " + (i + 1) + "\t***\n";
            data += list.get(i).toString();
        }
    }
}