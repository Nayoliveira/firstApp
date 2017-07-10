package com.ufop.nayara.futmannayara;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JogadorEdit extends AppCompatActivity {
    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent it = getIntent();
        Bundle params = it.getExtras();

        loadPlayers();

        position = (int) params.get("position");
        setContentView(R.layout.activity_jogador_edit);

        EditText et1 = (EditText) findViewById(R.id.editText8);
        et1.setText("" + jogadores.get(position).nome);

        EditText et2 = (EditText) findViewById(R.id.editText9);
        et2.setText(jogadores.get(position).telefone);

        EditText et3 = (EditText) findViewById(R.id.editText10);
        et3.setText(jogadores.get(position).posicao);

    }

    public void confirm(View view) {
        TextView tv1 = (TextView) findViewById(R.id.editText8);
        String nome = tv1.getText().toString();

        TextView tv2 = (TextView) findViewById(R.id.editText9);
        String telefone = tv2.getText().toString();

        TextView tv3 = (TextView) findViewById(R.id.editText10);
        String posicao = tv3.getText().toString();

        Jogador jogador = new Jogador(nome, telefone, posicao);
        jogadores.set(position, jogador);
        savePlayers();
        finish();
    }


    public void delete(View view) {
        Toast.makeText(this, "Jogador " + jogadores.get(position).nome + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        jogadores.remove(position);
        savePlayers();

        finish();
    }


    public void loadPlayers() {
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

