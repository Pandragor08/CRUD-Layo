package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    SharedPreferences preferences;
    EditText email,pass,name;
    Button registrar;
    String koala;
    dataUser dt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        registrar=findViewById(R.id.guardar);
        dt= new dataUser(this);

        preferences = getApplicationContext().getSharedPreferences("typeuser",MODE_PRIVATE);
        koala = preferences.getString("user","");
        Toast.makeText(this, "Se registrara como "+ koala, Toast.LENGTH_SHORT).show();

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    guarda();
            }
        });
    }

    private void guarda() {
        String sname = name.getText().toString();
        String semail = email.getText().toString();
        String spass = pass.getText().toString();
        Usuario u=new Usuario();
        u.setName(name.getText().toString());
        u.setEmail(email.getText().toString());
        u.setPasswords(pass.getText().toString());

        if (!sname.isEmpty() && !semail.isEmpty() && !spass.isEmpty()){
            if (pass.length()>=6){
                if (koala.equals("usuario")){
                    if (dt.insertar(u)){
                        Toast.makeText(this, "Registro exitoso como " + koala, Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(this,sesion_start.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(this, "Usuario ya existe", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    if (dt.insertarV(u)){
                        Toast.makeText(this, "Registro exitoso como " + koala, Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(this,sesion_start.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(this, "Usuario ya existe", Toast.LENGTH_SHORT).show();
                    }
                }


            }else {
                Toast.makeText(this, "contraseña menor de 6 caracteres", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
        }


    }
}