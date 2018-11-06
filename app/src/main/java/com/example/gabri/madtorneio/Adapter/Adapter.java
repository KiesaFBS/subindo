package com.example.gabri.madtorneio.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import com.example.gabri.madtorneio.Activity.ganhou;
import com.example.gabri.madtorneio.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>  {
    private ArrayList<String> lista;
    private int qtd;
    private int cont = 0;

    private Activity context;

    private Map<Integer, MyViewHolder> holders;

    public Adapter(ArrayList<String> times) {
        this.lista = times;
        this.qtd = (lista.size())/2;
        this.holders = new HashMap<>();

    }

    public void updatePontos(int pos, int pt1, int pt2) {
        MyViewHolder holder = holders.get(pos);
        holder.placarTime1.setText(String.valueOf(pt1));
        holder.placarTime2.setText(String.valueOf(pt2));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemView) {
        View lista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.duelo,viewGroup,false);
        context = (Activity) lista.getContext();
        return new MyViewHolder(lista);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        holders.put(i, myViewHolder);
        int cont1;
        if(i == 0){
            cont = i;
            cont1 = i +1;
        }else{

            cont = cont + 2;
            cont1 = cont + 1;
        }
        myViewHolder.nomeTime1.setText(lista.get(cont));
        myViewHolder.nomeTime2.setText(lista.get(cont1));
        myViewHolder.placarTime1.setText("0");
        myViewHolder.placarTime2.setText("0");
        myViewHolder.botaoDuelo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Adapter.this.context, ganhou.class);
//            context.startActivity(intent);
             intent.putExtra("pos_elemento", i);
             intent.putExtra("time1", myViewHolder.nomeTime1.getText());
             intent.putExtra("time2", myViewHolder.nomeTime2.getText());
             context.startActivityForResult(intent, 1);
        }
        });

    }

    @Override
    public int getItemCount() {
        return qtd;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nomeTime1;
        TextView nomeTime2;
        TextView placarTime1;
        TextView placarTime2;
        FloatingActionButton botaoDuelo;
        //View horizontal;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeTime1 = itemView.findViewById(R.id.Time1);
            nomeTime2 = itemView.findViewById(R.id.Time2);
            placarTime1 = itemView.findViewById(R.id.placar1);
            placarTime2 = itemView.findViewById(R.id.placar2);
            botaoDuelo = itemView.findViewById(R.id.btAdicionar);
        }
    }

    ;

}

