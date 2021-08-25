package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GrupoActivity extends AppCompatActivity {

  private TextView nombreGrupoTextView;
  private TextView descripcionGrupoTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_grupo);
    nombreGrupoTextView = findViewById(R.id.grupo_activity_nombre_grupo);
    nombreGrupoTextView.setText(getIntent().getExtras().getString("nombre"));
    descripcionGrupoTextView = findViewById(R.id.grupo_activity_descripcion_grupo);
    descripcionGrupoTextView.setText(getIntent().getExtras().getString("descripcion"));

  }



}