package com.example.gabri.madtorneio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class testeActivity extends AppCompatActivity {

    private TableLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        layout = findViewById(R.id.layout);

        for(int i = 1; i < 12; i++){
            layout.addView(new TableRow(getApplicationContext()),i);
        }
    }


}
