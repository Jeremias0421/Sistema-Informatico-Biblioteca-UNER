package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase representa una Reserva de ejemplares realizada por un Lector en un
 * momento determinado.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Reserva {
    /** La fecha en la que se hizo una Reserva */
    private LocalDate fecha;
    /** Lector quien realizo la Reserva */
    private Lector lector;
    /** Lista de ejemplares que se reservaron */
    private ArrayList<Ejemplar> ejemplares;

    /**
     * Instancia una nueva Reserva
     * 
     * @param fecha      fecha de la reserva
     * @param lector     lector quien reserva
     * @param ejemplares ejemplares reservados
     * @exception IllegalArgumentException si la fecha de la reserva es anterior al
     *                                     dia actual
     */
    public Reserva(LocalDate fecha, Lector lector, ArrayList<Ejemplar> ejemplares) {
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha anterior al dia actual");
        }
        this.fecha = fecha;
        this.lector = lector;
        this.ejemplares = ejemplares;
    }

    /**
     * 
     * @return Lector que hizo la reserva
     */
    public Lector getLector() {
        return lector;
    }

    /**
     * 
     * @return Lista de ejemplares que se reservaron
     */
    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    /**
     * 
     * @return fecha en la que se hizo la reserva
     */
    public LocalDate getFecha() {
        return fecha;
    }

    public String toCSV() {
        return fecha + "," + lector.getDni();
    }

    public void setReservaCSV(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void linkEjemplarCSV(Ejemplar ejemplar) {
        this.ejemplares.add(ejemplar);
    }
    


}
