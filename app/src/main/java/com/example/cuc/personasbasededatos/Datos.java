package com.example.cuc.personasbasededatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by CUC on 13/05/2017.
 */

public class Datos {

    public static ArrayList<Persona> traerPersonas(Context contexto){
        ArrayList<Persona> personas = new ArrayList<>();

        SQLiteDatabase db;
        String sql, foto,cedula, nombre, apellido, sexo, pasatiempo;
        Persona p;

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null,2);
        db = aux.getReadableDatabase();
        sql = "select * from Personas";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                cedula = c.getString(1);
                nombre = c.getString(2);
                apellido = c.getString(3);
                sexo = c.getString(4);
                pasatiempo = c.getString(5);
                p = new Persona(foto,cedula,nombre,apellido,sexo,pasatiempo);
                personas.add(p);
            }while (c.moveToNext());
        }
        db.close();
        return personas;
    }
}
