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

public class JogoEdit extends AppCompatActivity {
    private ArrayList<Jogo> jogos = new ArrayList<Jogo>();
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent it = getIntent();
        Bundle params = it.getExtras();

        loadPeladas();

        position = (int) params.get("position");
        setContentView(R.layout.activity_jogo_edit);
        //Fill fields with student's data
        EditText et1 = (EditText) findViewById(R.id.editText5);
        et1.setText("" + jogos.get(position).nome);
        EditText et2 = (EditText) findViewById(R.id.editText6);
        et2.setText(jogos.get(position).data);

    }

    public void save(View view) {

        TextView tv2 = (TextView) findViewById(R.id.editText8);
        String nome = tv2.getText().toString();

        TextView tv1 = (TextView) findViewById(R.id.editText9);
        String data = tv1.getText().toString();

        Jogo jogo = new Jogo(nome, data);
        jogos.set(position, jogo);
        Toast.makeText(this, "Student mat. " + nome + " edited successfully!", Toast.LENGTH_SHORT).show();

        loadPeladas();

        finish();
    }

    public void loadPeladas() {
        FileInputStream fis;
        try {
            fis = this.openFileInput("t.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            jogos = (ArrayList<Jogo>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void goBack() {
        Toast.makeText(this, "Jogo " + jogos.get(position).nome + " removida com sucesso!", Toast.LENGTH_SHORT).show();
        jogos.remove(position);
        savePeladas();
        finish();
    }

    private void savePeladas() {
        FileOutputStream fos;
        try {
            fos = this.openFileOutput("t.tmp", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(jogos);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
