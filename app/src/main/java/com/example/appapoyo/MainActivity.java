package com.example.appapoyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton, createAccountButton;

    // Supongamos que estas son las credenciales válidas
    private static final String VALID_USERNAME = "usuario";
    private static final String VALID_PASSWORD = "contrasena";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtén los valores ingresados por el usuario
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                // Verifica si las credenciales son válidas
                if (enteredUsername.equals(VALID_USERNAME) && enteredPassword.equals(VALID_PASSWORD)) {
                    // Las credenciales son válidas, redirige a la siguiente actividad
                    // Intent intent = new Intent(LoginActivity.this, NextActivity.class);
                    //startActivity(intent);
                } else {
                    // Las credenciales son inválidas, muestra un mensaje de error
                    Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquí puedes implementar la lógica para crear una nueva cuenta.
            }
        });
    }
}