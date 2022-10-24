package com.biblioteca;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa a un sistema de Biblioteca.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Biblioteca {

    static ArrayList<Ejemplar> ejemplaresDisponibles = new ArrayList<>();
    static ArrayList<Ejemplar> ejemplaresPrestados = new ArrayList<>();
    static ArrayList<Ejemplar> ejemplaresReservados = new ArrayList<>();
    static ArrayList<Obra> listadoDeObras = new ArrayList<Obra>();
    static ArrayList<Lector> clientes = new ArrayList<>();

    public ArrayList<Lector> lectoresConObrasNoDevueltas() {
        ArrayList<Lector> listado = new ArrayList<>();

        for (Lector lector : clientes) {
            if (lector.getPrestamo() != null) {
                lector.getPrestamo().getPlazo();

                listado.add(lector);
            }
        }
        return listado;
    }

    public static void obrasMasSolicitadasAlumnosYDocentes() {
        
    }

    public static void obrasMasSolicitadasGeneral() {

    }

    public static ArrayList<Ejemplar> ejemplaresDisponiblesSegunTematica(String areaReferencia) {
        ArrayList<Ejemplar> lista = new ArrayList<>();

        for (Obra obra : listadoDeObras) {

            if (obra.getAreaTematica().equals(areaReferencia)) {

                for (Ejemplar ejemplar : obra.getEjemplares()) {
                    if (ejemplar.isDisponible()) {
                        lista.add(ejemplar);
                    }
                }
            }
        }

        return lista;
    }

    public static ArrayList<Ejemplar> obrasReservadasPorFecha(LocalDate fecha) {
        ArrayList<Ejemplar> e = new ArrayList<>();

        for (Ejemplar ejemplar : ejemplaresReservados) {

            LocalDate f = ejemplar.getReserva().getFecha();
            if (f.isAfter(fecha)) {
                e.add(ejemplar);
            }
        }
        return e;
    }

    public static void listarMultasPorPeriodo() {

    }

    public static void listarPorEditorial(String editorial) {

    }

    public static void darPrestamoDomicilio(Lector lector, ArrayList<Ejemplar> ejemplares, Funcionario funcionario,
            int plazo, ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles, ArrayList<Ejemplar> reservados) {

        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar.getReserva() != null) {
                if (ejemplar.getReserva() != lector.getReserva()) { // Comprueba si fue reservado por el lector
                    // Si Paso la fecha de la reserva saca la reserva
                    if ((ejemplar.getReserva().getFecha()).isBefore(LocalDate.now())) {
                        reservaVencida(ejemplar, reservados, disponibles);
                    } else {
                        throw new IllegalArgumentException(ejemplar + " Reservado");
                    }
                } else {
                    // Comprueba si fue reservado para el dia del prestamo
                    if ((ejemplar.getReserva().getFecha()).isBefore(LocalDate.now())) {
                        throw new IllegalArgumentException("Fecha de prestamo anticipada a la reservada");
                    } else {
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
        Prestamo prestamo = new Prestamo(plazo, Lectura.DOMICILIO,
                LocalDate.of(2022, 10, 15), funcionario, lector, ejemplares);
        funcionario.tomarPrestamo(prestamo);
        lector.pedirPrestamo(prestamo);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.darEnPrestamo(prestamo);
            prestados.add(ejemplar);
            disponibles.remove(ejemplar);
        }
    }

    public static void darPrestamoSala(Lector lector, ArrayList<Ejemplar> ejemplares, Funcionario funcionario,
            ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles, ArrayList<Ejemplar> reservados) {

        // Itera cada ejemplar para comprobar si esta reservado
        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar.getReserva() != null) {
                if (ejemplar.getReserva() != lector.getReserva()) { // Comprueba si fue reservado por el lector
                    // Si Paso la fecha de la reserva saca la reserva
                    if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) > 0) {
                        reservaVencida(ejemplar, reservados, disponibles);
                    } else {
                        throw new IllegalArgumentException(ejemplar + " Reservado");
                    }
                } else {
                    // Comprueba si fue reservado para el dia del prestamo
                    if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) < 0) {
                        throw new IllegalArgumentException("Fecha de prestamo anticipada a la reservada");
                    } else {
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
            ejemplar.darEnPrestamo(prestamo);
            prestados.add(ejemplar);
            disponibles.remove(ejemplar);
        }
    }

    public static void devolverPrestamo(Prestamo prestamo, Funcionario funcionario, ArrayList<Ejemplar> prestados,
            ArrayList<Ejemplar> disponibles) {
        for (Ejemplar ejemplar : prestamo.getEjemplaresPrestados()) {
            prestados.remove(ejemplar);
            disponibles.add(ejemplar);
            ejemplar.devolverEjemplar();
        }
        Lector lector = prestamo.getLector();
        funcionario.tomarDevolucion(prestamo);
        if (Duration.between(prestamo.getFecha().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays() > prestamo
                .getPlazo()) {
            lector.cargarMulta(new Multa(100f, 5, prestamo, lector));
        }
        lector.devolverPrestamo();
    }

    public static void reservarEjemplares(Lector lector, LocalDate fecha, ArrayList<Ejemplar> ejemplares,
            ArrayList<Ejemplar> disponibles,
            ArrayList<Ejemplar> reservados) {

        for (Ejemplar ejemplar : ejemplares) {
            if (!ejemplar.isDisponible()) {
                if (ejemplar.getFechaBaja() != null || ejemplar.getReserva() != null) {
                    throw new IllegalArgumentException(ejemplar + "No disponible");
                }
            }
        }

        if (lector.isMultado()) {
            throw new IllegalArgumentException("Lector Multado");
        }
        Reserva reserva = new Reserva(fecha, lector, ejemplares);
        lector.reservarEjemplares(reserva);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.reservarEjemplar(reserva);
            disponibles.remove(ejemplar);
            reservados.add(ejemplar);
        }
    }

    public static void levantarReserva(Lector lector, ArrayList<Ejemplar> reservados, ArrayList<Ejemplar> disponibles) {
        for (Ejemplar ejemplar : lector.getReserva().getEjemplares()) {
            disponibles.add(ejemplar);
            reservados.remove(ejemplar);
            ejemplar.sacarReserva();
        }
        lector.reservarEjemplares(null);
    }

    public static void reservaVencida(Ejemplar ejemplar, ArrayList<Ejemplar> reservados,
            ArrayList<Ejemplar> disponibles) {
        // Revoca la reserva de todos los ejemplares, Metodo llamado cuando supero la
        // fecha de reserva
        if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) <= 0) {
            throw new IllegalArgumentException("Fecha de prestamo debe ser menor");
        }
        ejemplar.getReserva().getLector().reservarEjemplares(null);
        for (Ejemplar ejemplarRes : ejemplar.getReserva().getEjemplares()) {
            ejemplar.sacarReserva();
            reservados.remove(ejemplarRes);
            disponibles.add(ejemplarRes);
        }
    }
}
