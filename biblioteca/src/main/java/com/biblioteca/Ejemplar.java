package com.biblioteca;

import java.time.LocalDate;

public class Ejemplar {
    private Identificacion seUbica;
    private String observacionesGenerales;
    private String codigoDeBarra; // a revisar como tratar el codigo de barra
    private LocalDate fechaAdquisicion;
    private String formaAquisicion;
    private LocalDate fechaBaja;
    private String motivoBaja;
    private boolean disponible;
    private Obra obra;
    private Reserva reserva;
    private Prestamo prestamo;

    public Ejemplar(String observacionesGenerales, String codigoDeBarra, LocalDate fechaAdquisicion,
            String formaAquisicion, Identificacion seUbica, Obra obra) {
        this.seUbica = seUbica;
        this.observacionesGenerales = observacionesGenerales;
        this.codigoDeBarra = codigoDeBarra;
        this.fechaAdquisicion = fechaAdquisicion;
        this.formaAquisicion = formaAquisicion;
        this.fechaBaja = null;
        this.motivoBaja = null;
        this.disponible = true;
        this.obra = obra;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Identificacion getSeUbica() {
        return seUbica;
    }

    public void setSeUbica(Identificacion seUbica) {
        this.seUbica = seUbica;
    }

    public String getObservacionesGenerales() {
        return observacionesGenerales;
    }

    public void setObservacionesGenerales(String observacionesGenerales) {
        this.observacionesGenerales = observacionesGenerales;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getFormaAquisicion() {
        return formaAquisicion;
    }

    public void setFormaAquisicion(String formaAquisicion) {
        this.formaAquisicion = formaAquisicion;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Obra getObra() {
        return obra;
    }

    public void darDeBaja(String motivoBaja) { // Posiblemente mal
        this.disponible = false;
        this.fechaBaja = LocalDate.now();
        this.motivoBaja = motivoBaja;
    }

}
