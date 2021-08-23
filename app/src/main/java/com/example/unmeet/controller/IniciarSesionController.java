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


public class IniciarSesionController {
    private UserRoomDAO userRoomDAO;

    public void login(IniciarSesionActivity context, String correo, String contraseña){
        System.out.println(correo + " " + contraseña);
        Boolean internet = verificarConexionInternet(context);

        if(!internet){
            context.mostrarPopUp("No hay conexión a internet. Intentalo mas tarde");
        } else {
            Boolean checkCorreo = verificarFormatoCorreo(correo);
            if(!checkCorreo){
                context.mostrarPopUp("Correo malo");
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
            System.out.println("USER EXISTENTE: ");
            System.out.println(user.getCorreo());
            //TODO solicitarVistaHomeActivity con pop up sesion iniciada
        }
    }

    public boolean verificarFormatoCorreo(String correo){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(correo).matches();
    }

    public Boolean verificarConexionInternet(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

}
