package com.example.unmeet.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.unmeet.model.pojo.Suscripcion;

@Dao
public interface SuscripcionRoomDAO {
    @Query("SELECT * FROM suscripciones " +
            "WHERE correoUsuario = :correoUsuarioQ ORDER BY nombreGrupo")
    Suscripcion obtenerGruposUsuario(String correoUsuarioQ, String nombreGrupoQ);

    @Query("SELECT * FROM suscripciones " +
            "WHERE correoUsuario != :correoUsuarioQ ORDER BY nombreGrupo")
    Suscripcion obtenerGrupos(String correoUsuarioQ, String nombreGrupoQ);

    @Insert
    void insertAll(Suscripcion ...suscripciones);
    @Delete
    void deleteOne(Suscripcion suscripcion);


    //Delete suscripcion

}
