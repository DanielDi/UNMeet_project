package com.example.unmeet.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.unmeet.model.pojo.Suscripcion;

import java.util.List;

@Dao
public interface SuscripcionRoomDAO {
    @Query("SELECT * FROM suscripciones " +
            "WHERE correoUsuario = :correoUsuarioQ ORDER BY nombreGrupo")
    List<Suscripcion> obtenerGruposUsuario(String correoUsuarioQ);

//    @Query("SELECT * FROM suscripciones " +
//            "WHERE correoUsuario != :correoUsuarioQ AND nombreGrupo ORDER BY nombreGrupo")
//    Suscripcion obtenerGrupos(String correoUsuarioQ, String nombreGrupoQ);

    @Insert
    void insertAll(Suscripcion ...suscripciones);
    @Delete
    void deleteOne(Suscripcion suscripcion);


    //Delete suscripcion

}
