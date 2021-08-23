package com.example.unmeet.controller;

import android.content.Intent;

import com.example.unmeet.HomeActivity;
import com.example.unmeet.IniciarSesionActivity;

public class HomeController {

    public static void crearVistaHome(IniciarSesionActivity iniciarSesionActivity, String correo){
        Intent newActivity = new Intent(iniciarSesionActivity, HomeActivity.class);
        newActivity.putExtra("correoUsuario", correo);
        iniciarSesionActivity.startActivity(newActivity);
        iniciarSesionActivity.finish();
    }
}
