package com.example.appapoyo;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class registro_usuarios extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, paraleloEditText,userName, gestion;


    private RadioGroup userTypeRadioGroup;
    private RadioButton estudiante_boton,profesor_boton;
    private Button registerButton;
    
    FirebaseAuth fireabaseCrearUsauario= FirebaseAuth.getInstance();

    FirebaseFirestore firebase_regitro_usuario = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        userName= findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        paraleloEditText = findViewById(R.id.paralelo);
        estudiante_boton = findViewById(R.id.estudiante_boton);
        profesor_boton = findViewById(R.id.profesor_boton);
        gestion = findViewById(R.id.gestion);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(registro_usuarios.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                // Aquí puedes obtener los valores ingresados por el usuario y el tipo de usuario seleccionado.
                String firstName = firstNameEditText.getText().toString().trim();
                String lastName = lastNameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String nombreUsuario= userName.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String paralelo = paraleloEditText.getText().toString().trim();
                String gestionStr = gestion.getText().toString().trim();


                int gestion1 = 0;  // Valor por defecto en caso de error


                try {
                    gestion1 = Integer.parseInt(gestionStr);
                    if (gestion1 < 2022 || gestion1 > 2030) {
                        Toast.makeText(getApplicationContext(), "El valor de gestión no está dentro del rango permitido", Toast.LENGTH_SHORT).show();

                        // Puedes agregar más lógica aquí, como limpiar el campo de entrada o realizar otras acciones.
                    }
                } catch (NumberFormatException e) {

                    // Maneja la excepción si el valor ingresado no es un entero válido.
                }


//                Map<String, Object> usuarios = new HashMap<>();
//                usuarios.put("firstName", firstName);
//                usuarios.put("lastName", lastName);
//                usuarios.put("email", email);
//                usuarios.put("nombre_usuario", nombreUsuario);
//                usuarios.put("password", password);
//                usuarios.put("paralelo", paralelo);
//                usuarios.put("gestionStr", gestionStr);
//                firebase_regitro_usuario.collection("usuarios")
//                        .add(usuarios)
//                        .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w(TAG, "Error adding document", e);
//                            }
//                        });





            }

        });

    }
}