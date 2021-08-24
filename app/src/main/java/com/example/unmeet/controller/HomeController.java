package com.example.unmeet.controller;

import android.content.Intent;

import com.example.unmeet.HomeActivity;
import com.example.unmeet.IniciarSesionActivity;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.dao.GrupoRoomDAO;
import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.model.pojo.Suscripcion;

import java.util.ArrayList;
import java.util.List;

public class HomeController {
    private GrupoRoomDAO grupoRoomDAO;

    public static void crearVistaHome(IniciarSesionActivity iniciarSesionActivity, String correo){
        Intent newActivity = new Intent(iniciarSesionActivity, HomeActivity.class);
        newActivity.putExtra("correoUsuario", correo);
        iniciarSesionActivity.startActivity(newActivity);
        iniciarSesionActivity.finish();
    }

    public static List<Grupo> obtenerGrupos(HomeActivity homeActivity){
        return LocalStorage.getLocalStorage(homeActivity.getApplicationContext()).grupoRoomDAO().obtenerGrupos();
    }

    //List<List<Grupo>> listaL= HomeController.solicitarGrupos(this,getIntent().getExtras().getString("correoUsuario"))
    public static Tuple<List<Grupo>,List<Suscripcion> > solicitarGrupos(HomeActivity homeActivity,String correo) {
        List<Grupo> grupos = HomeController.obtenerGrupos(homeActivity);

        List<Suscripcion> gruposDelUsuario = SuscripcionController
                .obtenerGruposDelUsuario(homeActivity,correo);

//        List<Grupo> gruposNoDelUsuario = new ArrayList<Grupo>();
//
//        for(Suscripcion sus: gruposDelUsuario){
//            List<Grupo> aux = grupos.stream().filter(grupo -> grupo.getNombre() != sus.getNombreGrupo());
//        }


        return null;
    }
}
