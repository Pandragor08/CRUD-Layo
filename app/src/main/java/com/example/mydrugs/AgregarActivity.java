package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {

    EditText name,matricula,precio;
    Button registrarM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        name=findViewById(R.id.namemedicamento);
        matricula=findViewById(R.id.matricula);
        precio=findViewById(R.id.precio);
        registrarM=findViewById(R.id.addmedicamento);

        registrarM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    agregar();
            }
        });
    }

    private void agregar() {
        String e =name.getText().toString();
        String e2 =matricula.getText().toString();
        String e3 =precio.getText().toString();

        if (e.isEmpty()&&e2.isEmpty()&&e3.isEmpty()){

            Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show();

        }else if(e.isEmpty()){
            Toast.makeText(this, "LLena el campo del medicamento", Toast.LENGTH_SHORT).show();
        }else if(e2.isEmpty()){
            Toast.makeText(this, "LLena el campo de la matricula", Toast.LENGTH_SHORT).show();
        }else if(e3.isEmpty()){
            Toast.makeText(this, "LLena el campo de precio", Toast.LENGTH_SHORT).show();
        }
        else{
            dataMedicament dM =new dataMedicament(AgregarActivity.this);
            dM.addM(name.getText().toString().trim(),
                    Integer.valueOf(matricula.getText().toString().trim()),
                    Integer.valueOf(precio.getText().toString().trim()));

            Intent intent=new Intent(AgregarActivity.this,menuSeller.class);
            startActivity(intent);
        }
    }


}