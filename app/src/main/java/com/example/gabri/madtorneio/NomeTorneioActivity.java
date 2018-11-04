package com.example.gabri.madtorneio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NomeTorneioActivity extends AppCompatActivity {
    private LinearLayout layout;
    private TextView nomeTor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_torneio);

        nomeTor = findViewById(R.id.nomeTorneio);
        layout = findViewById(R.id.layout);
        //recuperando os dados enviados usando o bundle

         Bundle dados = getIntent().getExtras();
         String nome = dados.getString("nomeTorneio");
         int qtdTimes = dados.getInt("qtdTorneio");
         List<String> equipes = new ArrayList<>();

         for(int i =0; i <= qtdTimes ; i++){
             layout.addView(new EditText(getApplicationContext()));
         }
        //configurando valores
        nomeTor.setText(nome);
    }
}
