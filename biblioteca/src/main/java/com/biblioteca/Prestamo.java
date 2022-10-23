package com.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Esta clase representa una transaccion entre un Lector y la Biblioteca.
 * Contiene atributos y metodos para representar un Prestamo y una devolucion
 * del mismo.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Prestamo {

    /** Plazo de dias del Prestamo. */
    private int plazo;
    /**
     * Tipo de Prestamo realizado.
     * 
     * @see Lectura
     */
    private Lectura tipo;

    /** Fecha en la que se realizo el Prestamo. */
    private LocalDate fecha;

    /** Hora en la que se realizo el Prestamo. */
    private LocalTime hora;

    /** Fecha en la cual debe ser devuelto el Prestamo. */
    private LocalDate fechaDevolucion;

    /** Funcionario que dio el Prestamo */
    private Funcionario funcionario;

    /** Lista de multas aplicadas al no devolver a tiempo. */
    private ArrayList<Multa> multas;

    /** Lector que pidio el Prestamo. */
    private Lector lector;
    
    /** Ejemplares que fueron prestados. */
    private ArrayList<Ejemplar> ejemplaresPrestados;

    /**
     * Instancia un nuevo Prestamo.
     * 
     * @param plazo           plazo del Prestamo.
     * @param tipo            tipo de Prestamo dado.
     * @param fechaDevolucion fecha en la que debe ser devuelto.
     * @param funcionario     funcionario que otorga el Prestamo.
     * @param lector          lector que pide el Prestamo.
     * @param ejemplares      ejemplares que el Lector pide prestado.
     */
    public Prestamo(int plazo, Lectura tipo, LocalDate fechaDevolucion, Funcionario funcionario, Lector lector,
            ArrayList<Ejemplar> ejemplares) {
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

    /**
     * 
     * @return ejemplares que fueron prestados.
     */
    public ArrayList<Ejemplar> getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    /**
     * 
     * @return lector que pidio el Prestamo.
     */
    public Lector getLector() {
        return lector;
    }

    /**
     * 
     * @return listado de las multas aplicadas a un Prestamo en particular
     */
    public ArrayList<Multa> getMultas() {
        return multas;
    }

    /**
     * 
     * @return funcionario que otorgo el Prestamo
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * 
     * @return plazo de dias que se otorgo con el Prestamo
     */
    public int getPlazo() {
        return plazo;
    }

    /**
     * 
     * @return tipo de Prestamo otorgado
     */
    public Lectura getTipo() {
        return tipo;
    }

    /**
     * 
     * @return fecha en la cual fue otorgado el Prestamo
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * 
     * @return hora en la cual fue otorgado el Prestamo
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * 
     * @return fecha en la cual debe ser devuelto el Prestamo
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Permite modificar la fecha de devolucion.
     * 
     * @param fechaDevolucion nueva fecha de devolucion
     * @exception IllegalArgumentException si la nueva fecha de devolucion es
     *                                     anterior a la fecha en la que se otorgo
     *                                     el Prestamo.
     */
    public void setFechaDevolucion(LocalDate nuevaFecha) {
        if (nuevaFecha.isBefore(this.fecha)) {
            throw new IllegalArgumentException("Fecha anterior a la fecha del Prestamo");
        }
        this.fechaDevolucion = nuevaFecha;
    }

}