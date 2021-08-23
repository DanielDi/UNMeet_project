package com.example.unmeet.model.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.unmeet.model.pojo.Grupo;

@Dao
public interface GrupoRoomDAO {
    @Query("SELECT * FROM grupos WHERE nombre = :nombreQuery")
    Grupo obtenerUser(String nombreQuery);
}

