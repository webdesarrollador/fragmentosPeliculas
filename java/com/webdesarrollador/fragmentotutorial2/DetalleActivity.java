package com.webdesarrollador.fragmentotutorial2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by raulrevillas on 16/12/2016.
 */

public class DetalleActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_activity);

        FragmentoDetalle detalle = (FragmentoDetalle)getSupportFragmentManager().findFragmentById(R.id.detail);

        detalle.datosPelicula(getIntent().getStringExtra("titulo"),getIntent().getStringExtra("director"),getIntent().getIntExtra("year",0));

    }
}



