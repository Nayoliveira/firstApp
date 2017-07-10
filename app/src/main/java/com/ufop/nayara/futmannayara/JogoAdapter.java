package com.ufop.nayara.futmannayara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nayara on 09/07/17.
 */

public class JogoAdapter extends BaseAdapter {
    private Context context;
    private List<Jogo> list;

    public JogoAdapter(Context context, List<Jogo> list) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        Jogo jogo = list.get(position);
        return jogo;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Jogo jogo = list.get(position);

        //Creates a View object from the given XML layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_jogo_list, null);

        TextView textNome = (TextView) v.findViewById(R.id.textView14);
        textNome.setText(jogo.nome);

        TextView textdata = (TextView) v.findViewById(R.id.textView15);
        textdata.setText(jogo.data);
        return v;
    }
}
