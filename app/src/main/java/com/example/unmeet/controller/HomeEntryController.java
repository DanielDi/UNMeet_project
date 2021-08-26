package com.example.unmeet.controller;

import android.content.Context;
import android.content.Intent;

import com.example.unmeet.HomeEntryActivity;
import com.example.unmeet.IniciarSesionActivity;

public class HomeEntryController {

  public static void solicitarInicioSesion(HomeEntryActivity context) {
    Intent newActivity = new Intent(context, IniciarSesionActivity.class);
    context.startActivity(newActivity);
    context.finish();
  }

  public static void verficarConexionInternet() {

  }

}
