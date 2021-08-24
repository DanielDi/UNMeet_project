package com.example.unmeet.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "suscripciones", primaryKeys = {"correoUsuario", "nombreGrupo"})
public class Suscripcion {
    @NonNull
    private String correoUsuario;
    @NonNull
    private String nombreGrupo;

    public Suscripcion(String correoUsuario, String nombreGrupo) {
        this.correoUsuario = correoUsuario;
        this.nombreGrupo = nombreGrupo;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
}
