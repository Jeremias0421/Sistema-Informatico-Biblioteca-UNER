package com.biblioteca;

import java.util.ArrayList;

public class Obra {
    private final String titulo;
    private final String subtitulo;
    private final String autor01;
    private final String autor02;
    private final String autor03;
    private final String areaTematica;
    private final String genero;
    private final String isbn;
    private ArrayList<Edicion> ediciones;
    private ArrayList<Ejemplar> ejemplares;
    private ArrayList<String> temasIndice;

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
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getAutor01() {
        return autor01;
    }

    public String getAutor02() {
        return autor02;
    }

    public String getAutor03() {
        return autor03;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public String getGenero() {
        return genero;
    }

    public String getIsbn() {
        return isbn;
    }

    private String validarISBN(String isbn) {
        String isbnValido = null;
        if (isbn.matches("^((978)|(979))(\\d{7}|\\d{10})")){
            int intNro;
            int digitoNro;
            int temp;
            int sum = 0;
            for (int i = 0; i < isbn.length(); i++) {  
                intNro = Integer.parseInt(isbn.substring(i, i+1));  
                digitoNro = i + 1;  
                temp = digitoNro * intNro;  
                sum = sum + temp;  
            }  
            if ((sum % 11) == 0){
                isbnValido = isbn;
            }
        }
        return isbnValido;
    }

    public ArrayList<Edicion> getEdiciones() {
        return ediciones;
    }

    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void añadirEjemplar(Ejemplar ejemplar) {
        this.ejemplares.add(ejemplar);
    }
}
