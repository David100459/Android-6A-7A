package com.example.estudentsdata.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.estudentsdata.MainActivity;
import com.example.estudentsdata.R;
import com.example.estudentsdata.models.Student;
import com.example.estudentsdata.utils.DBM;

public class HomeFragment extends Fragment {

    View root;

    EditText idEt;
    EditText nameEt;
    RadioGroup genderRg;
    RadioButton rbMan;
    RadioButton rbWomen;
    EditText ageEt;
    EditText codeEt;
    EditText semesterEt;
    Button btnSave;

    Student student;
    Context context;
    DBM dbm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);

        lounchWidgets();
        lounchEvents();


        return root;
    }

    public void lounchWidgets() {

        context = root.getContext();
        dbm = new DBM(context);

        idEt = root.findViewById(R.id.id_et);
        nameEt = root.findViewById(R.id.name_et);
        genderRg = root.findViewById(R.id.gender_et);
        rbMan = root.findViewById(R.id.man_rb);
        rbWomen = root.findViewById(R.id.women_rb);
        ageEt = root.findViewById(R.id.age_et);
        codeEt = root.findViewById(R.id.code_et);
        semesterEt = root.findViewById(R.id.semester_et);
        btnSave = root.findViewById(R.id.save_btn);


    }

    public void lounchEvents() {

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student = new Student(
                        Integer.parseInt(idEt.getText().toString()),
                        nameEt.getText().toString(),
                        rbMan.isChecked() == true ? true : false,
                        Short.parseShort(ageEt.getText().toString()),
                        codeEt.getText().toString(),
                        Integer.parseInt(semesterEt.getText().toString())
                );
                //MainActivity.studentsList.add(student);
                boolean ret = dbm.insertStudentTuple(student);

                if (ret == true) {
                    Toast.makeText(context, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                    idEt.setText("");
                    nameEt.setText("");
                    rbMan.setChecked(false);
                    rbWomen.setChecked(false);
                    ageEt.setText("");
                    codeEt.setText("");
                    semesterEt.setText("");
                }
                else {
                    Toast.makeText(context, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}