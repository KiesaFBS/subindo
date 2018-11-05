package com.example.gabri.madtorneio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class meusTorneiosActivity extends AppCompatActivity {
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_torneios);



        Bundle dados = getIntent().getExtras();

         List < String > elementos = (List<String>) getIntent().getSerializableExtra("nomesTimes");


    }






}
