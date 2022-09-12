package com.biblioteca;

public class Multa {
    private float monto;
    private int plazo;

    public Multa(float monto, int plazo) {
        this.monto = monto;
        this.plazo = plazo;
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

    

}
