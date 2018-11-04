package com.example.gabri.madtorneio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NomeTorneioActivity extends AppCompatActivity {

    private TextView nomeTor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_torneio);

        nomeTor = findViewById(R.id.nomeTorneio);

        //recuperando os dados enviados usando o bundle

         Bundle dados = getIntent().getExtras();
         String nome = dados.getString("nomeTorneio");
         int qtdTimes = dados.getInt("qtdTorneio");

        //configurando valores
        nomeTor.setText(nome);
    }
}
