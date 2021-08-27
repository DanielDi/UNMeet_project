package com.example.unmeet.controller;


import com.example.unmeet.GrupoActivity;
import com.example.unmeet.HomeActivity;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.dao.SuscripcionRoomDAO;
import com.example.unmeet.model.dao.UserRoomDAO;
import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.model.pojo.Suscripcion;

import java.util.List;

public class SuscripcionController {

    private SuscripcionRoomDAO suscripcionRoomDAO;

    public static List<Suscripcion> obtenerGruposDelUsuario(HomeActivity homeActivity, String correo){
        return LocalStorage.getLocalStorage(homeActivity.getApplicationContext())
                .suscripcionRoomDAO()
                .obtenerGruposUsuarioSigue(correo);
    }

    public static List<Grupo> obtenerGruposNoDelUsuario(HomeActivity homeActivity, String correo){
        return LocalStorage.getLocalStorage(homeActivity.getApplicationContext())
          .suscripcionRoomDAO()
          .obtenerGruposUsuarioNoSigue(correo);
    }

    public static List<Suscripcion> obtenerSuscripcionGrupoUsuario(GrupoActivity grupoActivity,
                                                             String correo, String nombreGrupo){
        return LocalStorage.getLocalStorage(grupoActivity.getApplicationContext())
                .suscripcionRoomDAO()
                .obtenerSuscripcionGruposUsuario(correo,nombreGrupo);
    }

    public boolean crearSuscripcion(GrupoActivity grupoActivity,String correo, String nombreGrupo){
        this.suscripcionRoomDAO = LocalStorage.getLocalStorage(grupoActivity)
                .suscripcionRoomDAO();
        Suscripcion sup = new Suscripcion(correo,nombreGrupo);
        this.suscripcionRoomDAO.insertAll(sup);
        System.out.println("SUSCRIPCION CREADA "+correo+" "+nombreGrupo);
        return true;
    }

    public boolean eliminarSuscripcion(GrupoActivity grupoActivity,String correo, String nombreGrupo){
        this.suscripcionRoomDAO = LocalStorage.getLocalStorage(grupoActivity)
                .suscripcionRoomDAO();
        Suscripcion sup = new Suscripcion(correo,nombreGrupo);
        this.suscripcionRoomDAO.deleteOne(sup);
        System.out.println("SUSCRIPCION ELIMINADA "+correo+" "+nombreGrupo);
        return true;
    }
}
