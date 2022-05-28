package com.example.mydrugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;
    int progreso =0;
    Handler handler =new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar=findViewById(R.id.barradeporgreso);
        textView=findViewById(R.id.carga);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progreso < 100){
                    progreso+=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progreso);
                            if(progreso==100){
                                Intent intent=new Intent(splash.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(splash.this, "Bienvenido a MyDrugs", Toast.LENGTH_SHORT).show();
                            }
                            textView.setText(progreso+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(200);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}