package com.example.appapoyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appapoyo.sub_actividades.opcion1;
import com.example.appapoyo.sub_actividades.opcion2;
import com.example.appapoyo.sub_actividades.opcion3;
import com.example.appapoyo.sub_actividades.opcion4;
import com.example.appapoyo.sub_actividades.opcion5;
import com.example.appapoyo.sub_actividades.opcion6;
import com.example.appapoyo.sub_actividades.opcion7;
import com.example.appapoyo.sub_actividades.opcion8;


public class pantalla_actividadesp extends AppCompatActivity {
    private Button option1Button,option2Button, option3Button, option4Button,
            option5Button, option6Button, option7Button, option8Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_actividadesp);

        // Recuperar elementos de la interfaz de usuario
        Button option1Button = findViewById(R.id.option1Button);
        Button option2Button = findViewById(R.id.option2Button);
        Button option3Button = findViewById(R.id.option3Button);
        Button option4Button = findViewById(R.id.option4Button);
        Button option5Button = findViewById(R.id.option5Button);
        Button option6Button = findViewById(R.id.option6Button);
        Button option7Button = findViewById(R.id.option7Button);
        Button option8Button = findViewById(R.id.option8Button);
        // ... Repite esto para las otras opciones

        // Configurar OnClickListener para cada botón
        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad secundaria correspondiente (cambia a la actividad que desees)
                Intent opcion1 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion1.class);
                startActivity(opcion1);
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad secundaria correspondiente (cambia a la actividad que desees)
                Intent opcion2 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion2.class);
                startActivity(opcion2);
            }
        });
        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad secundaria correspondiente (cambia a la actividad que desees)
                Intent opcion3 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion3.class);
                startActivity(opcion3);
            }
        });

        option4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad secundaria correspondiente (cambia a la actividad que desees)
                Intent opcion4 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion4.class);
                startActivity(opcion4);
            }
        });
        option5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad secundaria correspondiente (cambia a la actividad que desees)
                Intent opcion5 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion5.class);
                startActivity(opcion5);
            }
        });

        option6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad secundaria correspondiente (cambia a la actividad que desees)
                Intent opcion6 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion6.class);
                startActivity(opcion6);
            }
        });
        option7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad secundaria correspondiente (cambia a la actividad que desees)
                Intent opcion7 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion7.class);
                startActivity(opcion7);
            }
        });

        option8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad secundaria correspondiente (cambia a la actividad que desees)
                Intent opcion8 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion8.class);
                startActivity(opcion8);
            }
        });
        // ... Repite esto para las otras opciones
    }
}