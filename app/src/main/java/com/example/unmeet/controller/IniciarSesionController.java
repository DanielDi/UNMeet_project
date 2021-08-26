package com.example.unmeet.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;

import com.example.unmeet.IniciarSesionActivity;
import com.example.unmeet.R;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.dao.UserRoomDAO;
import com.example.unmeet.model.pojo.User;

import java.util.List;
import java.util.regex.Pattern;
import com.example.unmeet.controller.HomeController;
import com.example.unmeet.shared.ConexionInternet;
import com.example.unmeet.shared.PopUp;


public class IniciarSesionController {
    private UserRoomDAO userRoomDAO;

    public void login(IniciarSesionActivity context, String correo, String contraseña){
        System.out.println(correo + " " + contraseña);
        Boolean internet = ConexionInternet.verificarConexionInternet(context);

        if(!internet){
            PopUp.mostrarPopUp(context,"No hay conexión a internet. Intentalo mas tarde", "");
        } else {
            Boolean checkCorreo = verificarFormatoCorreo(correo);
            if(!checkCorreo){
                PopUp.mostrarPopUp(context,"Verifica el correo", "");
            } else {
                verificarInicioSesion(context, correo, contraseña);
            }
        }

    }

    public void verificarInicioSesion(IniciarSesionActivity iniciarSesionActivity, String correo,
                                      String contraseña){
        this.userRoomDAO = LocalStorage.getLocalStorage(iniciarSesionActivity.getApplicationContext())
                .userRoomDAO();
        User user = this.userRoomDAO.obtenerUser(correo);

        if(user == null || user.getContrasena().compareTo(contraseña) < 0){
            iniciarSesionActivity.mostrarPopUp("Correo o contraseña inválidos");
        } else {
            HomeController.crearVistaHome(iniciarSesionActivity, correo);
        }
    }

    public boolean verificarFormatoCorreo(String correo){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(correo).matches();
    }

}
