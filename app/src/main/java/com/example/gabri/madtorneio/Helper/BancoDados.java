package com.example.gabri.madtorneio.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BancoDados extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public  static String name_bd = "BD_Times";
    public  static  String Tabela_tarefas = "NomeTimes";
    public BancoDados(Context context) {
        super(context, name_bd, null, VERSION);
    }

    //criar a primeira vez o banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE NOT EXISTS " + Tabela_tarefas
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " nomTime TEXT NOT NULL);";
        //criando mais tabelas sql +=

        try {
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela");
        }catch (Exception e){
            //mensagem de erro
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }
    }

    //criar mais tabelas, quando já tem o app instalado e tá atualizando o app
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
