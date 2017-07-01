package com.ufop.nayara.futmannayara;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by nayara on 26/06/17.
 */

public class JogadorCall  extends ListActivity{
    private static final int ACTIVITY_EDIT = 1;
    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        loadJogadores();
        setListAdapter(new JogadorAdapter(this, jogadores));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Jogador jogador = (Jogador) this.getListAdapter().getItem(position);
        Toast.makeText(this, "Student selected: " + jogador.nome, Toast.LENGTH_SHORT).show();

        //Call StudentEdit activity passing info about the selected student
        Uri uri = Uri.parse("tel" + jogador.telefone);

        Intent it = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(it);
        }
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
}
