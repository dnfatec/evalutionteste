package com.example.evfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class tela1 extends AppCompatActivity {   TextView resultadoFinal;
    TextView resultadoPayout;
    TextView resultadoDividend;
    TextView resultadoPL;
    EditText LucroLiquido;
    EditText AcoesEmitidas;
    EditText Dividendos;
    EditText PrecoAcao;
    ImageButton AjudaLPA;
    ImageButton AjudaPayout;
    ImageButton AjudaDividendYield;
    ImageButton AjudaPL;
    Button btcalcular;
    ImageButton btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //REFERENCIANDO OBJETOS
        carregaWidgets();
        calculos();
        //PEGAR VALOR DA OUTRA TELA
        /*Intent dados = getIntent();
        if(dados != null){
            String dadosRecebidos = dados.getStringExtra("resultadoUltimo");
            Log.d("filtro", dadosRecebidos+ "");
            resultadoFinal.setText(dadosRecebidos.toString());
            if(dadosRecebidos != null) {
                String resultadoUltimoano = dadosRecebidos;
                resultado.setText(dadosRecebidos);
            }
        }*/

        //LIMPAR O EDITTEXT AO TOCAR

    }

    private void calculos() {
        LucroLiquido.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) LucroLiquido.setText("");
                return false;
            }
        });
        AcoesEmitidas.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) AcoesEmitidas.setText("");
                return false;
            }
        });
        Dividendos.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) Dividendos.setText("");
                return false;
            }
        });
        PrecoAcao.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) PrecoAcao.setText("");
                return false;
            }
        });

        //AÇÕES DO BOTÃO AJUDA
        AjudaLPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "O LPA indica o quanto de lucro líquido tem no valor de cada ação", Toast.LENGTH_SHORT).show();
            }
        });
        AjudaPayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "O PAYUOT indica a porcentagem de lucro, ou dividendo, que uma ação gera", Toast.LENGTH_SHORT).show();
            }
        });
        AjudaDividendYield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "O DIVIDEND YIELD indica o quanto o acionista teve de retorno perante o capital investido", Toast.LENGTH_SHORT).show();
            }
        });
        AjudaPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Esse índice representa o montante que os investidores estão dispostos a pagar por reais de lucro da empresa. Quanto maior, melhor", Toast.LENGTH_SHORT).show();
            }
        });

        //AÇÃO BOTÃO CALCULAR

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //botaoCalcular();


    }

    private void botaoCalcular() {
        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //IR PARA A PRÓXIMA TELA
                //   Intent intent = new Intent(getApplicationContext(), tela3.class);
                //   startActivity(intent);

                //COMEÇANDO O CALCULO
                //CONVERTENDO STRING PARA DOUBLE
                double LucroLiquido1 = Double.parseDouble(LucroLiquido.getText().toString());
                double AcoesEmitidas1 = Double.parseDouble(AcoesEmitidas.getText().toString());
                double Dividendos1 = Double.parseDouble(Dividendos.getText().toString());
                double PrecoAcao1 = Double.parseDouble(PrecoAcao.getText().toString());

                //CALCULANDO LPA
                double LPA = LucroLiquido1 / AcoesEmitidas1;

                //CALCULANDO PAYOUT
                double Payout = Dividendos1 / LPA;

                //CALCULANDO DIVIDEND YIELD
                double DividendYield = Dividendos1 / PrecoAcao1;

                //CALCULANDO P/L
                double PL = PrecoAcao1 / LPA;

                //FORMATANDO OS ÍNDICES PARA DUAS CASAS APÓS A VÍRGULA
                String resultadoLPA = String.format("%.5f", LPA);
                String resultadoPayout = String.format("%.5f", Payout);
                String resultadoDividendYield = String.format("%.5f", DividendYield);
                String resultadoPL = String.format("%.5f", PL);

                //EXIBINDO O RESULTADO
                resultadoFinal.setText(resultadoLPA + "%");
                resultadoDividend.setText(resultadoDividendYield + "%");

                //ENVIA PARA OUTRA TELA
                //  Intent intentEnviadora = new Intent(tela1.this, tela3.class);
                //  intentEnviadora.putExtra("resultadoUltimo", resultadoFinal.getText().toString());
                // startActivity(intentEnviadora);
            }
        });

    }

    private void carregaWidgets() {
        resultadoFinal = (TextView) findViewById(R.id.txtLPAResult);
        resultadoPayout = (TextView) findViewById(R.id.txtPayoutResult);
        resultadoDividend = (TextView) findViewById(R.id.txtDividendResult);
        resultadoPL = (TextView) findViewById(R.id.txtPLResult);
        LucroLiquido = (EditText) findViewById(R.id.edtLucroLiquido);
        AcoesEmitidas = (EditText) findViewById(R.id.edtAcoesEmitidas);
        Dividendos = (EditText) findViewById(R.id.edtDividendos);
        PrecoAcao = (EditText) findViewById(R.id.edtPrecoAcao);
        btcalcular = (Button) findViewById(R.id.btnCalcular);
        btVoltar = (ImageButton)findViewById(R.id.btnVoltar);

    }
}
