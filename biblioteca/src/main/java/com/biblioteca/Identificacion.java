package com.biblioteca;

public class Identificacion {
    private Ejemplar seUbica;
    private int pasillo;
    private int estante;
    private int fila;
    private int columna;
    private int posicion;

    public Identificacion(Ejemplar seUbica, int pasillo, int estante, int fila, int columna, int posicion) {
        this.seUbica = seUbica;
        this.pasillo = pasillo;
        this.estante = estante;
        this.fila = fila;
        this.columna = columna;
        this.posicion = posicion;
    }

    public Ejemplar getSeUbica() {
        return seUbica;
    }

    public void setSeUbica(Ejemplar seUbica) {
        this.seUbica = seUbica;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    
}
