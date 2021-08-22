package com.example.unmeet.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.unmeet.model.dao.UserRoomDAO;
import com.example.unmeet.model.pojo.User;

@Database(entities = {User.class}, version = 1)
public abstract class LocalStorage extends RoomDatabase {

  public abstract UserRoomDAO userRoomDAO();
  private  static LocalStorage localStorage;

  public static  LocalStorage getLocalStorage(final Context context) {
    if(localStorage == null) {
      localStorage = Room.databaseBuilder(
        context,
        LocalStorage.class,
        "DCPS2021-01-db")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries() // Crear un hilo ejecución alterna (por facilidad lo hacemos acá, pero es mejor con otra librería).
        .build();
    }
    return localStorage;
  }

}
