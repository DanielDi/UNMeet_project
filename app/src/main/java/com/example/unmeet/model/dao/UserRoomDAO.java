package com.example.unmeet.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.unmeet.model.pojo.User;

@Dao
public interface UserRoomDAO {

  @Query("SELECT * FROM users WHERE correo = :correoQuery")
  User obtenerUser(String correoQuery);
  @Insert
  void insertAll(User ...users);
}
