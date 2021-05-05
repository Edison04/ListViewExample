package com.df.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.df.listviewexample.models.Carro;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCar extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Carro> carros;

    public AdapterCar(Activity activity, ArrayList<Carro> carros) {
        this.activity = activity;
        this.carros = carros;
    }
    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View objView = convertView;
        if (convertView == null){
            LayoutInflater objeInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            objView = objeInflater.inflate(R.layout.car_item, null);
        }
        Carro objCarro = carros.get(position);
        TextView nombreCarro = objView.findViewById(R.id.tvNombre);
        TextView cilindrajeCarro = objView.findViewById(R.id.tvCilindraje);
        TextView modeloCarro = objView.findViewById(R.id.tvModelo);
        TextView valorCarro = objView.findViewById(R.id.tvValor);
        ImageView imgCarro = objView.findViewById(R.id.imgCarro);

        nombreCarro.setText(objCarro.getNombre());
        cilindrajeCarro.setText(objCarro.getCilindraje());
        modeloCarro.setText(objCarro.getModelo());
        valorCarro.setText(objCarro.getValor());
        Picasso.get()
                .load(objCarro.getImagen())
                .resize(100,100)
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(imgCarro);

        return objView;
    }
}
