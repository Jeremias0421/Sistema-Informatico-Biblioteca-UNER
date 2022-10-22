package com.biblioteca;

import java.util.ArrayList;

/**
 * Representacion de una Obra literaria.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Obra {
    /** Titulo principal de la Obra */
    private final String titulo;
    /** Subtitulo */
    private final String subtitulo;
    /** Primer autor */
    private final String autor01;
    /** Segundo autor */
    private final String autor02;
    /** Tercer autor */
    private final String autor03;
    /** Tematica principal */
    private final String areaTematica;
    /** Genero literario */
    private final String genero;
    /** Codigo numero estandar que identifica a la Obra */
    private final String isbn;
    /** Lista de las ediciones que tiene la Obra en Biblioteca */
    private ArrayList<Edicion> ediciones;
    /** Lista de ejemplares actualmente en Biblioteca */
    private ArrayList<Ejemplar> ejemplares;
    /** Indice de la Obra */
    private ArrayList<String> temasIndice;

    /**
     * 
     * @param titulo
     * @param subtitulo
     * @param autor01
     * @param autor02
     * @param autor03
     * @param areaTematica
     * @param genero
     * @param isbn
     * @param edicion
     */
    public Obra(String titulo, String subtitulo, String autor01, String autor02, String autor03, String areaTematica,
            String genero, String isbn, ArrayList<Edicion> edicion) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.autor01 = autor01;
        this.autor02 = autor02;
        this.autor03 = autor03;
        this.areaTematica = areaTematica;
        this.genero = genero;
        this.isbn = validarISBN(isbn);
        this.ediciones = edicion;
        this.ejemplares = new ArrayList<>();
        this.temasIndice = new ArrayList<String>();
    }

    /**
     * 
     * @return titulo principal de la Obra
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * 
     * @return subtitulo principal de la Obra
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     * 
     * @return primer autor de la Obra
     */
    public String getAutor01() {
        return autor01;
    }

    /**
     * 
     * @return segundo autor de la Obra
     */
    public String getAutor02() {
        return autor02;
    }

    /**
     * 
     * @return tercer autor de la Obra
     */
    public String getAutor03() {
        return autor03;
    }

    /**
     * 
     * @return tematica principal de la Obra
     */
    public String getAreaTematica() {
        return areaTematica;
    }

    /**
     * 
     * @return genero de la Obra
     */
    public String getGenero() {
        return genero;
    }

    /**
     * 
     * @return ISBN de la Obra
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * 
     * @param isbn ISBN a validar
     * @return ISBN valido
     */
    private String validarISBN(String isbn) {
        String isbnValido = null;
        if (isbn.matches("^((978)|(979))(\\d{7}|\\d{10})")) {
            int intNro;
            int digitoNro;
            int temp;
            int sum = 0;
            for (int i = 0; i < isbn.length(); i++) {
                intNro = Integer.parseInt(isbn.substring(i, i + 1));
                digitoNro = i + 1;
                temp = digitoNro * intNro;
                sum = sum + temp;
            }
            if ((sum % 11) == 0) {
                isbnValido = isbn;
            }
        }
        return isbnValido;
    }

    /**
     * 
     * @return lista de ediciones de la Obra
     */
    public ArrayList<Edicion> getEdiciones() {
        return ediciones;
    }

    /**
     * 
     * @return lista de ejemplares que pertenece a la Obra
     */
    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    /**
     * 
     * @param ejemplar ejemplar a aniadir a la lista de Obras
     */
    public void añadirEjemplar(Ejemplar ejemplar) {
        this.ejemplares.add(ejemplar);
    }
}
