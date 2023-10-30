package com.example.appapoyo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
                // Aquí puedes obtener los valores ingresados por el usuario y el tipo de usuario seleccionado.
                String firstName = firstNameEditText.getText().toString().trim();
                String lastName = lastNameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String nombre_usuario= userName.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String paralelo = paraleloEditText.getText().toString().trim();
                String gestionStr = gestion.getText().toString().trim();



                fireabaseCrearUsauario.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(registro_usuarios.this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                                    Intent exito= new Intent(registro_usuarios.this,MainActivity.class);
                                    startActivity(exito);
                                    finish();
                                }
                                else{
                                    Toast.makeText(registro_usuarios.this,"Error al registrar usuario",Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }

        });

    }
}