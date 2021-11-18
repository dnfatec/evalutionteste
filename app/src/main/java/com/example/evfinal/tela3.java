package com.example.evfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tela3 extends AppCompatActivity {

    TextView indiceLPA;
    TextView indicePayout;
    TextView indiceDividend;
    TextView indicePL;
    Button btRefazer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        //REFERÊNCIAR OS OBJETOS
        indiceLPA = (TextView) findViewById(R.id.txtLPAResult);
        indicePayout = (TextView) findViewById(R.id.txtPayoutResult);
        indiceDividend = (TextView) findViewById(R.id.txtDividendResult);
        indicePL = (TextView) findViewById(R.id.txtPLResult);
        btRefazer = (Button) findViewById(R.id.btnRefazer);

        //PEGAR VALOR DA OUTRA TELA
        Intent CampoLPA = getIntent();
        if (CampoLPA != null) {
            String dadosRecebidos = CampoLPA.getStringExtra("resultadoLPA");
            Log.d("filtro", dadosRecebidos + " valor");
            indiceLPA.setText(dadosRecebidos.toString());
            if (dadosRecebidos != null) {
                String resultadoUltimoano = dadosRecebidos;
                indiceLPA.setText(dadosRecebidos);
            }
        }
        Intent CampoPayout = getIntent();
        if (CampoPayout != null) {
            String dadosRecebidos = CampoPayout.getStringExtra("resultadoPayout");
            Log.d("filtro", dadosRecebidos + " valor");
            indicePayout.setText(dadosRecebidos.toString());
            if (dadosRecebidos != null) {
                String resultadoUltimoano = dadosRecebidos;
                indicePayout.setText(dadosRecebidos);
            }
        }
        Intent CampoDividend = getIntent();
        if (CampoDividend != null) {
            String dadosRecebidos = CampoDividend.getStringExtra("resultadoDividend");
            Log.d("filtro", dadosRecebidos + " valor");
            indiceDividend.setText(dadosRecebidos.toString());
            if (dadosRecebidos != null) {
                String resultadoUltimoano = dadosRecebidos;
                indiceDividend.setText(dadosRecebidos);
            }
        }
        Intent CampoPL = getIntent();
        if (CampoPL != null) {
            String dadosRecebidos = CampoPL.getStringExtra("resultadoPL");
            Log.d("filtro", dadosRecebidos + " valor");
            indicePL.setText(dadosRecebidos.toString());
            if (dadosRecebidos != null) {
                String resultadoUltimoano = dadosRecebidos;
                indicePL.setText(dadosRecebidos);
            }
        }

        //AÇÃO BOTÃO REFAZER
        btRefazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), tela1.class);
                startActivity(intent);
            }
        });
    }
}
