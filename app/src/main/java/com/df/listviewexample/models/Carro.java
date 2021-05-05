package com.df.listviewexample.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Carro implements Parcelable {
    private String nombre;
    private String modelo;
    private String cilindraje;
    private String valor;
    private String imagen;

    public Carro(String nombre, String modelo, String cilindraje, String valor, String imagen) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.valor = valor;
        this.imagen = imagen;
    }

    protected Carro(Parcel in) {
        nombre = in.readString();
        modelo = in.readString();
        cilindraje = in.readString();
        valor = in.readString();
        imagen = in.readString();
    }

    public static final Creator<Carro> CREATOR = new Creator<Carro>() {
        @Override
        public Carro createFromParcel(Parcel in) {
            return new Carro(in);
        }

        @Override
        public Carro[] newArray(int size) {
            return new Carro[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(modelo);
        dest.writeString(cilindraje);
        dest.writeString(valor);
        dest.writeString(imagen);
    }
}
