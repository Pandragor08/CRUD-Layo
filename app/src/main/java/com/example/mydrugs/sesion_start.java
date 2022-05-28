package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sesion_start extends AppCompatActivity {

    SharedPreferences preferences;
    EditText sname;
    Button btni;
    String koala;
    dataUser du;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_start);
        sname=findViewById(R.id.emailsesion);
        btni=findViewById(R.id.ss3);
        du=new dataUser(this);

        preferences = getApplicationContext().getSharedPreferences("typeuser",MODE_PRIVATE);
        koala = preferences.getString("user","");
        Toast.makeText(this, "Iniciara sesion como "+ koala, Toast.LENGTH_SHORT).show();

        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ingresaU();
            }
        });

    }


    private void ingresaU() {
        String na=sname.getText().toString();

        if (koala.equals("usuario")){
            if (na.equals("")){
                Toast.makeText(sesion_start.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
            }else if (du.login(na)==1){
                Toast.makeText(sesion_start.this, "Datos correctos", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(sesion_start.this,menuUser.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
            }
        }else {
            if (na.equals("")){
                Toast.makeText(sesion_start.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
            }else if (du.loginV(na)==1){
                Toast.makeText(sesion_start.this, "Datos correctos", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(sesion_start.this,menuSeller.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
            else {
                Toast.makeText(this, "Usuario incorrecta", Toast.LENGTH_SHORT).show();
            }
        }


    }
}