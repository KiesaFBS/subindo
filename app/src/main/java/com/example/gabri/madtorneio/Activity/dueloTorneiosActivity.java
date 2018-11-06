package com.example.gabri.madtorneio.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
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
    private Adapter adpt;
    private TextView nomeTorneio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo_torneios);

       // texto = findViewById(R.id.texto);
        recycler = findViewById(R.id.recycler);
        nomeTorneio = findViewById(R.id.nomeTorneio);

        Bundle dados = getIntent().getExtras();
        nomeTorneio.setText(dados.getString("nomeTorneio"));

        ArrayList<String> times = getIntent().getStringArrayListExtra("times");

        int qtd = times.size();

        //Configurando o Adapter
        adpt = new Adapter(times);



        //Configurando o Recycler
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recycler.setAdapter(adpt);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1) {
                if (resultCode == RESULT_OK) {
                    int pos_elemento = data.getIntExtra("pos_elemento", 0);
                    int p1 = data.getIntExtra("pontuacao1", 0);
                    int p2 = data.getIntExtra("pontuacao2", 0);

                    adpt.updatePontos(pos_elemento, p1, p2);
                }
            }
    }
}
