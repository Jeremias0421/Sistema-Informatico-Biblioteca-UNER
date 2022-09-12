package com.biblioteca;

import java.time.LocalDate;

public class Reserva {
    private LocalDate fecha;

    public Reserva(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
