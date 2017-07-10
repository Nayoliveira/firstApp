package com.ufop.nayara.futmannayara;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Jogo implements Parcelable, Serializable {

    public String nome;
    public String data;

    public Jogo(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

    protected Jogo(Parcel in) {
        nome = in.readString();
        data = in.readString();
    }

    protected Jogo(Parcel in) {
        nome = in.readString();
        data = in.readString();
    }

    public static final Creator<Jogo> CREATOR = new Creator<Jogo>() {
        @Override
        public Jogo createFromParcel(Parcel in) {
            return new Jogo(in.readString(), in.readString());
        }

        @Override
        public Jogo[] newArray(int size) {
            return new Jogo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(data);
    }
}
