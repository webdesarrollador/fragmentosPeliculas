package com.webdesarrollador.fragmentotutorial2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by raulrevillas on 17/12/2016.
 */

public class FragmentoDetalle extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragmento_detail, container, false);
    }

    public void datosPelicula(String titulo,String director,int year) {
        TextView tituloText = (TextView)getView().findViewById(R.id.titulo);
        TextView directorText = (TextView)getView().findViewById(R.id.director);
        TextView yearText = (TextView)getView().findViewById(R.id.year);

        tituloText.setText(titulo);
        directorText.setText(director);
        yearText.setText(Integer.toString(year));
    }
}
