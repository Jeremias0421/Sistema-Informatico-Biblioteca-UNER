package com.biblioteca;

public class Multa {
    private float monto;
    private int plazo;
    private Prestamo prestamo;
    private Lector multado;

    public Multa(float monto, int plazo, Prestamo prestamo, Lector multado) {
        this.monto = monto;
        this.plazo = plazo;
        this.prestamo = prestamo;
        this.multado = multado;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    

}
