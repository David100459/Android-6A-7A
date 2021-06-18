package com.david.mydog.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.david.mydog.Fragments.GalleryFragment;
import com.david.mydog.R;
import com.david.mydog.models.Pets;
import com.david.mydog.utils.DBM;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.PetsViewHolder> {


    Context context;
    List<Pets> list;
    DBM dbm;
    GalleryFragment gf;

    public PetsAdapter(Context context, List<Pets> list, GalleryFragment org) {
        this.context = context;
        this.list = list;
        dbm = new DBM(context);
        gf = org;
    }

    @NonNull
    @Override
    public PetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pets, parent, false);
        PetsViewHolder svh = new PetsViewHolder(v);

        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull PetsViewHolder holder, int position) {

        final Pets s = list.get(position);


        holder.nameTv.setText(s.getName());
        holder.speciesTv.setText(s.getSpecies());
        holder.raceTv.setText(s.getRace());
        holder.hairColorTv.setText(s.getHairColor());
        holder.dateBirthTv.setText(s.getDateBirth());
        holder.weightTv.setText(s.getWeight() + "");
        holder.ownerNameTv.setText(s.getOwnerName());
        holder.ownersIDTv.setText(s.getOwnersID() + "");

        //Eventos a los botones
        //Delete: debe abrir un dialogo de confirmación


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("¿Esta seguro que desea borrar este registro?")
                        .setTitle("Borrar registro")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                boolean ret = dbm.deletePetsById(s);
                                if (ret) {
                                    gf.list = dbm.listPets();
                                    gf.adapter = new PetsAdapter(gf.getContext(), gf.list, gf);
                                    gf.rv.setAdapter(gf.adapter);
                                    Toast.makeText(context, "Se ha borrado el registro", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();
            }
        });
        //Update: Debe abrir un dialogo con el formulario para llenar los datos
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = gf.getLayoutInflater();

                View v = inflater.inflate(R.layout.dialog_ly, null);

                final EditText nameEt = v.findViewById(R.id.name_et);
                final EditText speciesET = v.findViewById(R.id.species_et);
                final EditText raceET = v.findViewById(R.id.race_et);
                final EditText hairColorET = v.findViewById(R.id.hairColor_et);
                final EditText dateBirthET = v.findViewById(R.id.dateBirth_et);
                final EditText weightET = v.findViewById(R.id.weight_et);
                final EditText ownerNamET = v.findViewById(R.id.ownersName_et);
                final EditText ownersIDET = v.findViewById(R.id.ownersID_et);
                final Button btnSave = v.findViewById(R.id.btn_save);

                nameEt.setText(s.getName());
                speciesET.setText(s.getSpecies());
                raceET.setText(s.getRace());
                hairColorET.setText(s.getHairColor());
                dateBirthET.setText(s.getDateBirth());
                weightET.setText(s.getWeight() + "");
                ownerNamET.setText(s.getOwnerName());
                ownersIDET.setText(s.getOwnersID() + "");
                ownersIDET.setEnabled(false);


                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        s.setName(nameEt.getText().toString());
                        s.setSpecies(speciesET.getText().toString());
                        s.setRace(raceET.getText().toString());
                        s.setHairColor(hairColorET.getText().toString());
                        s.setDateBirth(dateBirthET.getText().toString());
                        s.setWeight(Integer.parseInt(weightET.getText().toString()));
                        s.setOwnerName(ownerNamET.getText().toString());


                        boolean ret = dbm.updatePets(s);

                        if (ret == true) {
                            Toast.makeText(context, "Registro Actualizado", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(context, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setView(v)
                        .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });
                builder.setCancelable(true);
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    /*
            Clase anidada para controlar los elementos de la interfaz
        */

    public static class PetsViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        TextView speciesTv;
        TextView raceTv;
        TextView hairColorTv;
        TextView dateBirthTv;
        TextView weightTv;
        TextView ownerNameTv;
        TextView ownersIDTv;
        FloatingActionButton btnDelete;
        FloatingActionButton btnUpdate;


        public PetsViewHolder(View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.name_tv);
            speciesTv = itemView.findViewById(R.id.species_tv);
            raceTv = itemView.findViewById(R.id.race_tv);
            hairColorTv = itemView.findViewById(R.id.hairColor_tv);
            dateBirthTv = itemView.findViewById(R.id.dateBirth_tv);
            weightTv = itemView.findViewById(R.id.weight_tv);
            ownerNameTv = itemView.findViewById(R.id.ownerName_tv);
            ownersIDTv = itemView.findViewById(R.id.ownersID_tv);
            btnDelete = itemView.findViewById(R.id.btn_del);
            btnUpdate = itemView.findViewById(R.id.btn_upd);

        }
    }

}