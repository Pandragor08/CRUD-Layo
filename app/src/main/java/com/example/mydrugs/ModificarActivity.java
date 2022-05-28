package com.example.mydrugs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ModificarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    dataMedicament dataMedicament;
    ArrayList<String> medicamento_id,name_m,matricula_m,precio_m;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        recyclerView=findViewById(R.id.eliedi);

        dataMedicament = new dataMedicament(ModificarActivity.this);
        medicamento_id = new ArrayList<>();
        name_m = new ArrayList<>();
        matricula_m = new ArrayList<>();
        precio_m = new ArrayList<>();
        datoM();
        customAdapter =new CustomAdapter(ModificarActivity.this,this,medicamento_id,name_m,
                matricula_m,precio_m);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ModificarActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    private void datoM() {
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