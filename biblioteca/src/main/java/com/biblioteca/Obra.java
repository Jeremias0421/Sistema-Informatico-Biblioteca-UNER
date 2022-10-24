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
    /** Tipo de Obra */
    private TipoObra tipoObra;

    /**
     * Instancia una nueva Obra.
     * 
     * @param titulo       titulo principal de la Obra
     * @param subtitulo    subtitulo de la Obra
     * @param autor01      primer autor
     * @param autor02      segundo autor
     * @param autor03      tercer autor
     * @param areaTematica tematica de la Obra
     * @param genero       genero literario
     * @param isbn         codigo estandar de Obras
     * @param edicion      edicion de la Obra
     */
    public Obra(String titulo, String subtitulo, String autor01, String autor02, String autor03, String areaTematica,
            String genero, String isbn, ArrayList<Edicion> edicion, TipoObra tipoObra) {

        if (!validarISBN(isbn)) {
            throw new IllegalArgumentException("ISBN invalido");
        }

        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.autor01 = autor01;
        this.autor02 = autor02;
        this.autor03 = autor03;
        this.areaTematica = areaTematica;
        this.genero = genero;
        this.isbn = isbn;
        this.ediciones = edicion;
        this.ejemplares = new ArrayList<>();
        this.temasIndice = new ArrayList<String>();
        this.tipoObra = tipoObra;
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
     * @return tipo de Obra
     */
    public TipoObra getTipoObra() {
        return tipoObra;
    }

    /**
     * 
     * @param isbn ISBN a validar
     * @return {@code true} si el ISBN es un codigo valido para una Obra; de lo
     *         contrario {@code false}
     */
    private boolean validarISBN(String isbn) {

        boolean valido = false;
        if (isbn.matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")) {
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
                valido = true;
            }
        }
        return valido;
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

    public ArrayList<String> getTemasIndice() {
        return temasIndice;
    }

    
    @Override
    public String toString() {
        return  titulo;
    }

    public String toCSV() {
        return titulo + "," + subtitulo + "," + autor01 + "," + autor02
                + "," + autor03 + "," + areaTematica + "," + genero + "," + isbn
                + "," + tipoObra + "\n";
    }

    public String toCSVforEdicion() {
        return titulo + "," + subtitulo + "," + autor01 + "," + autor02
                + "," + autor03 + "," + areaTematica + "," + genero + "," + isbn
                + "," + tipoObra;
    }
}
