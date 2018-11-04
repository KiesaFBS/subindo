package com.example.gabri.madtorneio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScrollActivity extends AppCompatActivity {
    private LinearLayout layout;
    private TextView nome1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        layout = findViewById(R.id.layout);
        nome1 = findViewById(R.id.nome1);

        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nomeTorneio");
        int qtdTimes = dados.getInt("qtdTorneio");
        List<String> equipes = new ArrayList<>();
        nome1.setText(nome);
        for(int i =0; i < qtdTimes ; i++){
            layout.addView(new EditText(getApplicationContext()));
            if (i == qtdTimes - 1){
                Button btn = new Button(getApplicationContext());
            }
        }
    }
}
