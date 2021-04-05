package com.example.datos_personales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmar_Datos extends AppCompatActivity {


    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private TextView tv_5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar__datos);

        tv_1 = findViewById(R.id.conf_nombre);
        tv_2 = findViewById(R.id.conf_fecha);
        tv_3 = findViewById(R.id.conf_tel);
        tv_4 = findViewById(R.id.conf_email);
        tv_5 = findViewById(R.id.conf_descr);

        String nombre = getIntent().getStringExtra( "nombre");
        tv_1.setText(nombre);
        String fecha = getIntent().getStringExtra( "fecha");
        tv_2.setText("Fecha de Nacimiento: " + fecha);
        String tel = getIntent().getStringExtra( "tel");
        tv_3.setText("Tel: " + tel);
        String email = getIntent().getStringExtra( "email");
        tv_4.setText("Email: " + email);
        String descr = getIntent().getStringExtra( "descr");
        tv_5.setText("Descripción: " + descr);

        finishActivity();
    }

    private void finishActivity() {
    }

    //  Método para el boton regresar

    public void Editar(View view) {
        Intent in_2 = new Intent(Confirmar_Datos.this, MainActivity.class);
        startActivity(in_2);

    }

}