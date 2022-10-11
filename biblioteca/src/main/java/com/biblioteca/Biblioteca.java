package com.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
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

        Prestamo prestamo = new Prestamo(plazo, Lectura.DOMICILO, LocalDate.now(), LocalTime.now(),
            LocalDate.of(2022,10,15), funcionario, lector, ejemplares);
        funcionario.tomarPrestamo(prestamo);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.setDisponible(false);
            prestados.add(ejemplar);
            disponibles.remove(ejemplar);
        }
    }

    public static void darPrestamoSala(Lector lector, ArrayList<Ejemplar> ejemplares, Funcionario funcionario, 
        ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles) {

        Prestamo prestamo = new Prestamo(0, Lectura.SALA, LocalDate.now(), LocalTime.now(),
            LocalDate.now(), funcionario, lector, ejemplares);
        funcionario.tomarPrestamo(prestamo);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.setDisponible(false);
            prestados.add(ejemplar);
            disponibles.remove(ejemplar);
        }
    }
}
