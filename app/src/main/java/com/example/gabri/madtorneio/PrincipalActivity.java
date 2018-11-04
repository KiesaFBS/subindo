package com.example.gabri.madtorneio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {
    private Button botaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        botaoEnviar = findViewById(R.id.newButton);

        botaoEnviar.setOnClickListener(new View.OnClickListener() { //ao clicar no botao acontece :
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(getApplicationContext(), qtdtimesActivity.class);
                startActivity(intent);
            }
        });
    }

}
