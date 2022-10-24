package com.biblioteca;

import java.util.ArrayList;

/**
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Coleccion extends Obra {

    /**
     * Nombre de la Coleccion
     */
    private String nombre;
    /**
     * ISBN de la Coleccion
     */
    private String isbnColeccion;

    /**
     * Instancia una nueva Coleccion de Ejemplares
     *
     * @param titulo        titulo principal
     * @param subtitulo     subtitulo
     * @param autor01       primer autor
     * @param autor02       segundo autor
     * @param autor03       tercer autor
     * @param areaTematica  tematica principal
     * @param genero        genero principal
     * @param isbn          isbn
     * @param edicion       lista de ediciones
     * @param nombre        titulo
     * @param isbnColeccion isbn de la coleccion
     */
    public Coleccion(String titulo, String subtitulo, String autor01, String autor02, String autor03,
            String areaTematica, String genero, String isbn, ArrayList<Edicion> edicion, String nombre,
            String isbnColeccion) {

        super(titulo, subtitulo, autor01, autor02, autor03, areaTematica, genero, isbn, edicion, TipoObra.LIBRO);
        this.nombre = nombre;
        this.isbnColeccion = isbnColeccion;
    }

    /**
     * @return nombre de la Coleccion
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la Coleccion por uno nuevo
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return isbn de la Coleccion
     */
    public String getIsbnColeccion() {
        return isbnColeccion;
    }

}
