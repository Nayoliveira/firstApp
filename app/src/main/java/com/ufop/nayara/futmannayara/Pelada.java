package com.ufop.nayara.futmannayara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pelada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelada);
    }
    public void viewPelada(View view){

    }
    public void novaPelada(View view){
        Intent it = new Intent(this, PeladaNew.class);
        startActivity(it);
    }
    public void sort(View view){

    }
    public void removePlayer(View view){

    }
    public void editPelada(View view){
        Intent it = new Intent(this, PeladaEdit.class);
        startActivity(it);
    }
}
