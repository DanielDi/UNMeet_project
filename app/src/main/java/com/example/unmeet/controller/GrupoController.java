package com.example.unmeet.controller;

import android.content.Intent;

import com.example.unmeet.GrupoActivity;
import com.example.unmeet.HomeActivity;
import com.example.unmeet.model.LocalStorage;
import com.example.unmeet.model.dao.GrupoRoomDAO;
import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.shared.ConexionInternet;
import com.example.unmeet.shared.PopUp;

public class GrupoController {

  private GrupoRoomDAO grupoRoomDAO;


  public void CrearVistaGrupo(HomeActivity homeActivity, String nombre, String correo) {

    Intent newActivity = new Intent(homeActivity, GrupoActivity.class);
    this.grupoRoomDAO = LocalStorage.getLocalStorage(homeActivity.getApplicationContext())
            .grupoRoomDAO();
    Grupo grupo = this.grupoRoomDAO.obtenerGrupo(nombre);

    newActivity.putExtra("correoUsuario", correo);
    newActivity.putExtra("nombre", grupo.getNombre());
    newActivity.putExtra("descripcion", grupo.getDescripcion());
    homeActivity.startActivity(newActivity);
//    homeActivity.finish();
  }

  public static boolean verificarUsuarioSigueGrupo(GrupoActivity grupoActivity,String correo, String nombreGrupo){
    if(SuscripcionController.obtenerSuscripcionGrupoUsuario(grupoActivity, correo, nombreGrupo).isEmpty()){
      return false;
    }
    return true;
  }

  public static void seguirGrupo(GrupoActivity grupoActivity,String correo, String nombreGrupo){
    Boolean internet = ConexionInternet.verificarConexionInternet(grupoActivity);
    if(!internet){
      PopUp.mostrarPopUp(grupoActivity, "No hay conexión a internet. Intentalo mas tarde", "");
    }else{
      SuscripcionController controller = new SuscripcionController();
      controller.crearSuscripcion(grupoActivity,correo,nombreGrupo);
      PopUp.mostrarPopUp(grupoActivity, "Ahora sigues este grupo", "");
    }
  }

  public static void abandonarGrupo(GrupoActivity grupoActivity,String correo, String nombreGrupo){
    Boolean internet = ConexionInternet.verificarConexionInternet(grupoActivity);
    if(!internet){
      PopUp.mostrarPopUp(grupoActivity,"No hay conexión a internet. Intentalo mas tarde", "");
    }else{
      SuscripcionController controller = new SuscripcionController();
      controller.eliminarSuscripcion(grupoActivity,correo,nombreGrupo);
      PopUp.mostrarPopUp(grupoActivity, "Ahora no sigues este grupo", "");
    }
  }
}
