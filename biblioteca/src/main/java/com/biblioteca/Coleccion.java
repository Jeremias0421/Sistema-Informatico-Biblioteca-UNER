package com.biblioteca;

public class Coleccion extends Obra {
    private String nombre;

    public Coleccion(String titulo, String subtitulo, String autor01, String autor02, String autor03,
            String areaTematica, String genero,String isbn,Edicion edicion, String nombre) {
        super(titulo, subtitulo, autor01, autor02, autor03, areaTematica, genero,isbn,edicion);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
