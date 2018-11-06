package com.example.gabri.madtorneio.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gabri.madtorneio.Adapter.Adapter;
import com.example.gabri.madtorneio.R;

import java.util.ArrayList;

public class dueloTorneiosActivity extends AppCompatActivity {
    private TextView texto;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo_torneios);

       // texto = findViewById(R.id.texto);
        recycler = findViewById(R.id.recycler);

        Bundle dados = getIntent().getExtras();

        ArrayList<String> times = getIntent().getStringArrayListExtra("times");

        int qtd = times.size();

        //Configurando o Adapter
        Adapter adpt = new Adapter(times);



        //Configurando o Recycler
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recycler.setAdapter(adpt);

       // if (!times.isEmpty()) {
        //texto.setText(times.get(0));
       // }else{
       //     texto.setText("lista vazia");
      //  }
    }






}
