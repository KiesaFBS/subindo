package com.example.gabri.madtorneio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class dueloTorneiosActivity extends AppCompatActivity {
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo_torneios);

       // texto = findViewById(R.id.texto);

        Bundle dados = getIntent().getExtras();

        ArrayList<String> times = getIntent().getStringArrayListExtra("times");

        int qtd = times.size();


       // if (!times.isEmpty()) {
        //texto.setText(times.get(0));
       // }else{
       //     texto.setText("lista vazia");
      //  }
    }






}
