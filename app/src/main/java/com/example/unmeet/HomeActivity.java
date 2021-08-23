package com.example.unmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unmeet.view.fragments.Fragment_Grupo;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        for(int i = 0; i < 5; i++){
            getSupportFragmentManager().beginTransaction().add(R.id.linear_layout_grupos_usuario_home,
                    Fragment_Grupo.newInstance(i + "")).commit();
        }

        for(int i = 5; i < 10; i++){
            getSupportFragmentManager().beginTransaction().add(R.id.linear_layout_grupos_home,
                    Fragment_Grupo.newInstance(i + "")).commit();
        }
    }
}