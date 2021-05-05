package com.example.estudentsdata.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudentsdata.R;
import com.example.estudentsdata.models.Student;

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
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {

        Student s = list.get(position);

        holder.idTv.setText(s.getId()+"");
        holder.nameTv.setText(s.getName());
        holder.genderTv.setText(s.isGender()?"Masculino": "Femenino");
        holder.ageTv.setText(s.getAge()+"");
        holder.codeTv.setText(s.getCode());
        holder.semesterTv.setText(s.getSemester()+"");

        //Eventos a los botones
        //Delete: debe abrir un dialogo de confirmación
        //Update: Debe abrir un dialogo con el formulario para llenar los datos

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
    public static class StudentsViewHolder extends RecyclerView.ViewHolder {

        TextView idTv;
        TextView nameTv;
        TextView genderTv;
        TextView ageTv;
        TextView codeTv;
        TextView semesterTv;


        public StudentsViewHolder(View itemView) {
            super(itemView);

            idTv = itemView.findViewById(R.id.id_tv);
            nameTv = itemView.findViewById(R.id.name_tv);
            genderTv = itemView.findViewById(R.id.gender_tv);
            ageTv = itemView.findViewById(R.id.age_tv);
            codeTv = itemView.findViewById(R.id.code_tv);
            semesterTv = itemView.findViewById(R.id.semester_tv);

        }
    }


}
