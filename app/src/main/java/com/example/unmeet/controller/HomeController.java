package com.example.unmeet.controller;

import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.unmeet.HomeActivity;
import com.example.unmeet.IniciarSesionActivity;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.dao.GrupoRoomDAO;
import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.model.pojo.Suscripcion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeController {
    private GrupoRoomDAO grupoRoomDAO;

    public static void crearVistaHome(IniciarSesionActivity iniciarSesionActivity, String correo){
        Intent newActivity = new Intent(iniciarSesionActivity, HomeActivity.class);
        newActivity.putExtra("correoUsuario", correo);
        iniciarSesionActivity.startActivity(newActivity);
        iniciarSesionActivity.finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<List<String>> solicitarGrupos(HomeActivity homeActivity, String correo) {
        List<String> nombreGruposUsuarioSigue = SuscripcionController
          .obtenerGruposDelUsuario(homeActivity, correo)
          .stream()
          .map(sus -> sus.getNombreGrupo())
          .collect(Collectors.toList());

        List<String> nombresGruposUsuarioNoSigue = SuscripcionController
          .obtenerGruposNoDelUsuario(homeActivity, correo)
          .stream()
          .map(grupo -> grupo.getNombreGrupo())
          .collect(Collectors.toList());

        List<List<String>> gruposUsuarios = new ArrayList<List<String>>();

        gruposUsuarios.add(0, nombreGruposUsuarioSigue);
        gruposUsuarios.add(1, nombresGruposUsuarioNoSigue);


        return gruposUsuarios;
    }
}
