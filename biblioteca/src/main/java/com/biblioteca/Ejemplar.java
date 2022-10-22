package com.biblioteca;

import java.time.LocalDate;

public class Ejemplar {
    private Identificacion ID;
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
            String formaAquisicion, Identificacion ID, Obra obra) {
        this.ID = ID;
        this.observacionesGenerales = observacionesGenerales;
        this.codigoDeBarra = codigoDeBarra;
        this.fechaAdquisicion = fechaAdquisicion;
        this.formaAquisicion = formaAquisicion;
        this.fechaBaja = null;
        this.motivoBaja = null;
        this.disponible = true;
        this.obra = obra;
    }

    public void darEnPrestamo(Prestamo prestamo) {
        this.disponible = false;
        this.prestamo = prestamo;
    }

    public void devolverEjemplar() {
        this.disponible = true;
        this.prestamo = null;
    }

    public void reservarEjemplar(Reserva reserva){
        this.reserva = reserva;
        this.disponible = false;
    }

    public void sacarReserva() {
        this.reserva = null;
        this.disponible = true;
    }


    public Reserva getReserva() {
        return reserva;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public Identificacion getSeUbica() {
        return ID;
    }

    public void setSeUbica(Identificacion seUbica) {
        this.ID = seUbica;
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

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Obra getObra() {
        return obra;
    }

    public void darDeBaja(String motivoBaja) throws Exception {
        if (!this.disponible) {
            throw new Exception("El ejemplar no está disponible para darlo de baja");
        }
        this.disponible = false;
        this.fechaBaja = LocalDate.now();
        this.motivoBaja = motivoBaja;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ejemplar other = (Ejemplar) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        return true;
    }

    
}
