package com.example.mydrugs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList medicamento_id, name_m, matricula_m, precio_m;
    Activity activity;

    CustomAdapter(Activity activity, Context context,
                  ArrayList medicamento_id,
                  ArrayList name_m,
                  ArrayList matricula_m,
                  ArrayList precio_m ){

        this.activity = activity;

        this.context=context;
        this.medicamento_id=medicamento_id;
        this.name_m=name_m;
        this.matricula_m=matricula_m;
        this.precio_m=precio_m;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.tarjetin, parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.medicamento_id_txt.setText(String.valueOf(medicamento_id.get(position)));
        holder.name_m_txt.setText(String.valueOf(name_m.get(position)));
        holder.matricula_m_txt.setText(String.valueOf(matricula_m.get(position)));
        holder.precio_m_txt.setText(String.valueOf(precio_m.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, EliminarActivity.class);
                    intent.putExtra("id", String.valueOf(medicamento_id.get(position)));
                    intent.putExtra("name", String.valueOf(name_m.get(position)));
                    intent.putExtra("matricula", String.valueOf(matricula_m.get(position)));
                    intent.putExtra("precio", String.valueOf(precio_m.get(position)));
                    activity.startActivityForResult(intent,1);
                }
            });
    }



    @Override
    public int getItemCount() {
        return medicamento_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView medicamento_id_txt, name_m_txt, matricula_m_txt, precio_m_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            medicamento_id_txt = itemView.findViewById(R.id.book_id_txt);
            name_m_txt = itemView.findViewById(R.id.book_title_txt);
            matricula_m_txt = itemView.findViewById(R.id.book_author_txt);
            precio_m_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
