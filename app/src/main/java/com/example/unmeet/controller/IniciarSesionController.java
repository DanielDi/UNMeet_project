package com.example.unmeet.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;

import java.util.regex.Pattern;

public class IniciarSesionController {

    public void login(String correo, String contraseña){
        System.out.println(correo + " " + contraseña);
        Boolean verCorreo = verificarFormatoCorreo(correo);
        if(verCorreo){System.out.println("SI ES");}

    }

    public boolean verificarFormatoCorreo(String correo){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(correo).matches();
    }

//    public Boolean verificarConexionInternet(){
//
//    }

}
