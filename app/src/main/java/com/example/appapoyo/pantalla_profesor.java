package com.example.appapoyo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class pantalla_profesor extends AppCompatActivity {


    private Button agregarPreguntas;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_profesor);

        agregarPreguntas = findViewById(R.id.agregarPreguntasBtn);

        agregarPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarPreguntas();
            }
        });
    }

    private void agregarPreguntas() {
        // Aquí puedes llamar a la lógica de agregar preguntas
        agregarPregunta("¿Cuándo una persona comunica a través de las manos, que tipo de comunicación es?", Arrays.asList("gestos", "jestos", "mover las manos "), "gestos", 6);
        agregarPregunta("¿Cuando alguien sonríe? ¿cómo se llama el tipo de comunicación no verbal?", Arrays.asList("comunicación de gestual", "comunicación con la cara", "comunicasion de gestos ", "comunicación de jestos "), "comunicación de gestual", 7);
        agregarPregunta("¿Cuantos tipos de cmunicación existe?", Arrays.asList("1", "2", "3", "4"), "2", 8);
        agregarPregunta("¿Cuándo vemos imágenes con dibujos, que tipos de comunicación es?", Arrays.asList("comunicación escrita", "comunicación verbal", "comunicación no verbal"), "comunicación no verbal", 9);
    }

    private void agregarPregunta(String textoPregunta, List<String> opcionesRespuesta, String respuestaCorrecta, int numeroPregunta) {
        Map<String, Object> preguntas = new HashMap<>();
        preguntas.put("textoPregunta", textoPregunta);
        preguntas.put("opcionesRespuesta", opcionesRespuesta);
        preguntas.put("respuestaCorrecta", respuestaCorrecta);
        preguntas.put("actividad", "comunicacion");
        preguntas.put("pregunta",numeroPregunta);// Ajusta la actividad según sea necesario.

        FirebaseFirestore.getInstance().collection("preguntas").add(preguntas)
                .addOnSuccessListener(documentReference -> {
                    // Aquí puedes manejar el éxito, como mostrar un mensaje al usuario.
                })
                .addOnFailureListener(e -> {
                    // Aquí puedes manejar el fallo, como mostrar un mensaje de error al usuario.
                });
    }
}