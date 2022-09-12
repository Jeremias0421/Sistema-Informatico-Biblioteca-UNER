package com.biblioteca;

public class Obra {
    private String titulo;
    private String subtitulo;
    private String autor01;
    private String autor02;
    private String autor03;
    private String areaTematica;
    private String genero;
    
    public Obra(String titulo, String subtitulo, String autor01, String autor02, String autor03, String areaTematica,
            String genero) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.autor01 = autor01;
        this.autor02 = autor02;
        this.autor03 = autor03;
        this.areaTematica = areaTematica;
        this.genero = genero;
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

    

}
