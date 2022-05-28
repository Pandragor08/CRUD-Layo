package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menuSeller extends AppCompatActivity {

ImageButton bsalida,btnbuscar,btnagregar,btnmodificar,btneliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_seller);
        bsalida=findViewById(R.id.salida);

        btnbuscar=findViewById(R.id.buscarr);
        btnagregar=findViewById(R.id.agregar);
        btnmodificar=findViewById(R.id.modificarr);
        btneliminar=findViewById(R.id.eliminarr);

        bsalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menuSeller.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(menuSeller.this,AgregarActivity.class);
                startActivity(intent);
            }
        });

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(menuSeller.this,BuscarActivity.class);
                startActivity(intent);
            }
        });

        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(menuSeller.this,ModificarActivity.class);
                startActivity(intent);
            }
        });

        btnmodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(menuSeller.this,ModificarActivity.class);
                startActivity(intent);
            }
        });


    }
}