package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.unmeet.controller.IniciarSesionController;

public class IniciarSesionActivity extends AppCompatActivity {

  private Button iniciarSesionButton;
  private IniciarSesionController iniciarSesionController;
  private EditText correo;
  private EditText contraseña;
  private Button backButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_iniciar_sesion);

    iniciarSesionButton = findViewById(R.id.grupo_activity_button_seguir_abandonar);
    correo = findViewById(R.id.iniciar_sesion_input_correo_edit_text);
    contraseña = findViewById(R.id.iniciar_sesion_input_contraseña_edit_text);
    backButton = findViewById(R.id.back_button);

    iniciarSesionController = new IniciarSesionController();
    IniciarSesionActivity context = this;

    iniciarSesionButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        iniciarSesionController.login(context, correo.getText().toString(), contraseña.getText().toString());
      }
    });

    backButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
          finish();
        }
      }
    });

    getSupportActionBar().hide();

  }

  public void mostrarPopUp(String mensaje){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage(mensaje)
            .setPositiveButton("X", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
              }
            });

    AlertDialog dialog = builder.create();
    dialog.show();
  }


}