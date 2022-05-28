package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button btnvendedor,btncomprador;
    SharedPreferences Fpreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncomprador=findViewById(R.id.comprar);
        btnvendedor=findViewById(R.id.admin);

        Fpreference =getApplicationContext().getSharedPreferences("typeuser",MODE_PRIVATE);
        SharedPreferences.Editor editor = Fpreference.edit();


        btnvendedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("user","vendedor");
                editor.apply();
                Intent intent=new Intent(MainActivity.this,Eleccion.class);
                startActivity(intent);
            }
        });

        btncomprador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("user","usuario");
                editor.apply();
                Intent intent=new Intent(MainActivity.this,Eleccion.class);
                startActivity(intent);
            }
        });
    }
}