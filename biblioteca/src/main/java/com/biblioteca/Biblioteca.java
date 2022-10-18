package com.biblioteca;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {

    ArrayList<Ejemplar> ejemplaresDisponibles = null;
    ArrayList<Ejemplar> ejemplaresPrestados = null;
    ArrayList<Ejemplar> ejemplaresReservados = null;

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
        int plazo, ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles, ArrayList<Ejemplar> reservados) {

            for (Ejemplar ejemplar : ejemplares) {
                if (ejemplar.getReserva() != null) {
                    if (ejemplar.getReserva() != lector.getReserva()) { //Comprueba si fue reservado por el lector
                        //Si Paso la fecha de la reserva saca la reserva
                        if ((ejemplar.getReserva().getFecha()).isAfter(LocalDate.now())) {
                            reservaVencida(ejemplar, reservados, disponibles);
                        }else{
                            throw new IllegalArgumentException(ejemplar + " Reservado");
                        }
                    }else{
                        //Comprueba si fue reservado para el dia del prestamo
                        if ((ejemplar.getReserva().getFecha()).isBefore(LocalDate.now())) {
                            throw new IllegalArgumentException("Fecha de prestamo anticipada a la reservada");
                        }else{
                            levantarReserva(lector, reservados, disponibles);
                        }
                    }
                }
                if (!ejemplar.isDisponible()) {
                    throw new IllegalArgumentException(ejemplar + ": No disponible");
                }
            }

        if (lector.isMultado()) {
            throw new IllegalArgumentException("Lector multado"); 
        }
        Prestamo prestamo = new Prestamo(plazo, Lectura.DOMICILO,
        LocalDate.of(2022,10,15), funcionario, lector, ejemplares);
        funcionario.tomarPrestamo(prestamo);
        lector.pedirPrestamo(prestamo);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.setDisponible(false);
            ejemplar.setPrestamo(prestamo);
            prestados.add(ejemplar);
            disponibles.remove(ejemplar);
        }
    }

    public static void darPrestamoSala(Lector lector, ArrayList<Ejemplar> ejemplares, Funcionario funcionario, 
        ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles, ArrayList<Ejemplar> reservados) {

        //Itera cada ejemplar para comprobar si esta reservado
        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar.getReserva() != null) {
                if (ejemplar.getReserva() != lector.getReserva()) { //Comprueba si fue reservado por el lector
                    //Si Paso la fecha de la reserva saca la reserva
                    if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) > 0) {
                        reservaVencida(ejemplar, reservados, disponibles);
                    }else{
                        throw new IllegalArgumentException(ejemplar + " Reservado");
                    }
                }else{
                    //Comprueba si fue reservado para el dia del prestamo
                    if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) < 0) {
                        throw new IllegalArgumentException("Fecha de prestamo anticipada a la reservada");
                    }else{
                        levantarReserva(lector, reservados, disponibles);
                    }
                }
            }
            if (!ejemplar.isDisponible()) {
                throw new IllegalArgumentException(ejemplar + ": No disponible");
            }
        }
        
        if (lector.isMultado()) {
            throw new IllegalArgumentException("Lector multado");
        }

        Prestamo prestamo = new Prestamo(0, Lectura.SALA,
        LocalDate.now(), funcionario, lector, ejemplares);
        funcionario.tomarPrestamo(prestamo);
        lector.pedirPrestamo(prestamo);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.setDisponible(false);
            ejemplar.setPrestamo(prestamo);
            prestados.add(ejemplar);
            disponibles.remove(ejemplar);
        }
    }

    public static void devolverPrestamo(Prestamo prestamo, Funcionario funcionario,ArrayList<Ejemplar>prestados,
        ArrayList<Ejemplar> disponibles) {
        for (Ejemplar ejemplar : prestamo.getEjemplaresPrestados()) {
            prestados.remove(ejemplar);
            disponibles.add(ejemplar);
            ejemplar.setDisponible(true);
            ejemplar.setPrestamo(null);
        }
        Lector lector = prestamo.getLector();
        funcionario.tomarDevolucion(prestamo);
        if (Duration.between(prestamo.getFecha().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()>prestamo.getPlazo()) {
            lector.cargarMulta(new Multa(100f, 5, prestamo, lector));
        }
        lector.devolverPrestamo();
    }

    public static void reservarEjemplares(Lector lector, LocalDate fecha, ArrayList<Ejemplar> ejemplares, ArrayList<Ejemplar> disponibles,
        ArrayList<Ejemplar> reservados) {
        
        for (Ejemplar ejemplar : ejemplares) {
            if (!ejemplar.isDisponible()) {
                throw new IllegalArgumentException(ejemplar + "No disponible");
            }
        }

        if (lector.isMultado()) {
            throw new IllegalArgumentException("Lector Multado");
        }
        Reserva reserva = new Reserva(fecha, lector, ejemplares);
        lector.setReserva(reserva);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.setDisponible(false);
            ejemplar.setReserva(reserva);
            disponibles.remove(ejemplar);
            reservados.add(ejemplar);
        }
    }

    public static void levantarReserva(Lector lector, ArrayList<Ejemplar> reservados, ArrayList<Ejemplar> disponibles) {
        for (Ejemplar ejemplar : lector.getReserva().getEjemplares()) {
            disponibles.add(ejemplar);
            reservados.remove(ejemplar);
            ejemplar.setDisponible(true);
            ejemplar.setReserva(null);
        }
        lector.setReserva(null);
    }

    public static void reservaVencida(Ejemplar ejemplar, ArrayList<Ejemplar> reservados, ArrayList<Ejemplar> disponibles) {
        //Revoca la reserva de todos los ejemplares, Metodo llamado cuando supero la fecha de reserva
        if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) <= 0) {
            throw new IllegalArgumentException("Fecha de prestamo debe ser menor");
        }
        ejemplar.getReserva().getLector().setReserva(null);
        for (Ejemplar ejemplarRes : ejemplar.getReserva().getEjemplares()) {
            ejemplarRes.setReserva(null);
            ejemplarRes.setDisponible(true);
            reservados.remove(ejemplarRes);
            disponibles.add(ejemplarRes);
        }
    }
}
