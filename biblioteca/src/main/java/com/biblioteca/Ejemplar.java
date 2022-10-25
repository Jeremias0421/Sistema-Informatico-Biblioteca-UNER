package com.biblioteca;

import java.time.LocalDate;

/**
 * Clase que representa a un Ejemplar en distintos formatos dentro de la
 * Biblioteca.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Ejemplar {

    /** Codigo unico que identifica a cada Ejemplar dentro de la Biblioteca. */
    private Identificacion ID;

    /** Observaciones acerca del Ejemplar incluida por los empleados. */
    private String observacionesGenerales;

    /** Codigo numerico que identifica a un Ejemplar. */
    private String codigoDeBarra;

    /** Fecha en la cual fue adquirido el Ejemplar. */
    private LocalDate fechaAdquisicion;

    /** Forma en que fue adquirido el Ejemplar. */
    private String formaAquisicion;

    /** Fecha en la cual se dio de baja el Ejemplar. */
    private LocalDate fechaBaja;

    /** Motivo por el cual se dio de baja el Ejemplar. */
    private String motivoBaja;

    /** Indica si el Ejemplar esta disponible para ser prestado. */
    private boolean disponible;

    /** {@code Obra} al cual pertenece el Ejemplar. */
    private Obra obra;

    /**
     * Reserva en donde el Ejemplar se encuentra.
     * 
     * @see Reserva
     */
    private Reserva reserva;

    /**
     * Indica en que {@code Prestamo} se encuentra el Ejemplar.
     * 
     * @see Prestamo
     */
    private Prestamo prestamo;

    /**
     * Crea una nueva instancia de Ejemplar.
     * 
     * @param observacionesGenerales
     *                               Observaciones generales acerca del Ejemplar
     * 
     * @param codigoDeBarra
     *                               Codigo de barra
     * 
     * @param fechaAdquisicion
     *                               Fecha en la que fue adquirido
     * 
     * @param formaAquisicion
     *                               Forma en la que fue adquirido
     * 
     * @param ID
     *                               Identificacion unica
     * 
     * @param obra
     *                               Obra al cual pertenece
     */
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

    /**
     * Presta un Ejemplar a un determinado {@code Lector}
     * 
     * @param prestamo
     */
    public void darEnPrestamo(Prestamo prestamo) {
        this.disponible = false;
        this.prestamo = prestamo;
    }

    /**
     * Devuelve un Ejemplar a la Biblioteca y lo deja disponible para ser prestado
     * nuevamente.
     */
    public void devolverEjemplar() {
        this.disponible = true;
        this.prestamo = null;
    }

    /**
     * Deja reservado un Ejemplar permitiendo que nadie mas pueda pedirlo en
     * prestamo.
     * 
     * @param reserva nueva reserva del Lector.
     */
    public void reservarEjemplar(Reserva reserva) {
        this.reserva = reserva;
        this.disponible = false;
    }

    /**
     * Saca de una Reserva al Ejemplar.
     */
    public void sacarReserva() {
        this.reserva = null;
        this.disponible = true;
    }

    /**
     * 
     * @return reserva en la que se encuentra el Ejemplar
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * 
     * @return prestamo en el que se encuentra el Ejemplar.
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }

    /**
     * 
     * @return identificacion unica del Ejemplar.
     */
    public Identificacion getSeUbica() {
        return ID;
    }

    /**
     * Permite modificar la ubicacion del ejemplar dentro de la bilioteca.
     * 
     * @param seUbica nueva ubicacion
     */
    public void setSeUbica(Identificacion seUbica) {
        this.ID = seUbica;
    }

    /**
     * 
     * @return observaciones generales acerca del Ejemplar.
     */
    public String getObservacionesGenerales() {
        return observacionesGenerales;
    }

    /**
     * Permite modificar las observaciones acerca del Ejemplar.
     * @param observacionesGenerales
     */
    public void setObservacionesGenerales(String observacionesGenerales) {
        this.observacionesGenerales = observacionesGenerales;
    }

    /**
     * 
     * @return codigo de barra.
     */
    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    /**
     * 
     * @param codigoDeBarra
     */
    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    /**
     * 
     * @return fecha en la que fue adquirido el Ejemplar.
     */
    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    /**
     * 
     * @param fechaAdquisicion 
     */
    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    /**
     * 
     * @return forma en la que fue adquirido este Ejemplar.
     */
    public String getFormaAquisicion() {
        return formaAquisicion;
    }

    /**
     * 
     * @param formaAquisicion
     */
    public void setFormaAquisicion(String formaAquisicion) {
        this.formaAquisicion = formaAquisicion;
    }

    /**
     * 
     * @return fecha en la que fue dado de baja.
     */
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    /**
     * 
     * @return motivo por el cuel fue dado de baja.
     */
    public String getMotivoBaja() {
        return motivoBaja;
    }

    /**
     * Indica si el Ejemplar se encuantra disponible.
     * 
     * @return {@code true} si el Ejemplar esta disponible para ser prestado; de lo
     *         contrario {@code false}
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * 
     * @return Obra a la que pertenece este Ejemplar.
     */
    public Obra getObra() {
        return obra;
    }

    /**
     * @param obra
     */
    public void setObra(Obra obra) {
        this.obra = obra;
    }

    /**
     * Dar de baja un Ejemplar permitiendo ser imposibilitado para ser prestado de
     * nuevo.
     * 
     * @param motivoBaja motivo por el cual se lo da de baja.
     * @throws Exception si el ejemplar no esta disponible.
     */
    public void darDeBaja(String motivoBaja) throws Exception {
        if (!this.disponible) {
            throw new Exception("El ejemplar no está disponible para darlo de baja");
        }
        this.disponible = false;
        this.fechaBaja = LocalDate.now();
        this.motivoBaja = motivoBaja;
    }

    public void setBajaCSV(LocalDate fechaBajaDate, String motivoBaja, boolean disponible){
        this.fechaBaja = fechaBajaDate;
        this.motivoBaja = motivoBaja;
        this.disponible = disponible;
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

    public String toCSV() {
        if(reserva != null){
            return ID.toCSV() + "," + observacionesGenerales + ","
                + codigoDeBarra + "," + fechaAdquisicion + "," + formaAquisicion
                + "," + fechaBaja + "," + motivoBaja + "," + disponible + ","
                + obra + "," + obra.getIsbn() + reserva.toCSV() + "\n";
        }
        if (prestamo != null) {
            return ID.toCSV() + "," + observacionesGenerales + ","
            + codigoDeBarra + "," + fechaAdquisicion + "," + formaAquisicion
            + "," + fechaBaja + "," + motivoBaja + "," + disponible + ","
            + obra + "," + obra.getIsbn() + prestamo.toCSV() + "\n";
        }
        return ID.toCSV() + "," + observacionesGenerales + ","
        + codigoDeBarra + "," + fechaAdquisicion + "," + formaAquisicion
        + "," + fechaBaja + "," + motivoBaja + "," + disponible + ","
        + obra + "," + obra.getIsbn() + "\n";
    }

    
}