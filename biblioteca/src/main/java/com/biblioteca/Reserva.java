package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
    private LocalDate fecha;
    private Lector lector;
    private ArrayList<Ejemplar> ejemplares = new ArrayList<>();

    public Reserva(LocalDate fecha, Lector lector, ArrayList<Ejemplar> ejemplares) {
        this.fecha = fecha;
        this.lector = lector;
        this.ejemplares = ejemplares;
    }

    public Reserva(LocalDate fecha,Lector lector, Ejemplar ejemplar) {
        this.fecha = fecha;
        this.lector = lector;
        this.ejemplares.add(ejemplar);
    }

    public Lector getLector() {
        return lector;
    }

    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
