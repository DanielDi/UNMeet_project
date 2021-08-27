package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.unmeet.controller.GrupoController;
import com.example.unmeet.controller.HomeController;
import com.example.unmeet.controller.SuscripcionController;
import com.example.unmeet.model.pojo.Suscripcion;

public class GrupoActivity extends AppCompatActivity {

  private TextView nombreGrupoTextView;
  private TextView descripcionGrupoTextView;
  private Button backButton;
  private Button but_seguir_abandonar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_grupo);
    GrupoActivity context = this; // paso contexto al boton

    String nombregrupo = getIntent().getExtras().getString("nombre");
    String descgrupo = getIntent().getExtras().getString("descripcion");
    String correo = getIntent().getExtras().getString("correoUsuario");

    nombreGrupoTextView = findViewById(R.id.grupo_activity_nombre_grupo);
    nombreGrupoTextView.setText(nombregrupo);

    descripcionGrupoTextView = findViewById(R.id.grupo_activity_descripcion_grupo);
    descripcionGrupoTextView.setText("Descripción: " + descgrupo);

    but_seguir_abandonar = findViewById(R.id.grupo_activity_button_seguir_abandonar);

    if(usuarioSigueGrupo(this,correo,nombregrupo)){
      but_seguir_abandonar.setText(R.string.grupo_activity_button_abandonar_label);
    }else{
      but_seguir_abandonar.setText(R.string.grupo_activity_button_seguir_label);
    }

    but_seguir_abandonar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        if(but_seguir_abandonar.getText().toString().equals("Seguir Grupo")){
          GrupoController.seguirGrupo(context,correo,nombregrupo);
          but_seguir_abandonar.setText(R.string.grupo_activity_button_abandonar_label);
        }else{
          GrupoController.abandonarGrupo(context,correo,nombregrupo);
          but_seguir_abandonar.setText(R.string.grupo_activity_button_seguir_label);
        }
      }
    });

  backButton = findViewById(R.id.back_button);

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

  public static Boolean usuarioSigueGrupo(GrupoActivity grupoActivity,String correo,String nombreGrupo){
    return GrupoController.verificarUsuarioSigueGrupo(grupoActivity,correo,nombreGrupo);
  }

}