package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.unmeet.R;
import com.example.unmeet.controller.IniciarSesionController;

import java.util.regex.Pattern;

public class IniciarSesionActivity extends AppCompatActivity {

  private Button iniciarSesionButton;
  private IniciarSesionController iniciarSesionController;
  private EditText correo;
  private EditText contraseña;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_iniciar_sesion);
    iniciarSesionButton = findViewById(R.id.iniciar_sesion_button_login);
    correo = findViewById(R.id.iniciar_sesion_input_correo);
    contraseña = findViewById(R.id.iniciar_sesion_input_contraseña);
    iniciarSesionController = new IniciarSesionController();

    iniciarSesionButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        iniciarSesionController.login(correo.getText().toString(), contraseña.getText().toString());

      }
    });

  }




}