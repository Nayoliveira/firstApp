package com.ufop.nayara.futmannayara;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class JogoNew extends AppCompatActivity {

    public ArrayList<Jogo> jogos = new ArrayList<>();
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
//            arg1 = year;
//            arg2 = month;
//            arg3 = day;
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_new);
        loadPeladas();
        dateView = (TextView) findViewById(R.id.textView6);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "ca",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void save(View view) {
        TextView tv1 = (TextView) findViewById(R.id.editText3);
        String nome = tv1.getText().toString();

        TextView tv2 = (TextView) findViewById(R.id.textView6);
        String data = tv2.getText().toString();

        Jogo jogo = new Jogo(nome, data);
        jogos.add(jogo);
        savePeladas();

        tv1.setText("");
        tv2.setText("");
        tv1.requestFocus();
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
