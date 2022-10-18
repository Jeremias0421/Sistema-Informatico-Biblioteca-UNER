package com.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Prestamo {
    private int plazo;
    private Lectura tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private LocalDate fechaDevolucion;
    private Funcionario funcionario;
    private ArrayList<Multa> multas;
    private Lector lector;
    private ArrayList<Ejemplar> ejemplaresPrestados;

    public Prestamo(int plazo, Lectura tipo,LocalDate fechaDevolucion,Funcionario funcionario, Lector lector, ArrayList<Ejemplar> ejemplares) {
        this.plazo = plazo;
        this.tipo = tipo;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.fechaDevolucion = fechaDevolucion;
        this.funcionario = funcionario;
        this.multas = new ArrayList<>();
        this.lector = lector;
        this.ejemplaresPrestados = ejemplares;
    }

    public ArrayList<Ejemplar> getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }
    
    public Lector getLector() {
        return lector;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public int getPlazo() {
        return plazo;
    }

    public Lectura getTipo() {
        return tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }    

}
