package com.ufop.nayara.futmannayara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nayara on 26/06/17.
 */

public class JogadorAdapter extends BaseAdapter{
    private Context context;
    private List<Jogador> list;

    public JogadorAdapter(Context context, List<Jogador> list) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        Jogador jogador = list.get(position);
        return jogador;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //Recovers the Student in the current position
        Jogador jogador = list.get(position);

        //Creates a View object from the given XML layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_jogadores_list, null);

        //Updates TextView’s text to the Student’s info
        TextView textNome = (TextView) v.findViewById(R.id.textView3);
        textNome.setText("" + jogador.nome);

        TextView textTelefone = (TextView) v.findViewById(R.id.textView4);
        textTelefone.setText(jogador.telefone);

        TextView textPosicao = (TextView) v.findViewById(R.id.textView5);
        textPosicao.setText(jogador.posicao);



        //Sets image of ImageView to the correct Student type 
//        ImageView img = (ImageView) v.findViewById(R.id.imageView);
//        img.setImageResource(jogador.getImage());
        return v;
    }

}
