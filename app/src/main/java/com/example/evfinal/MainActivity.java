package com.example.evfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton BtnInicio;
    private Button btComecar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERENCIANDO OBJETOS
        BtnInicio = (ImageButton) findViewById(R.id.imgBtnInicio);

        //AÇÃO DO BOTÃO PRÓXIMO
        BtnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "abrir", Toast.LENGTH_LONG).show();
                //IR PARA A PRÓXIMA TELA
                Intent intent = new Intent(MainActivity.this, tela1.class);
                startActivity(intent);
            }
        });

        btComecar=(Button)findViewById(R.id.btnAbrir);
        btComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela1.class);
                startActivity(intent);
            }
        });

    }
}