package com.biblioteca;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {

    static ArrayList<Ejemplar> ejemplaresDisponibles = null;
    static ArrayList<Ejemplar> ejemplaresPrestados = null;

    public static void main(String[] args) {
        
    }

    /** */
    public static void obrasMasSolicitadasAlumnosYDocentes() {

    }

    /** */
    public static void obrasMasSolicitadasGeneral() {

    }

    /** */
    public static void ejemplaresDisponibles() {

    }

    /** */
    public static void obrasReservadas() {

    }

    /** */
    public static void listarMultasPorPeriodo() {

    }

    /**
     * 
     * @param editorial
     */
    public static void listarPorEditorial(String editorial) {

    }

    public static void darPrestamoDomicilio(Lector lector, ArrayList<Ejemplar> ejemplares, Funcionario funcionario, 
        int plazo, ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles) {

        for (Ejemplar ejemplar : ejemplares) {
            if (!ejemplar.isDisponible()) {
                throw new IllegalArgumentException(ejemplar + ": No disponible");
            }
        }

        if (!lector.isMultado()) {
            Prestamo prestamo = new Prestamo(plazo, Lectura.DOMICILO,
            LocalDate.of(2022,10,15), funcionario, lector, ejemplares);
            funcionario.tomarPrestamo(prestamo);
            lector.pedirPrestamo(prestamo);
            for (Ejemplar ejemplar : ejemplares) {
                ejemplar.setDisponible(false);
                prestados.add(ejemplar);
                disponibles.remove(ejemplar);
            }
        }else{
            throw new IllegalArgumentException("Lector multado");
        }
    }

    public static void darPrestamoSala(Lector lector, ArrayList<Ejemplar> ejemplares, Funcionario funcionario, 
        ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles) {

        for (Ejemplar ejemplar : ejemplares) {
            if (!ejemplar.isDisponible()) {
                throw new IllegalArgumentException(ejemplar + ": No disponible");
            }
        }
        
        if (!lector.isMultado()) {
            Prestamo prestamo = new Prestamo(0, Lectura.SALA,
            LocalDate.now(), funcionario, lector, ejemplares);
            funcionario.tomarPrestamo(prestamo);
            lector.pedirPrestamo(prestamo);
            for (Ejemplar ejemplar : ejemplares) {
                ejemplar.setDisponible(false);
                prestados.add(ejemplar);
                disponibles.remove(ejemplar);
            }
        }else{
            throw new IllegalArgumentException("Lector multado");
        }
    }

    public static void devolverPrestamo(Prestamo prestamo, Funcionario funcionario,ArrayList<Ejemplar>prestados,
        ArrayList<Ejemplar> disponibles) {
        for (Ejemplar ejemplar : prestamo.getEjemplaresPrestados()) {
            prestados.remove(ejemplar);
            disponibles.add(ejemplar);
            ejemplar.setDisponible(true);
        }
        Lector lector = prestamo.getLector();
        funcionario.tomarDevolucion(prestamo);
        if (Duration.between(prestamo.getFecha().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()>prestamo.getPlazo()) {
            lector.cargarMulta(new Multa(100f, 5, prestamo, lector));
        }
        lector.devolverPrestamo();
    }
}
