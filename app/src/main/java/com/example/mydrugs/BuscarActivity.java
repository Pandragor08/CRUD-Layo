package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class BuscarActivity extends AppCompatActivity {

    Button btmbuscar;
    EditText buscaM,medi5,preci5,matri5;
    ImageButton btnL;
    dataMedicament dataMedicament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        btmbuscar=findViewById(R.id.buscador);
        buscaM=findViewById(R.id.buscaMatri);
        medi5=findViewById(R.id.medi5);
        matri5=findViewById(R.id.ma5);
        preci5=findViewById(R.id.preci5);


        btnL=findViewById(R.id.back_R);

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(BuscarActivity.this,menuSeller.class);
                startActivity(intent);
                finish();
            }
        });

        btmbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acts();

            }
        });
    }

    private void acts() {
        String n=buscaM.getText().toString();
        if (n.isEmpty()){
            Toast.makeText(this, "No has ingresado nada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "AHORITA LA BUSCO", Toast.LENGTH_SHORT).show();
        }

    }
}