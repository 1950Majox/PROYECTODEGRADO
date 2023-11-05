package com.example.appapoyo;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public class registro_usuarios extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, paraleloEditText, gestion;


    private RadioGroup userTypeRadioGroup;
   // private RadioButton estudiante_boton,profesor_boton;
    private Button registerButton;
    
    FirebaseAuth fireabaseCrearUsauario= FirebaseAuth.getInstance();

    FirebaseFirestore firebase_regitro_usuario = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        paraleloEditText = findViewById(R.id.paralelo);

        gestion = findViewById(R.id.gestion);
        registerButton = findViewById(R.id.registerButton);



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Aquí puedes obtener los valores ingresados por el usuario y el tipo de usuario seleccionado.
                String firstName = firstNameEditText.getText().toString().trim();
                String lastName = lastNameEditText.getText().toString().trim();

                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String paralelo = paraleloEditText.getText().toString().trim();

                String nombreUsuario = generateUsername(firstName, lastName, paralelo);



                userTypeRadioGroup=findViewById(R.id.userTypeRadioGroup);
                int selectedId=userTypeRadioGroup.getCheckedRadioButtonId();
                String userType="";
                if (selectedId== R.id.estudiante_boton){
                    userType= "Estudiante";
                } else if (selectedId == R.id.profesor_boton){
                    userType= "Profesor";
                }
                String gestion_curso = gestion.getText().toString().trim();
                int gestion1 = 0;  // Valor por defecto en caso de error
                try {
                    gestion1 = Integer.parseInt(gestion_curso);
                    if (gestion1 < 2022 || gestion1 > 2030) {
                        Toast.makeText(getApplicationContext(), "El valor de gestión no está dentro del rango permitido", Toast.LENGTH_SHORT).show();
                        // Puedes agregar más lógica aquí, como limpiar el campo de entrada o realizar otras acciones.
                    }
                } catch (NumberFormatException e) {
                    // Maneja la excepción si el valor ingresado no es un entero válido.
                }
                /////////////////////////////////////////////////////// Realiza validaciones
                if (firstName.isEmpty() || lastName.isEmpty() ||
                        email.isEmpty() || password.isEmpty() || paralelo.isEmpty()||  selectedId == -1) {
                    // Muestra un mensaje de error si algún campo está vacío
                    Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    // Verifica si el correo electrónico es válido
                    Toast.makeText(getApplicationContext(), "El correo electrónico no es válido", Toast.LENGTH_SHORT).show();
                }

                ///////////////////////////////////////////////////////
                Map<String, Object> usuarios = new HashMap<>();
                usuarios.put("firstName", firstName);
                usuarios.put("lastName", lastName);
                usuarios.put("email", email);
                usuarios.put("password", password);
                usuarios.put("paralelo", paralelo);
                usuarios.put("nombre_usuario", nombreUsuario);
                usuarios.put("tipo_usuario", userType);
                usuarios.put("gestionStr", gestion_curso);
                firebase_regitro_usuario.collection("usuarios")
                        .add(usuarios)
                        .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
                ////////////////////////////////////////////////////////

                //////////////////////////////////////////////////////////////
            }
            /////////////////////////////////////////////
            private String generateUsername(String nombres, String apellidos, String paralelo) {
                // Genera un nombre de usuario único a partir de los datos
                // Por ejemplo, puedes combinar las iniciales de los nombres y apellidos con el paralelo.
                String nombreUsuario = nombres.substring(0,1)+ apellidos.substring(0, 1) + paralelo;
                return nombreUsuario;

            }
            //////////////////////////////////////////////

            ///////////////////////////////////////////////////


            private boolean isValidEmail(String email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
            ///////////////////////////////////////////////


        });



    }
}