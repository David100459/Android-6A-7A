package com.example.btnrecycerview.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btnrecycerview.R;
import com.example.btnrecycerview.models.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentsViewHolder> {

    Context context;
    List<Student> list;

    public StudentAdapter(Context context, List<Student> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_student, parent, false);
        StudentsViewHolder svh = new StudentsViewHolder(v);

        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, final int position) {

        Student s = list.get(position);

        holder.idTv.setText(s.getId() + "");
        holder.nameTv.setText(s.getName());
        holder.genderTv.setText(s.isGender() ? "Masculino" : "Femenino");
        holder.ageTv.setText(s.getAge() + "");
        holder.codeTv.setText(s.getCode());
        holder.semesterTv.setText(s.getSemester() + "");

        //Button events
        //Delete
        holder.btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDelDialog(position);
            }
        });
        //Update
        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog(position);
            }
        });


    }

    private void showDelDialog(int position) {
        final Student s = list.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("¿Esta seguro que desea ELIMINAR el usuario  " + s.getName() + "?")
                .setTitle("¡ADVERTENCIA!");
        // Add the buttons
        builder.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(context, "El usuario " + s.getName() + " ha sido eliminado correctamente", Toast.LENGTH_LONG).show();
                // User clicked OK button
            }
        });
        builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showEditDialog(int position) {
        final Student s = list.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage("Datos del usuario " + s.getName())
                .setTitle("¿Desea actualizar?");

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_edit, null);
        EditText id = v.findViewById(R.id.id_et);
        id.setText(String.valueOf(s.getId()));
        EditText name = v.findViewById(R.id.name_et);
        name.setText(s.getName());
        EditText age = v.findViewById(R.id.age_et);
        age.setText(String.valueOf(s.getAge()));
        EditText cod = v.findViewById(R.id.code_et);
        cod.setText(s.getCode());
        EditText sem = v.findViewById(R.id.semester_et);
        sem.setText(String.valueOf(s.getSemester()));
        RadioButton rm = v.findViewById(R.id.man_rb);
        RadioButton rw = v.findViewById(R.id.women_rb);
        if (s.isGender()) {
            rm.setChecked(true);
            rw.setChecked(false);
        } else {
            rm.setChecked(false);
            rw.setChecked(true);
        }
        Button update = v.findViewById(R.id.update_btn);
        update.setOnClickListener(new View.OnClickListener() {
            //Method of saving edited data
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "El usuario " + s.getName() + " ha sido actualizado correctamente", Toast.LENGTH_LONG).show();
            }
        });
        builder.setView(v);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    // Nested class to control interface elements
    public static class StudentsViewHolder extends RecyclerView.ViewHolder {

        TextView idTv;
        TextView nameTv;
        TextView genderTv;
        TextView ageTv;
        TextView codeTv;
        TextView semesterTv;
        FloatingActionButton btEdit, btDel;


        public StudentsViewHolder(View itemView) {
            super(itemView);

            idTv = itemView.findViewById(R.id.id_tv);
            nameTv = itemView.findViewById(R.id.name_tv);
            genderTv = itemView.findViewById(R.id.gender_tv);
            ageTv = itemView.findViewById(R.id.age_tv);
            codeTv = itemView.findViewById(R.id.code_tv);
            semesterTv = itemView.findViewById(R.id.semester_tv);
            btEdit = itemView.findViewById(R.id.btnEdit);
            btDel = itemView.findViewById(R.id.btnDelete);
        }
    }

}
