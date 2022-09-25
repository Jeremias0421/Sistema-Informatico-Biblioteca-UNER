package com.biblioteca;

import java.time.LocalDate;

public class Edicion {
    private String editorial;
    private String paisEdicion;
    private int numeroEdicion;
    private LocalDate anio;
    private int volumenes;
    private int paginas;
    private String idioma;
    private Formato formato;
    private Obra obra;

    public Edicion(String editorial, String paisEdicion, int numeroEdicion, LocalDate anio, int volumenes, int paginas,
            String idioma, Formato formato, Obra obra) {
        this.editorial = editorial;
        this.paisEdicion = paisEdicion;
        this.numeroEdicion = numeroEdicion;
        this.anio = anio;
        this.volumenes = volumenes;
        this.paginas = paginas;
        this.idioma = idioma;
        this.formato = formato;
        this.obra = obra;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPaisEdicion() {
        return paisEdicion;
    }

    public void setPaisEdicion(String paisEdicion) {
        this.paisEdicion = paisEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public LocalDate getAnio() {
        return anio;
    }

    public void setAnio(LocalDate anio) {
        this.anio = anio;
    }

    public int getVolumenes() {
        return volumenes;
    }

    public void setVolumenes(int volumenes) {
        this.volumenes = volumenes;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    
    
}
