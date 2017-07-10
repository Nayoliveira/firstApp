package com.ufop.nayara.futmannayara;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class JogoList extends ListActivity {

    private ArrayList<Jogo> jogos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPeladas();
        setListAdapter(new JogoAdapter(this, jogos));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent it = new Intent(this, JogoEdit.class);
        it.putExtra("position", position);
        startActivity(it);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadPeladas();
        setListAdapter(new JogoAdapter(this, jogos));
    }

    public void loadPeladas() {
        FileInputStream fis;
        try {
            fis = this.openFileInput("p.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            jogos = (ArrayList<Jogo>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sort(View view) {

    }

    public void removePlayer(View view) {

    }

    public void editPelada(View view) {
        Intent it = new Intent(this, JogoEdit.class);
        startActivity(it);
    }
}