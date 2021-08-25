package com.example.unmeet.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.model.pojo.Suscripcion;

import java.util.List;

@Dao
public interface GrupoRoomDAO {
    @Query("SELECT * FROM grupos WHERE nombre = :nombreQuery")
    Grupo obtenerGrupo(String nombreQuery);

    @Query("SELECT * FROM grupos")
    List<Grupo> obtenerGrupos();

    @Insert
    void insertAll(Grupo...grupos);
}

