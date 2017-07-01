package com.ufop.nayara.futmannayara;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CadastrarJogador extends AppCompatActivity {

    public ArrayList<Jogador> jogadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_jo_gador);
        loadJogadores();
    }

    public void save(View view){
        TextView tv1 = (TextView) findViewById(R.id.editText2);
        String nome = tv1.getText().toString();

        TextView tv2 = (TextView) findViewById(R.id.editText);
        String tel = tv2.getText().toString();

        TextView tv3 = (TextView) findViewById(R.id.editText7);
        String posicao = tv3.getText().toString();


        Jogador jogador = new Jogador(nome, tel, posicao);
        jogadores.add(jogador);
        savePlayers();

        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv1.requestFocus();

    }

    public void loadJogadores() {
        FileInputStream fis;
        try {
            fis = this.openFileInput("t.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            jogadores = (ArrayList<Jogador>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void savePlayers() {
        FileOutputStream fos;
        try {
            fos = this.openFileOutput("t.tmp", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(jogadores);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
