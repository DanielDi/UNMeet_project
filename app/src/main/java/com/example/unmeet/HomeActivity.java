package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unmeet.controller.HomeController;
import com.example.unmeet.controller.SuscripcionController;
import com.example.unmeet.model.pojo.Grupo;
import com.example.unmeet.model.pojo.Suscripcion;
import com.example.unmeet.view.fragments.Fragment_Grupo;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<Grupo> grupos = HomeController.obtenerGrupos(this);
        List<Suscripcion> gruposDelUsuario = SuscripcionController
                .obtenerGruposDelUsuario(this,getIntent().getExtras().getString("correoUsuario"));

        for(Suscripcion suscripcion: gruposDelUsuario){
            getSupportFragmentManager().beginTransaction().add(R.id.linear_layout_grupos_usuario_home,
                    Fragment_Grupo.newInstance(suscripcion.getNombreGrupo())).commit();
        }

//        for(int i = 0; i < 5; i++){
//            getSupportFragmentManager().beginTransaction().add(R.id.linear_layout_grupos_usuario_home,
//                    Fragment_Grupo.newInstance(i + "")).commit();
//        }

        for(Grupo grupo: grupos){
            getSupportFragmentManager().beginTransaction().add(R.id.linear_layout_grupos_home,
                    Fragment_Grupo.newInstance(grupo.getNombre())).commit();
        }
//        for(int i = 5; i < 10; i++){
//            getSupportFragmentManager().beginTransaction().add(R.id.linear_layout_grupos_home,
//                    Fragment_Grupo.newInstance(i + "")).commit();
//        }
    }
}