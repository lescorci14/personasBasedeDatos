package com.example.cuc.personasbasededatos;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registrar extends AppCompatActivity {
    private EditText cajaCedula, cajaNombre, cajaApellido;
    private RadioButton rdMasculino, rdFemenino;
    private CheckBox chkProgramar, chkLeer, chkBailar;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        cajaCedula = (EditText)findViewById(R.id.txtCedula);
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);

        res = this.getResources();

        rdMasculino = (RadioButton)findViewById(R.id.r1);
        rdFemenino = (RadioButton)findViewById(R.id.r2);

        chkProgramar = (CheckBox)findViewById(R.id.chkProgramar);
        chkLeer = (CheckBox)findViewById(R.id.chkLeer);
        chkBailar = (CheckBox)findViewById(R.id.chkBailar);
    }

    public boolean validarTodo(){
        if(cajaCedula.getText().toString().isEmpty()){
            cajaCedula.setError("Digite la Cédula");
            cajaCedula.requestFocus();
            return false;
        }
        if (cajaNombre.getText().toString().isEmpty()) {
                cajaNombre.setError("Digite el Nombre");
                cajaNombre.requestFocus();
                return false;
        }
        if (cajaApellido.getText().toString().isEmpty()) {
                cajaApellido.setError("Digite el Apellido");
                cajaApellido.requestFocus();
                return false;
        }
        if ((!chkProgramar.isChecked()) && (!chkLeer.isChecked()) && (!chkBailar.isChecked())) {
                new AlertDialog.Builder(this).setMessage("Seleccione por los menos un pasatiempo").setCancelable(true).show();
            return false;
        }

        return true;
    }

    public void guardar(View v){
        String foto,cedula,nombre,apellido,sexo,pasatiempo="";
        Persona p;
        if(validarTodo()){
            cedula = cajaCedula.getText().toString();
            foto = String.valueOf(fotoAleatoria());
            nombre = cajaNombre.getText().toString();
            apellido = cajaApellido.getText().toString();
            if(rdMasculino.isChecked()) sexo = res.getString(R.string.masculino);
            else sexo = res.getString(R.string.femenino);

            if(chkProgramar.isChecked()){
                pasatiempo=res.getString(R.string.programar)+",";
            }
            if(chkLeer.isChecked()){
                pasatiempo=pasatiempo+res.getString(R.string.leer)+",";
            }
            if(chkBailar.isChecked()){
                pasatiempo=pasatiempo+res.getString(R.string.bailar);
            }

            pasatiempo = pasatiempo.substring(pasatiempo.length()-1);

            p = new Persona(foto,cedula,nombre,apellido,sexo,pasatiempo);
            p.guardar(getApplicationContext());

            new AlertDialog.Builder(this).setMessage("Datos Guardados Exitosamente").setCancelable(true).show();
        }
    }

    public int fotoAleatoria(){
        int fotos[] = {R.drawable.images,R.drawable.images2,R.drawable.images3};
        int numero = (int)(Math.random() * 3);
        return fotos[numero];
    }

    public boolean validarCedula(){
        if(cajaCedula.getText().toString().isEmpty()){
            cajaCedula.setError("Digite la Cédula");
            cajaCedula.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(){
        cajaCedula.setText("");
        cajaNombre.setText("");
        cajaApellido.setText("");
        rdMasculino.setChecked(true);
        chkProgramar.setChecked(true);
        chkLeer.setChecked(false);
        chkBailar.setChecked(false);
        cajaCedula.requestFocus();
    }
}
