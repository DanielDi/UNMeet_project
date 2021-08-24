package com.example.unmeet.controller;


import com.example.unmeet.HomeActivity;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.pojo.Suscripcion;

import java.util.List;

public class SuscripcionController {

    public static List<Suscripcion> obtenerGruposDelUsuario(HomeActivity homeActivity, String correo){
        return LocalStorage.getLocalStorage(homeActivity.getApplicationContext())
                .suscripcionRoomDAO()
                .obtenerGruposUsuarioSigue(correo);
    }

    public static List<Suscripcion> obtenerGruposNoDelUsuario(HomeActivity homeActivity, String correo){
        return LocalStorage.getLocalStorage(homeActivity.getApplicationContext())
          .suscripcionRoomDAO()
          .obtenerGruposUsuarioNoSigue(correo);
    }

}
