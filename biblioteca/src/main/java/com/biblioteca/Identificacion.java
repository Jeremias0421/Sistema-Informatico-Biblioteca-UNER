package com.biblioteca;

public class Identificacion {
    private Ejemplar ejemplar;
    private int pasillo;
    private int estante;
    private int fila;
    private int columna;
    private int posicion;

    public Identificacion(Ejemplar ejemplar, int pasillo, int estante, int fila, int columna, int posicion) {
        this.ejemplar = ejemplar;
        setPasillo(pasillo);
        setEstante(estante);
        setFila(fila);
        setColumna(columna);
        setPosicion(posicion);
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

    public void setPasillo(int pasillo) {
        if (pasillo > 0) {
            this.pasillo = pasillo;
        }
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        if (estante > 0) {
            this.estante = estante;
        }
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila > 0) {
            this.fila = fila;
        }
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        if (columna > 0) {
            this.columna = columna;
        }
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        if (posicion > 0) {
            this.posicion = posicion;
        }

    }

    public void cambiarUbicacion(int pasillo, int estante, int fila, int columna, int posicion) {
        setPasillo(pasillo);
        setEstante(estante);
        setFila(fila);
        setColumna(columna);
        setPosicion(posicion);
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