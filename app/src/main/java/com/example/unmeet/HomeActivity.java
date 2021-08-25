package com.example.unmeet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.unmeet.controller.HomeController;
import com.example.unmeet.controller.SuscripcionController;
import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.model.pojo.Suscripcion;
import com.example.unmeet.view.fragments.Fragment_Grupo;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private String correo;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.correo = getIntent().getExtras().getString("correoUsuario").toString();

        List<List<String>> grupos = HomeController
          .solicitarGrupos(this, this.correo);

        for(String nombreGrupo: grupos.get(0)) {
            getSupportFragmentManager()
              .beginTransaction()
              .add(
                    R.id.linear_layout_grupos_usuario_home,
                    Fragment_Grupo.newInstance(nombreGrupo, this))
              .commit();
        }

        for(String nombreGrupo: grupos.get(1)) {
            getSupportFragmentManager()
              .beginTransaction()
              .add(
                    R.id.linear_layout_grupos_home,
                    Fragment_Grupo.newInstance(nombreGrupo, this))
              .commit();
        }

    }

    public void getNombreGrupo(String grupo) {
        HomeController.solicitarCrearVistaGrupo(this, grupo, this.correo);
    }

}