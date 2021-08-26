package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unmeet.controller.HomeEntryController;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.dao.GrupoRoomDAO;
import com.example.unmeet.model.dao.SuscripcionRoomDAO;
import com.example.unmeet.model.dao.UserRoomDAO;
import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.model.pojo.Suscripcion;
import com.example.unmeet.model.pojo.User;
import com.example.unmeet.shared.PopUp;

public class HomeEntryActivity extends AppCompatActivity {

  private Button loginButton;
  private Button registerButton;
  private UserRoomDAO userRoomDAO;
  private GrupoRoomDAO grupoRoomDAO;
  private SuscripcionRoomDAO suscripcionRoomDAO;
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
      public void onClick(View view) {
          try{
              crearUsuarios();
              crearGrupos();
              crearSuscripciones();
              crearPopUp("Usuarios, grupos y suscripciones creadas!", "");
          } catch (Error e){
              crearPopUp("Usuarios, grupos y suscripciones ya están creados", "");
          }
      }
    });
//    dialog = new Dialog(this);

    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) { solicitarInicioSesion(); }
    });

    homeEntryController = new HomeEntryController();
  }

  public void solicitarInicioSesion() {
      HomeEntryController.solicitarInicioSesion(this);
  }

  public void crearUsuarios() {
    this.userRoomDAO = LocalStorage.getLocalStorage(this.getApplicationContext())
            .userRoomDAO();
    this.userRoomDAO.eliminarUsers();
    User user1 = new User("El pepe", "pepe@gmail.com", "FOTO.jpg",
      "01/02/1956","123", "Pepelandia");
    User user2 = new User("Jack", "jack@unal.edu.co", "Paisaje.jpg",
      "01/02/1974","123", "Caribe");
    User user3 = new User("Zacarias Piedras del Rio", "zacarias@gmail.com", "foto_rio.jpg",
      "06/02/1996","123", "Medellin");
    User user4 = new User("Albajad mamhad", "afgano@gmail.com", "Taliban.jpg",
      "01/02/1977","123", "Bello");
    this.userRoomDAO.insertAll(user1, user2, user3, user4);
    System.out.println("USUARIOS CREADOS ");
  }

  public void crearGrupos() {
      this.grupoRoomDAO = LocalStorage
        .getLocalStorage(this.getApplicationContext()).grupoRoomDAO();
      Grupo grupo1 = new Grupo("Danzas Joropo",
        "El joropo es una danza colombiana de muchos años de historia",
        "viejos_cachondos.jpg");
      Grupo grupo2 = new Grupo("Mujeres unidadas",
        "Mujeres que les gusta el boxeo, kick-boxing y la WWE",
        "grupo_u_2013.jpg");
      Grupo grupo3 = new Grupo("Programadores expertos del ventiadero",
        "Este grupo nacio de una farra en el ventiadero donde se buscaba crear una app para coger",
        "ventiadero_45.png");
      Grupo grupo4 = new Grupo("Deportes Unal",
        "La realización de actividad física es algo esencial para la salud y el bienestar general",
        "deportes_unal.jpg");
      Grupo grupo5 = new Grupo("Ajedrez",
        "Perfecciona tus habilidades de ajedrez y compite en torneos",
        "chess.jpg");
      this.grupoRoomDAO.insertAll(grupo1,grupo2,grupo3,grupo4,grupo5);
      System.out.println("GRUPOS CREADOS");
  }

  public void crearSuscripciones() {
    this.suscripcionRoomDAO = LocalStorage.getLocalStorage(this.getApplicationContext())
      .suscripcionRoomDAO();
    Suscripcion susc1 = new Suscripcion("pepe@gmail.com", "Deportes Unal");
    Suscripcion susc2 = new Suscripcion("pepe@gmail.com", "Ajedrez");
    this.suscripcionRoomDAO.insertAll(susc1, susc2);
    System.out.println("SUSCRIPCIONES CREADAS");
  }

  public void crearPopUp(String mensaje, String mensaje2){
      PopUp.mostrarPopUp(this, mensaje, mensaje2);
  }

}