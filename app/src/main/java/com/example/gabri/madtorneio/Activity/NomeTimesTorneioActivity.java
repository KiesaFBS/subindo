package com.example.gabri.madtorneio.Activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gabri.madtorneio.R;

import java.util.ArrayList;

public class NomeTimesTorneioActivity extends AppCompatActivity {
    private LinearLayout layout;
    private TextView nomeTor;
    private FloatingActionButton proximo;
    public ArrayList<String> equipes = new ArrayList<>();
    public int qtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_time_torneio);


        //criando o banco de dados
        try {

            SQLiteDatabase BancoDeDados = openOrCreateDatabase("nomeTimes", MODE_PRIVATE, null); //modo privado

        }catch (Exception e){
            e.printStackTrace();
        }
        nomeTor = findViewById(R.id.nomeTorneio);
        layout = findViewById(R.id.layout);
        proximo = findViewById(R.id.proximo);
        //recuperando os dados enviados usando o bundle

         Bundle dados = getIntent().getExtras();
         final String nome = dados.getString("nomeTorneio");
         int qtdTimes = dados.getInt("qtdTorneio");

         for(int i =0; i < qtdTimes ; i++){
             layout.addView(new EditText(getApplicationContext()));
         }

        qtd = layout.getChildCount();


        Log.d("elementos",equipes.toString());
        nomeTor.setText(nome);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  dueloTorneiosActivity.class);
                Log.d("qtd", String.valueOf(qtd));

                //equipes = new ArrayList<>();

                for(int i = 0; i < layout.getChildCount(); i++) {
                    EditText childAt = (EditText) layout.getChildAt(i);
                    Log.d("ccc", childAt.getText().toString());
                    equipes.add(childAt.getText().toString());
                }
                //configurando valores

                intent.putExtra("times",equipes);


                startActivity(intent);
            }
        });
    }
}
