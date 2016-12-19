package com.webdesarrollador.fragmentotutorial2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by raulrevillas on 16/12/2016.
 */

public class FragmentoMaster extends Fragment {

    private Pelicula[] peliculas = new Pelicula[]{
        new Pelicula("Superman", "Richard Donner", 1978),
        new Pelicula("Batman", " Tim Burton", 1989),
        new Pelicula("Spiderman", "Sam Raimi", 2002),
        new Pelicula("Hulk", "Ang Lee", 2003)
    };
    private ListView listadoPeliculas;

    String[] nombrePeliculas = new String[]{"Superman","Superman1","Superman2","Superman3"};

    private PeliculaListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Checkeamos que la actividad contenedora haya implementado la interfaz. Si no, lanzamos una excepción
        if (activity instanceof PeliculaListener) {
            listener = (PeliculaListener) activity;
        } else {
            throw new ClassCastException(activity.toString()+ " debe implementar PeliculaListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_master, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Definimos el adaptador para que nos genere la ListView con el array nombrePeliculas
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, nombrePeliculas);
        listadoPeliculas = (ListView)getView().findViewById(R.id.listadoPeliculas);
        listadoPeliculas.setAdapter(adaptador);

        //Cuando seleccionamos un item, lanzaremos un evento que ejecutará el método peliculaSelect, teniendo como parámetro el
        //objeto de la película seleccionada
        listadoPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
                if (listener!=null) {
                    listener.peliculaSelect((Pelicula)peliculas[pos]);
                }
            }
        });
    }
    //Métodos de la interfaz
    public interface PeliculaListener{
        void peliculaSelect(Pelicula pelicula);
    }
}