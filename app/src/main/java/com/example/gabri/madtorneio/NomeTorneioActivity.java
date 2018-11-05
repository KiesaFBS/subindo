package com.example.gabri.madtorneio;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NomeTorneioActivity extends AppCompatActivity {
    private LinearLayout layout;
    private TextView nomeTor;
    private FloatingActionButton proximo;
    public List<String> equipes = new ArrayList<String>();
    public int qtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_torneio);


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

        for(int i = 0; i < qtd; i++) {
            View childAt = layout.getChildAt(i);
            if (childAt instanceof EditText) {
                equipes.add(((EditText)childAt).getText().toString());
            }
        }
        //configurando valores
        nomeTor.setText(nome);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  meusTorneiosActivity.class);
                intent.putExtra("nomesTime", (Serializable) equipes);


                startActivity(intent);
            }
        });
    }
}
