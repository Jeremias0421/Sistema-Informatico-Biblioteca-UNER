package com.biblioteca;

/**
 * Representa una identificacion unica para cada Ejemplar de la biblioteca
 *
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Identificacion {

    /** Ejemplar al cual pertenece la identificacion */
    private Ejemplar ejemplar;
    /** pasillo donde se ubica el ejemplar */
    private int pasillo;
    /** estante donde se ubica el ejemplar */
    private int estante;
    /** fila donde se ubica el ejemplar */
    private int fila;
    /** columna donde se ubica el ejemplar */
    private int columna;
    /** posicion donde se ubica el ejemplar */
    private int posicion;

    /**
     * Construye una nueva Identificacion
     * 
     * @param ejemplar ejemplar al cual pertenece la identificacion
     * @param pasillo  pasillo donde se encuentra el ejemplar
     * @param estante  estante donde se encuentra el ejemplar
     * @param fila     fila donde se encuentra el ejemplar
     * @param columna  columna donde se encuentra el ejemplar
     * @param posicion posicion donde se encuentra el ejemplar
     * @exception IllegalArgumentException si {@code} pasillo} es negativo o cero,
     *                                     {@code estante} es negativo o cero,
     *                                     {@code fila} es negativo o cero,
     *                                     {@code columna} es negativo o cero,
     *                                     {@code posicion} es negativo o cero
     */
    public Identificacion(Ejemplar ejemplar, int pasillo, int estante, int fila, int columna, int posicion) {
        if (pasillo <= 0) {
            throw new IllegalArgumentException("Pasillo debe ser mayor a 0");
        }
        if (estante <= 0) {
            throw new IllegalArgumentException("Estante debe ser mayor a 0");
        }
        if (fila <= 0) {
            throw new IllegalArgumentException("Fila debe ser mayor a 0");
        }
        if (columna <= 0) {
            throw new IllegalArgumentException("Columna debe ser mayor a 0");
        }
        if (posicion <= 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        this.ejemplar = ejemplar;
        this.pasillo = pasillo;
        this.estante = estante;
        this.fila = fila;
        this.columna = columna;
        this.posicion = posicion;
    }

    /**
     * Retorna el ejemplar perteneciente a la Identificacion
     * 
     * @return ejemplar
     */
    public Ejemplar getSeUbica() {
        return ejemplar;
    }

    /**
     * Permite modificar el ejemplar al cual pertenece la Identificacion
     * 
     * @param seUbica
     */
    public void setSeUbica(Ejemplar seUbica) {
        this.ejemplar = seUbica;
    }

    /**
     * 
     * @return pasillo donde se ubica el ejemplar
     */
    public int getPasillo() {
        return pasillo;
    }

    /**
     * 
     * @return estante donde se ubica el ejemplar
     */
    public int getEstante() {
        return estante;
    }

    /**
     * 
     * @return fila en donde esta ubicado el ejemplar
     */
    public int getFila() {
        return fila;
    }

    /**
     *
     * 
     * @return columna en donde se ubica el ejemplar
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @return posicion en donde esta ubicado del ejemplar
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Modifica el codigo de identifiacion del ejemplar
     * 
     * @param pasillo
     * @param estante
     * @param fila
     * @param columna
     * @param posicion
     * @exception IllegalArgumentException
     */
    public void cambiarID(int pasillo, int estante, int fila, int columna, int posicion) {
        if (pasillo <= 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (estante <= 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (fila <= 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (columna <= 0) {
            throw new IllegalArgumentException("Posicion debe ser mayor a 0");
        }
        if (posicion <= 0) {
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