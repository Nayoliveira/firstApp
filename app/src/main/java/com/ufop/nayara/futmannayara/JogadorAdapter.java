package com.ufop.nayara.futmannayara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nayara on 26/06/17.
 */

public class JogadorAdapter extends BaseAdapter{
    private Context context;
    private List<Jogador> lista;

    public JogadorAdapter(Context context, List<Jogador> lista) {
        this.context = context;
        this.lista = lista;
    }

    public int getCount() {
        return lista.size();
    }

    public Object getItem(int position) {
        Jogador jogador = lista.get(position);
        return jogador;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Jogador jogador = lista.get(position);//esta indicando erro nessa linha

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.activity_jogadores_list, null);

        TextView textNome = (TextView) v.findViewById(R.id.textView3);
        textNome.setText("" + jogador.nome);

        TextView textTelefone = (TextView) v.findViewById(R.id.textView4);
        textTelefone.setText(jogador.telefone);

        TextView textPosicao = (TextView) v.findViewById(R.id.textView5);
        textPosicao.setText(jogador.posicao);

        return v;
    }

}
