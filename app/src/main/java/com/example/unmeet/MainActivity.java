package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unmeet.controller.HomeEntryController;

public class MainActivity extends AppCompatActivity {

  private Button loginButton;
  HomeEntryController homeEntryController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loginButton = findViewById(R.id.home_entry_login_button);


    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) { solicitarInicioSesion(); }
    });

    homeEntryController = new HomeEntryController();
  }

  public void solicitarInicioSesion() {
    Intent newActivity = new Intent(this, IniciarSesionActivity.class);
    startActivity(newActivity);
    finish();
  }
}