package com.example.mydrugs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class menuUser extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton btnexit;

    dataMedicament dataMedicament;
    ArrayList<String> medicamento_id,name_m,matricula_m,precio_m;
    AdapterDatos adapterDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
        btnexit=findViewById(R.id.button);
        recyclerView=findViewById(R.id.ret);

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menuUser.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dataMedicament = new dataMedicament(menuUser.this);
        medicamento_id = new ArrayList<>();
        name_m = new ArrayList<>();
        matricula_m = new ArrayList<>();
        precio_m = new ArrayList<>();

        datosM();
        adapterDatos =new AdapterDatos(menuUser.this,this,medicamento_id,name_m, matricula_m,precio_m);
        recyclerView.setAdapter(adapterDatos);
        recyclerView.setLayoutManager(new LinearLayoutManager(menuUser.this));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void datosM(){
        Cursor cursor = dataMedicament.readM();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No hay medicamento disponible", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                medicamento_id.add(cursor.getString(0));
                name_m.add(cursor.getString(1));
                matricula_m.add(cursor.getString(2));
                precio_m.add(cursor.getString(3));
            }

        }
    }
}