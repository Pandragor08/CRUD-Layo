package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarActivity extends AppCompatActivity {

    EditText editText1,editText2,editText3;
    Button btn1,btn2;
    String id, name, cedula, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        editText1=findViewById(R.id.nombre);
        editText2=findViewById(R.id.cedula);
        editText3=findViewById(R.id.costo);
        btn1=findViewById(R.id.update);
        btn2=findViewById(R.id.deleteR);

        getdata();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataMedicament myDB = new dataMedicament(EliminarActivity.this);
                name = editText1.getText().toString().trim();
                cedula = editText2.getText().toString().trim();
                precio = editText3.getText().toString().trim();
                myDB.updateM(id, name, cedula, precio);
                Intent intent=new Intent(EliminarActivity.this,ModificarActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmar();
            }
        });


    }

    private void confirmar() {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("¿Eliminar"+ name +" del inventario?");
        builder.setMessage("¿Esta seguro de quierer eliminar" + name +"?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dataMedicament db=new dataMedicament(EliminarActivity.this);
                db.eliminar(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    private void getdata() {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("matricula") && getIntent().hasExtra("precio")){

            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            cedula = getIntent().getStringExtra("matricula");
            precio = getIntent().getStringExtra("precio");


            editText1.setText(name);
            editText2.setText(cedula);
            editText3.setText(precio);
            Log.d("stev", name+" "+cedula+" "+precio);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}