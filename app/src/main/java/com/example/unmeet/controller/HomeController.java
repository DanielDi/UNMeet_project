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
import com.example.unmeet.shared.ConexionInternet;
import com.example.unmeet.shared.PopUp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeController {

    public static void crearVistaHome(IniciarSesionActivity iniciarSesionActivity, String correo) {
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
          .map(grupo -> grupo.getNombre())
          .collect(Collectors.toList());

        List<List<String>> gruposUsuarios = new ArrayList<List<String>>();

        gruposUsuarios.add(0, nombreGruposUsuarioSigue);
        gruposUsuarios.add(1, nombresGruposUsuarioNoSigue);


        return gruposUsuarios;
    }

    public static void solicitarCrearVistaGrupo(HomeActivity homeActivity, String nombre, String correo) {
        GrupoController grupoController = new GrupoController();

        if (ConexionInternet.verificarConexionInternet(homeActivity)) {
            grupoController.CrearVistaGrupo(homeActivity, nombre, correo);
        } else {
            PopUp.mostrarPopUp(homeActivity, "No hay conexi??n a internet. Int??ntalo m??s tarde", "");
        }

    }
}
