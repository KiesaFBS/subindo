package com.example.gabri.madtorneio.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gabri.madtorneio.R;

public class a1PrincipalActivity extends AppCompatActivity {
    private Button botaoEnviar;
    private Button meuBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        botaoEnviar = findViewById(R.id.newButton);
        meuBotao = findViewById(R.id.meuBotao);

        botaoEnviar.setOnClickListener(new View.OnClickListener() { //ao clicar no botao acontece :
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(getApplicationContext(), a2QtdtimesActivity.class);
                startActivity(intent);
            }
        });

        meuBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), testeActivity.class);

                startActivity(intent);
            }
        });
    }

}
