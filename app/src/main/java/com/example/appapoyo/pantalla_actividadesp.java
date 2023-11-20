package com.example.appapoyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.appapoyo.sub_actividades.opcion1;


public class pantalla_actividadesp extends AppCompatActivity {

    private ImageButton opcion1, opcion3, opcion4, opcion5, opcion6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_actividadesp);

        ImageView opcion1 = findViewById(R.id.opcion1);

        ImageView opcion3 = findViewById(R.id.opcion3);
        ImageView opcion4 = findViewById(R.id.opcion4);
        ImageView opcion5 = findViewById(R.id.opcion5);
        ImageView opcion6 = findViewById(R.id.opcion6);


        ImageView option1Button = findViewById(R.id.opcion1);
        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent opcion1 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion1.class);
                startActivity(opcion1);
            }
        });

        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent opcion3 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion3.class);
                startActivity(opcion3);
            }
        });
        opcion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent opcion4 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion4.class);
                startActivity(opcion4);
            }
        });
        opcion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent opcion5 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion5.class);
                startActivity(opcion5);
            }
        });
        opcion6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent opcion6 = new Intent(pantalla_actividadesp.this, com.example.appapoyo.sub_actividades.opcion6.class);
                startActivity(opcion6);
            }
        });


    }

}