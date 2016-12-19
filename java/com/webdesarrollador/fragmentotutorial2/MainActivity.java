package com.webdesarrollador.fragmentotutorial2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements FragmentoMaster.PeliculaListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void peliculaSelect(Pelicula pelicula) {

        //Comprobamos si se ha cargado el layout que tiene el fragmento detalle
        boolean anchoGrande =  findViewById(R.id.detail) != null;

        //Si se ha cargado
        if(anchoGrande) {
            ((FragmentoDetalle)getSupportFragmentManager().findFragmentById(R.id.detail)).datosPelicula(pelicula.getTitulo(),pelicula.getDirector(),
                    pelicula.getYear());
        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra("titulo", pelicula.getTitulo());
            i.putExtra("director", pelicula.getDirector());
            i.putExtra("year",pelicula.getYear());
            startActivity(i);
        }
    }
}
