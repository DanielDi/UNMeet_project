package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unmeet.controller.HomeEntryController;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.dao.UserRoomDAO;
import com.example.unmeet.model.pojo.User;

public class MainActivity extends AppCompatActivity {

  private Button loginButton;
  private Button registerButton;
  private UserRoomDAO userRoomDAO;
  HomeEntryController homeEntryController;

  Dialog dialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loginButton = findViewById(R.id.home_entry_login_button);
    registerButton = findViewById(R.id.home_entry_register_button);

    registerButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) { crearUsuarios(); }
    });
    dialog = new Dialog(this);

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

  public void crearUsuarios(){
    this.userRoomDAO = LocalStorage.getLocalStorage(this.getApplicationContext())
            .userRoomDAO();
    User user1 = new User("El pepe", "pepe@gmail.com", "FOTO.jpg", "01/02/1956","123", "Pepelandia");
    User user2 = new User("Jack", "jack@unal.edu.co", "Paisaje.jpg", "01/02/1974","123", "Caribe");
    User user3 = new User("Zacarias Piedras del Rio", "zacarias@gmail.com", "foto_rio.jpg", "06/02/1996","123", "Medellin");
    User user4 = new User("Albajad mamhad", "afgano@gmail.com", "Taliban.jpg", "01/02/1977","123", "Bello");
    this.userRoomDAO.insertAll(user1, user2, user3, user4);
    System.out.println("USUARIOS CREADOS ");
  }

  public void mostrarMensajeAlerta(String message1, String... message2) {
      // Changing basic dialog
      dialog.setContentView(R.layout.custom_dialog_alert);
      dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

      // Getting text views from dialog
      TextView firstAlertMessage = (TextView) dialog.findViewById(R.id.first_alert_message);
      TextView secondAlertMessage = (TextView) dialog.findViewById(R.id.second_alert_message);

      // Setting custom messages
      firstAlertMessage.setText(message1);
      secondAlertMessage.setText(message2[0] != "" ? message2[0] : "");

      ImageView imageViewClose = dialog.findViewById(R.id.close_button_alert_message);

      imageViewClose.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              dialog.dismiss();
//              Toast.makeText(MainActivity.this, "Dialog close", Toast.LENGTH_SHORT).show();
          }
      });

      dialog.show();
  }
}