package com.df.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.df.listviewexample.models.Carro;

import java.util.ArrayList;

public class FormularioCarros extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNombre;
    private EditText txtModelo;
    private EditText txtCilindraje;
    private EditText txtValor;
    private EditText txtUrl;
    private Button btnAgregar;
    private Button btnListar;
    private ArrayList<Carro> listaCarros = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carros);
        txtNombre = findViewById(R.id.txtNombre);
        txtModelo = findViewById(R.id.txtModelo);
        txtCilindraje = findViewById(R.id.txtCilindraje);
        txtValor = findViewById(R.id.txtValor);
        txtUrl = findViewById(R.id.txtUrl);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnListar = findViewById(R.id.btnListar);

        btnAgregar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar) {
            agregarCarro();
            limpiarCampos();
        } else if (v.getId() == R.id.btnListar) {
            Intent myIntent = new Intent(this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("listaCarros", listaCarros);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        }
    }

    private void agregarCarro(){
        String nombre = String.valueOf(txtNombre.getText());
        String modelo = String.valueOf(txtModelo.getText());
        String cilindraje = String.valueOf(txtCilindraje.getText());
        String valor = String.valueOf(txtValor.getText());
        String url = String.valueOf(txtUrl.getText());

        Carro carro = new Carro(nombre, modelo, cilindraje, valor, url);
        listaCarros.add(carro);
    }

    private void limpiarCampos(){
        txtNombre.setText("");
        txtModelo.setText("");
        txtCilindraje.setText("");
        txtValor.setText("");
        txtUrl.setText("");
    }
}