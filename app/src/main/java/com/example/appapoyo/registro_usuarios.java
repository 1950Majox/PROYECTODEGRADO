package com.example.appapoyo;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class registro_usuarios extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, paraleloEditText;
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