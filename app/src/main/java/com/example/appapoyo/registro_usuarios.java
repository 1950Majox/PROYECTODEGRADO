package com.example.appapoyo;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class registro_usuarios extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, paraleloEditText, gestion;


    private RadioGroup userTypeRadioGroup;
    private RadioButton estudiante_boton,profesor_boton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);

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
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String paralelo = paraleloEditText.getText().toString();
                String gestionStr = gestion.getText().toString();
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

                int selectedUserTypeId = userTypeRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedUserType = findViewById(selectedUserTypeId);

                if (selectedUserType != null) {
                    String userType = selectedUserType.getText().toString();
                    // Aquí puedes realizar la lógica de registro con los datos ingresados.
                }

            }
        });






    }
}