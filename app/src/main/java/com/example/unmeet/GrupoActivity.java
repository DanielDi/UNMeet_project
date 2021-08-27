package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GrupoActivity extends AppCompatActivity {

  private TextView nombreGrupoTextView;
  private TextView descripcionGrupoTextView;
  private Button homeButton, backButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_grupo);
    nombreGrupoTextView = findViewById(R.id.grupo_activity_nombre_grupo);
    nombreGrupoTextView.setText(getIntent().getExtras().getString("nombre"));
    descripcionGrupoTextView = findViewById(R.id.grupo_activity_descripcion_grupo);
    descripcionGrupoTextView.setText("Descripción: " + getIntent().getExtras().getString("descripcion"));

    homeButton = findViewById(R.id.home_button);
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



}