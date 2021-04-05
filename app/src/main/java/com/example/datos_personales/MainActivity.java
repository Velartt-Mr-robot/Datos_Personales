package com.example.datos_personales;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Define objetos de la clase EditText

    private EditText et0 ;
    private EditText et1 ;
    private EditText et2 ;
    private EditText et3 ;
    private EditText et4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Comunica los objetos de la parte lógica con la parte gráfica a tráves de la clase R

        et0 = findViewById(R.id.txt_Nombre);
        et1 = findViewById(R.id.txt_Feche);
        et2 = findViewById(R.id.txt_Tel);
        et3 = findViewById(R.id.txt_Email);
        et4 = findViewById(R.id.txt_Descr);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et0.setText(preferences.getString("name", ""));
        et1.setText(preferences.getString("fecha", ""));
        et2.setText(preferences.getString("cel", ""));
        et3.setText(preferences.getString("emal", ""));
        et4.setText(preferences.getString("desc", ""));


    }

    //Metodo para registrar datos

    public void Registrar(View view){

        //Preguardar los datos

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_Edit = preferences.edit();
        Obj_Edit.putString("name", et0.getText().toString());
        Obj_Edit.putString("fecha", et1.getText().toString());
        Obj_Edit.putString("cel", et2.getText().toString());
        Obj_Edit.putString("emal", et3.getText().toString());
        Obj_Edit.putString("desc", et4.getText().toString());
        Obj_Edit.commit();


        Intent in = new Intent(MainActivity.this, Confirmar_Datos.class);
        in.putExtra("nombre", et0.getText().toString());
        in.putExtra("fecha", et1.getText().toString());
        in.putExtra("tel", et2.getText().toString());
        in.putExtra("email", et3.getText().toString());
        in.putExtra("descr", et4.getText().toString());
        startActivity(in);


    }

    // Metodo para ver calendario

    public void Calendario(View view) {
        Calendar cal = Calendar.getInstance();
        int año = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int día = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth + "/" + month + "/" + year;
                et1.setText(fecha);
            }
        }, año, mes, día) ;
        dpd.show();
    }
}