package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Eleccion extends AppCompatActivity {

    Button btnsesion,btnregister;
    SharedPreferences preferences;
    String koala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion);
        btnregister=findViewById(R.id.registro);
        btnsesion=findViewById(R.id.sesion);

        preferences = getApplicationContext().getSharedPreferences("typeuser",MODE_PRIVATE);
        koala = preferences.getString("user","");
        Toast.makeText(this, "Iniciara sesion como "+ koala, Toast.LENGTH_SHORT).show();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Eleccion.this,register.class);
                startActivity(intent);
                finish();
            }
        });

        btnsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Eleccion.this, sesion_start.class);
                startActivity(intent);

            }
        });
    }
}