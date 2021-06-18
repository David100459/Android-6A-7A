package com.david.mydog.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.david.mydog.R;
import com.david.mydog.models.Pets;
import com.david.mydog.utils.DBM;

public class HomeFragment extends Fragment {

    View root;

    EditText nameEt;
    EditText speciesEt;
    EditText raceEt;
    EditText hairColorEt;
    EditText dateBirthEt;
    EditText weightEt;
    EditText ownerNameEt;
    EditText ownersIDEt;
    Button btnSave;
    Pets pets;
    DBM dbm;
    Context context;


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

        nameEt = root.findViewById(R.id.name_et);
        speciesEt = root.findViewById(R.id.species_et);
        raceEt = root.findViewById(R.id.race_et);
        hairColorEt = root.findViewById(R.id.hairColor_et);
        dateBirthEt = root.findViewById(R.id.dateBirth_et);
        weightEt = root.findViewById(R.id.weight_et);
        ownerNameEt = root.findViewById(R.id.ownersName_et);
        ownersIDEt = root.findViewById(R.id.ownersID_et);
        btnSave = root.findViewById(R.id.btn_save);
    }

    public void lounchEvents() {

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pets = new Pets(
                        nameEt.getText().toString(),
                        speciesEt.getText().toString(),
                        raceEt.getText().toString(),
                        hairColorEt.getText().toString(),
                        dateBirthEt.getText().toString(),
                        Integer.parseInt(weightEt.getText().toString()),
                        ownerNameEt.getText().toString(),
                        Integer.parseInt(ownersIDEt.getText().toString())
                );
                // MainActivity.petsList.add(pets);
                boolean ret = dbm.insertPetTuple(pets);

                if (ret == true) {
                    Toast.makeText(context, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                    nameEt.setText("");
                    speciesEt.setText("");
                    raceEt.setText("");
                    hairColorEt.setText("");
                    dateBirthEt.setText("");
                    weightEt.setText("");
                    ownerNameEt.setText("");
                    ownersIDEt.setText("");
                } else {
                    Toast.makeText(context, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}

 