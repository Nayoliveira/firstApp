package com.ufop.nayara.futmannayara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrar(View view){
        Intent it = new Intent(this, CadastrarJogador.class);
        startActivity(it);
    }

    public void pelada(View view){
        Intent it = new Intent(this, Pelada.class);
        startActivity(it);

    }
    public void ver(View view){
        Intent it = new Intent(this, JogadoresList.class);
        startActivity(it);

    }
}
