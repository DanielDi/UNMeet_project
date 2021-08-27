package com.example.unmeet.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.model.pojo.Suscripcion;

import java.util.List;

@Dao
public interface SuscripcionRoomDAO {
    @Query("SELECT * FROM suscripciones " +
            "WHERE correoUsuario = :correoUsuarioQ ORDER BY nombreGrupo")
    List<Suscripcion> obtenerGruposUsuarioSigue(String correoUsuarioQ);

    @Query("SELECT * FROM grupos g " +
            "LEFT JOIN (SELECT * FROM suscripciones " +
            "WHERE correoUsuario = :correoUsuarioQ) AS s " +
            "ON g.nombre = s.nombregrupo " +
            "WHERE s.nombregrupo IS NULL")
    List<Grupo> obtenerGruposUsuarioNoSigue(String correoUsuarioQ);

    @Query("SELECT * FROM suscripciones " +
            "WHERE correoUsuario = :correoUsuarioQ AND nombreGrupo = :nombreGrupoQ ORDER BY nombreGrupo")
    List<Suscripcion> obtenerSuscripcionGruposUsuario(String correoUsuarioQ, String nombreGrupoQ);

    @Insert
    void insertAll(Suscripcion ...suscripciones);
    @Delete
    void deleteOne(Suscripcion suscripcion);


    //Delete suscripcion
    @Query("DELETE FROM suscripciones")
    void deleteAll();
}
