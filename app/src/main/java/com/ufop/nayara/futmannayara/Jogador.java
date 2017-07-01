package com.ufop.nayara.futmannayara;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by nayara on 26/06/17.
 */

public class Jogador implements Parcelable, Serializable{
    public String nome;
    public String telefone;
    public String posicao;


    public Jogador(String nome, String telefone, String posicao){
        this.nome = nome;
        this.telefone = telefone;
        this.posicao = posicao;
    }

    public int getImage(){
        return 0;
    }
    public static final Creator<Jogador> CREATOR = new Creator<Jogador>() {
        @Override
        public Jogador createFromParcel(Parcel in) {
            return new Jogador(in.readString(), in.readString(), in.readString());
        }

        @Override
        public Jogador[] newArray(int size) {
            return new Jogador[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(telefone);

    }
}
