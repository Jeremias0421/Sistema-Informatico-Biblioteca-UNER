package com.biblioteca;

/**
 * Esta clase representa una multa a aplicar sobre un lector
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Multa {
    private float monto;
    private int plazo;
    private Prestamo prestamo;
    private Lector multado;

    /**
     * @param monto
     * @param plazo
     * @param prestamo
     * @param multado
     */
    public Multa(float monto, int plazo, Prestamo prestamo, Lector multado) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto negativo");
        }

        if (plazo <= 0) {
            throw new IllegalArgumentException("Plazo negativo");
        }

        this.monto = monto;
        this.plazo = plazo;
        this.prestamo = prestamo;
        this.multado = multado;
    }

    /**
     * 
     * @return monto de la multa en pesos
     */
    public float getMonto() {
        return monto;
    }

    /**
     * 
     * @param monto
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * 
     * @return plazo de la multa
     */
    public int getPlazo() {
        return plazo;
    }

    /**
     * 
     * @param plazo
     */
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    /**
     * 
     * @return prestamo multado
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }

    /**
     * 
     * @return lector multado
     */
    public Lector getMultado() {
        return multado;
    }

}
