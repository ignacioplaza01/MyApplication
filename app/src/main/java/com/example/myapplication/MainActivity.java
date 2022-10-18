package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Button registrar;
    EditText etNombre, etApellido, etEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrar();

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etEdad = (EditText) findViewById(R.id.etEdad);


    }

    private void llamadobd() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("alumno").child("r1");

        myRef.child("nombre").setValue("Javier");
        myRef.child("apellido").setValue("Javier");
        myRef.child("edad").setValue("20");
    }

    public void registrar(){
        registrar = (Button) findViewById(R.id.registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String edad = etEdad.getText().toString();
                String key = UUID.randomUUID().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("alumno").child(key);

                myRef.child("nombre").setValue(nombre);
                myRef.child("apellido").setValue(apellido);
                myRef.child("edad").setValue(edad);
            }
        });
    }
}