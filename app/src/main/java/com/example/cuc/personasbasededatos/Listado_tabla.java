package com.example.cuc.personasbasededatos;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;

public class Listado_tabla extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Persona> personas;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_tabla);
        tabla = (TableLayout)findViewById(R.id.tblPersonas);
        res =this.getResources();

        personas=Datos.traerPersonas(getApplicationContext());
    }
}
