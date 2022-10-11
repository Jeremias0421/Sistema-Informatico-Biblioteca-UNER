package com.biblioteca;

import java.util.ArrayList;

public class Obra {
    private String titulo;
    private String subtitulo;
    private String autor01;
    private String autor02;
    private String autor03;
    private String areaTematica;
    private String genero;
    private String isbn;
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
        setIsbn(isbn);
        this.ediciones = edicion; 
        this.ejemplares = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getAutor01() {
        return autor01;
    }

    public void setAutor01(String autor01) {
        this.autor01 = autor01;
    }

    public String getAutor02() {
        return autor02;
    }

    public void setAutor02(String autor02) {
        this.autor02 = autor02;
    }

    public String getAutor03() {
        return autor03;
    }

    public void setAutor03(String autor03) {
        this.autor03 = autor03;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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
                this.isbn = isbn;
            }
        }
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
