package com.ufop.nayara.futmannayara;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PeladaEdit extends AppCompatActivity {
//    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
//    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent it = getIntent();
//        Bundle params = it.getExtras();
//
//        loadPlayers();
//
//        position = (int) params.get("position");
        setContentView(R.layout.activity_pelada_edit);
//        //Fill fields with student's data
//        EditText et1 = (EditText) findViewById(R.id.editText5);
//        et1.setText("" + jogadores.get(position).nome);
//        EditText et2 = (EditText) findViewById(R.id.editText6);
//        et2.setText(jogadores.get(position).nome);

    }

//    public void save(View view) {
//
//        TextView tv2 = (TextView) findViewById(R.id.editText5);
//        String nome = tv2.getText().toString();
//
//        TextView tv1 = (TextView) findViewById(R.id.editText6);
//        String tel = tv1.getText().toString();
//
//
//
//        Jogador student = new Jogador(nome, tel, posicao);
//        jogadores.set(position, student);
//        Toast.makeText(this, "Student mat. " + nome + " edited successfully!", Toast.LENGTH_SHORT).show();
//
//        loadPlayers();
//
//        finish();
//    }
//
//
//    public void loadPlayers() {
//        FileInputStream fis;
//        try {
//            fis = this.openFileInput("t.tmp");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            jogadores = (ArrayList<Jogador>) ois.readObject();
//            ois.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void goBack(){
//        Toast.makeText(this, "Student mat. " + jogadores.get(position).nome + " removed successfully!", Toast.LENGTH_SHORT).show();
//        jogadores.remove(position);
//        savePlayers();
//        finish();
//    }
//
//
//    public void savePlayers(){
//        FileOutputStream fos;
//        try {
//            fos = this.openFileOutput("t.tmp", Context.MODE_PRIVATE);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(jogadores);
//            oos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
