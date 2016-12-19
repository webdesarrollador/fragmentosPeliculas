package com.webdesarrollador.fragmentotutorial2;

/**
 * Created by raulrevillas on 16/12/2016.
 */

public class Pelicula {
    private String titulo;
    private String director;
    private int year;
    public Pelicula(String titulo, String director, int year) {
        this.titulo = titulo;
        this.director = director;
        this.year = year;
    }
    public String getTitulo() { return titulo; }
    public String getDirector() { return director; }
    public int getYear() { return year; }
}

