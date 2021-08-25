package com.example.unmeet.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.unmeet.HomeActivity;
import com.example.unmeet.R;
import com.example.unmeet.controller.GrupoController;
import com.example.unmeet.controller.HomeController;

public class Fragment_Grupo extends Fragment {

    private String nombreGrupo;
    private View rootView;
    private TextView nombreGrupoTextView;
    private Button myButton;
    private HomeController homeController;
    private HomeActivity homeActivity;

    public Fragment_Grupo() {
        // Required empty public constructor
    }

    public static Fragment_Grupo newInstance(String nombre, HomeActivity homeActivity) {
        Fragment_Grupo fragment = new Fragment_Grupo();
        fragment.setNombreGrupo(nombre);
        fragment.setHomeActivity(homeActivity);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment__grupo, container, false);
        nombreGrupoTextView = rootView.findViewById(R.id.nombre_grupo_text_fragment);
        nombreGrupoTextView.setText(this.nombreGrupo);
        myButton = (Button) rootView.findViewById(R.id.button_fragment_group);


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println(nombreGrupoTextView.getText());
                homeActivity.getNombreGrupo(nombreGrupoTextView.getText().toString());
            }
        });
        return rootView;
    }

    public HomeActivity getHomeActivity() {
        return homeActivity;
    }

    public void setHomeActivity(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

}