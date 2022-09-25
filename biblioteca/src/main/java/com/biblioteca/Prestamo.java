package com.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Prestamo implements Comparable<Prestamo> {
    private int plazo;
    private Lectura tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private LocalDate fechaDevolucion;
    private Funcionario funcionario;
    private ArrayList<Multa> multas;
    private Lector lector;
    private ArrayList<Ejemplar> ejemplaresPrestados = new ArrayList<>();

    public Prestamo(int plazo, Lectura tipo, LocalDate fecha, LocalTime hora, LocalDate fechaDevolucion,Funcionario funcionario, Lector lector, ArrayList<Ejemplar> ejemplares) {
        this.plazo = plazo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaDevolucion = fechaDevolucion;
        this.funcionario = funcionario;
        this.multas = new ArrayList<>();
        this.lector = lector;
        this.ejemplaresPrestados = ejemplares;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prestamo other = (Prestamo) obj;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (fechaDevolucion == null) {
            if (other.fechaDevolucion != null)
                return false;
        } else if (!fechaDevolucion.equals(other.fechaDevolucion))
            return false;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        if (plazo != other.plazo)
            return false;
        if (tipo != other.tipo)
            return false;
        return true;
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

    @Override
    public int compareTo(Prestamo o) {
        // TODO Auto-generated method stub
        return 0;
    }

    

}
