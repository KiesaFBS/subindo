package com.example.gabri.madtorneio.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabri.madtorneio.R;

public class ganhou extends AppCompatActivity {

    private TextView texto1;
    private TextView texto2;
    private TextView ponto1;
    private TextView ponto2;
    private FloatingActionButton soma1;
    private FloatingActionButton sub1;
    private FloatingActionButton soma2;
    private FloatingActionButton sub2;
    private Button botao;

    private int posicao;
    private int cont = 0;
    private int cont1 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganhou);

        texto1 = findViewById(R.id.Time1);
        texto2 = findViewById(R.id.Time2);
        ponto1 = findViewById(R.id.Placar1);
        ponto2 = findViewById(R.id.Placar2);
        soma1 = findViewById(R.id.btSoma1);
        soma2 = findViewById(R.id.btSoma2);
        sub1 = findViewById(R.id.btSub1);
        sub2 = findViewById(R.id.btSub2);
        botao = findViewById(R.id.button);

        ponto1.setText(String.valueOf(cont));
        ponto2.setText(String.valueOf(cont1));

        Bundle bundle = getIntent().getExtras();
        posicao = bundle.getInt("pos_elemento");
        texto1.setText(bundle.getString("time1"));
        texto2.setText(bundle.getString("time2"));
        soma1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont ++;
                ponto1.setText(String.valueOf(cont));
            }
        });

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont --;
                if(cont < 0){
                    cont = 0;
                    ponto1.setText(String.valueOf(cont));
                }else {
                    ponto1.setText(String.valueOf(cont));
                }

            }
        });

        soma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont1 ++;
                ponto2.setText(String.valueOf(cont1));
            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont1 --;
                if(cont < 0){
                    cont = 0;
                    ponto2.setText(String.valueOf(cont1));
                }else {
                    ponto2.setText(String.valueOf(cont1));
                }
            }
        });

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dueloTorneiosActivity.class);

                intent.putExtra("pontuacao1",cont);
                intent.putExtra("pontuacao2",cont1);
                intent.putExtra("pos_elemento", posicao);

                setResult(RESULT_OK, intent);

                finish();


            }
        });

    }
}
