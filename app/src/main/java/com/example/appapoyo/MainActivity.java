package com.example.appapoyo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton, createAccountButton;



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
                String nombre_usuario = usernameEditText.getText().toString().trim();
                String password_usuario = passwordEditText.getText().toString().trim();




                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");
                Query query = databaseReference.orderByChild("nombre_usuario").equalTo(nombre_usuario);

                // Realiza la validación de los campos (puedes agregar más validaciones aquí).
                if (nombre_usuario.isEmpty() || password_usuario.isEmpty()) {
                    // Muestra un mensaje de error si algún campo está vacío.
                    Toast.makeText(MainActivity.this, "Debes completar todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Los campos están completos, puedes proceder con la validación de las credenciales.

                    // Realiza una consulta a Firebase Firestore para verificar si el nombre de usuario y la contraseña son correctos.
                    // Puedes consultar la colección de usuarios y buscar el documento que coincida con el nombre de usuario.
                    // Verifica si la contraseña almacenada en ese documento coincide con la contraseña ingresada.

                    // Ejemplo (ten en cuenta que debes adaptar esto a tu estructura de datos en Firestore):
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    CollectionReference usuariosRef = db.collection("usuarios");

                    usuariosRef
                            .whereEqualTo("nombre_usuario", nombre_usuario)
                            .whereEqualTo("password", password_usuario)
                            .get()
                            .addOnSuccessListener(queryDocumentSnapshots -> {
                                if (!queryDocumentSnapshots.isEmpty()) {
                                    // Se encontró un usuario con el nombre de usuario ingresado.
                                    // Ahora, obtén el tipo de usuario de ese usuario.
                                    // Esto se supone que el campo de tipoUsuario existe en tu documento de usuario.
                                    // Reemplaza "tipoUsuario" por el nombre real del campo en tu base de datos.
                                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                                        String tipoUsuario = document.getString("tipo_usuario");
                                        if (tipoUsuario != null) {
                                            // Verifica el tipo de usuario y redirige a la pantalla correspondiente.
                                            if (tipoUsuario.equals("Estudiante")) {
                                                // Redirige a la pantalla de Estudiante.
                                                Intent intentEstudiante = new Intent(MainActivity.this, pantalla_actividadesp.class);
                                                startActivity(intentEstudiante);
                                                finish();
                                                Toast.makeText(MainActivity.this, "Bienvenido Estudiante: "+ nombre_usuario, Toast.LENGTH_SHORT).show();
                                            } else if (tipoUsuario.equals("Profesor")) {
                                                // Redirige a la pantalla de Profesor.
                                                Intent intentProfesor = new Intent(MainActivity.this, pantalla_profesor.class);
                                                startActivity(intentProfesor);
                                                finish();
                                                Toast.makeText(MainActivity.this, "Bienvenido Profesor: "+nombre_usuario, Toast.LENGTH_SHORT).show();
                                            } else {
                                                // Tipo de usuario desconocido. Maneja la situación de acuerdo a tus necesidades.
                                                Toast.makeText(MainActivity.this, "Tipo de usuario desconocido", Toast.LENGTH_SHORT).show();
                                            }
                                        } else {
                                            // El campo "tipoUsuario" está vacío en el documento de usuario.
                                            Toast.makeText(MainActivity.this, "Tipo de usuario no especificado", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } else {
                                    // No se encontró un usuario con el nombre de usuario ingresado.
                                    // Muestra un mensaje de error.
                                    Toast.makeText(MainActivity.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(e -> {
                                // Maneja cualquier error que pueda ocurrir durante la consulta.
                                Toast.makeText(MainActivity.this, "Error al verificar las credenciales", Toast.LENGTH_SHORT).show();
                            });



                }
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Aquí puedes implementar la lógica para crear una nueva cuenta.
                Intent registro = new Intent(MainActivity.this, registro_usuarios.class);
                startActivity(registro);
            }
        });

    }
}