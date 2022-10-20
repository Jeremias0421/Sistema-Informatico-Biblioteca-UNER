package com.biblioteca;

public class Identificacion {
    private Ejemplar ejemplar;
    private int pasillo;
    private int estante;
    private int fila;
    private int columna;
    private int posicion;

    public Identificacion(Ejemplar ejemplar, int pasillo, int estante, int fila, int columna, int posicion) {        
        if (pasillo < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (estante < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (fila < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (columna < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (posicion < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        this.ejemplar = ejemplar;
        this.pasillo = pasillo;
        this.estante = estante;
        this.fila = fila;
        this.columna = columna;
        this.posicion = posicion;
    }

    public Ejemplar getSeUbica() {
        return ejemplar;
    }

    public void setSeUbica(Ejemplar seUbica) {
        this.ejemplar = seUbica;
    }

    public int getPasillo() {
        return pasillo;
    }

    public int getEstante() {
        return estante;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getPosicion() {
        return posicion;
    }

    public void cambiarUbicacion(int pasillo, int estante, int fila, int columna, int posicion) {
        if (pasillo < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (estante < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (fila < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (columna < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (posicion < 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        this.pasillo = pasillo;
        this.estante = estante;
        this.fila = fila;
        this.columna = columna;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return String.format("%s-%s-%s-%s-%s", getPasillo(), getEstante(), getFila(), getColumna(), getPosicion());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Identificacion other = (Identificacion) obj;
        if (ejemplar == null) {
            if (other.ejemplar != null)
                return false;
        } else if (!ejemplar.equals(other.ejemplar))
            return false;
        if (pasillo != other.pasillo)
            return false;
        if (estante != other.estante)
            return false;
        if (fila != other.fila)
            return false;
        if (columna != other.columna)
            return false;
        if (posicion != other.posicion)
            return false;
        return true;
    }

}