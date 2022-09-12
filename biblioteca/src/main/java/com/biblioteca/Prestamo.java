package com.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;

public class Prestamo {
    private int plazo;
    private Lectura tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private LocalDate fechaDevolucion;

    public Prestamo(int plazo, Lectura tipo, LocalDate fecha, LocalTime hora, LocalDate fechaDevolucion) {
        this.plazo = plazo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Lectura getTipo() {
        return tipo;
    }

    public void setTipo(Lectura tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    

}
