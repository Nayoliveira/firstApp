package com.ufop.nayara.futmannayara;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class JogadoresList extends ListActivity {
    private ArrayList<Jogador>jogadores = new ArrayList<Jogador>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPlayers();
        setListAdapter(new JogadorAdapter(this, jogadores));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Jogador jogador = (Jogador) this.getListAdapter().getItem(position);
        Toast.makeText(this, "Player selected: " + jogador.nome, Toast.LENGTH_SHORT).show();

        Intent it = new Intent(this, JogadorCall.class);
        it.putExtra("position", position);
        startActivity(it);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadPlayers();
        setListAdapter(new JogadorAdapter(this, jogadores));
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
}