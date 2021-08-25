package com.example.unmeet.controller;

import android.content.Intent;

import com.example.unmeet.GrupoActivity;
import com.example.unmeet.HomeActivity;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.dao.GrupoRoomDAO;
import com.example.unmeet.model.pojo.Grupo;

public class GrupoController {

  private GrupoRoomDAO grupoRoomDAO;


  public void CrearVistaGrupo(HomeActivity homeActivity, String nombre, String correo) {

    Intent newActivity = new Intent(homeActivity, GrupoActivity.class);
    Grupo grupo = this.consultarGrupoPorNombre(homeActivity, nombre);
    newActivity.putExtra("correoUsuario", correo);
    newActivity.putExtra("nombre", grupo.getNombre());
    newActivity.putExtra("descripcion", grupo.getDescripcion());
    homeActivity.startActivity(newActivity);
    homeActivity.finish();
  }

  public Grupo consultarGrupoPorNombre(HomeActivity homeActivity, String nombre) {
    this.grupoRoomDAO = LocalStorage.getLocalStorage(homeActivity.getApplicationContext())
      .grupoRoomDAO();
    return this.grupoRoomDAO.obtenerGrupo(nombre);
  }

}
