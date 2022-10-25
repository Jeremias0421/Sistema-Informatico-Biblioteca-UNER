package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase Lector contiene campos y comportamientos especificos de un cliente
 * de la Biblioteca. No puede ser instanciada.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public abstract class Lector extends Persona {
    /** Correo electronico del Lector */
    private String correoElectronico;
    /** Numero de celular del Lector */
    private String nroCelular;
    /** Nacionalidad del Lector */
    private String nacionalidad;
    /** Domicilio del Lector */
    private String domicilio;
    /** Codigo postal del departamento o zona geografica donde reside el Lector */
    private int nroPostal;
    /** Departamento o ciudad donde reside el Lector */
    private String departamento;
    /** Localidad donde reside el Lector */
    private String localidad;
    /** Representa las multas acumuladas por un determinado Lector */
    private ArrayList<Multa> multasAcumuladas;
    /** Representa una Reserva de libros realizado por un determinado Lector */
    private Reserva reserva;
    /** Representa un Prestamo de libros realizado por un determinado Lector */
    private Prestamo prestamo;

    /**
     * 
     * @param nombre            nombre de pila
     * @param apellido          apellido
     * @param sexo              sexo
     * @param fechaNacimiento   fecha de nacimiento
     * @param dni               Documento Nacional de identidad
     * @param tipoDni           tipo de documento
     * @param correoElectronico correo electronico
     * @param nroCelular        numero de celular
     * @param nacionalidad      nacionalidad
     * @param domicilio         domicilio
     * @param nroPostal         codigo postal del lugar donde habita el Lector
     * @param departamento      departamento donde nacio el Lector
     * @param localidad         localidad donde nacio el Lector
     * @exception IllegalArgumentException si {@code correoElectronico} no
     *                                     correspone a un correo electronico
     *                                     estandar, {@code nroCelular} no es
     *                                     numerico, {@code nacionalidad},
     *                                     {@code departamento},
     *                                     {@code localidad} contiene numeros y/o
     *                                     caracteres
     *                                     especiales, o {@code nroPostal} es
     *                                     negativo
     * 
     */
    public Lector(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni, TipoDni tipoDni,
            String correoElectronico, String nroCelular, String nacionalidad, String domicilio, int nroPostal,
            String departamento, String localidad) {

        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni);

        if (!validarCorrero(correoElectronico))
            throw new IllegalArgumentException("Correo Invalido");

        if (!validarNroCelular(nroCelular))
            throw new IllegalArgumentException("Nro de celular invalido");

        if (!validarNacionalidad(nacionalidad))
            throw new IllegalArgumentException("Nacionalidad invalida");

        if (!validarDepartamento(departamento))
            throw new IllegalArgumentException("Departamento invalido");

        if (!validarLocalidad(localidad))
            throw new IllegalArgumentException("Localidad invalida");

        if (nroPostal < 0)
            throw new IllegalArgumentException("Nro postal invalido");

        this.correoElectronico = correoElectronico;
        this.nroCelular = nroCelular;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.nroCelular = nroCelular;
        this.nroPostal = nroPostal;
        this.departamento = departamento;
        this.localidad = localidad;
        this.multasAcumuladas = new ArrayList<>();
    }

    /**
     * Solicita un nuevo prestamo y lo almacena en prestamo
     * 
     * @param prestamo prestamo que el Lector pidio
     */
    public void pedirPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * Devuelve el prestamo solicitado.
     * Pone en null el atributo {@code prestamo}
     */
    public void devolverPrestamo() {
        this.prestamo = null;// Idea: retornar el prestamo en otra variable para poder manipularlo fuera
    }

    /**
     * Retorna el Prestamo que el lector solicito.
     * 
     * @return prestamo
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }

    /**
     * Retorna la reserva que hizo el Lector.
     * 
     * @return reserva
     */
    public Reserva getReserva() {
        return reserva;
    }

    /** */
    public void consultarLibros() {

    }

    /**
     * Carga la multa al registro de multas acumuladas.
     * 
     * @param multa
     */
    public void cargarMulta(Multa multa) {
        multasAcumuladas.add(multa);
    }

    /** */
    public void levantarMulta(Multa multa) {

    }

    /**
     * Saber si el lector esta multado.
     * 
     * @return {@code true} si el lector esta multado; de lo contrario {@code false}
     */
    public boolean isMultado() {
        return multasAcumuladas.size() > 0;
    }

    /**
     * Guarda un nueva Reserva hecha por un Lector.
     * 
     * @param reserva reserva pedida.
     */
    public void reservarEjemplares(Reserva reserva) {
        this.reserva = reserva;
    }

    /**
     * @return correo electronico del Lector.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Permite modificar el correo electronico.
     * 
     * @param correoElectronico nuevo correo electronico.
     */
    public void setCorreoElectronico(String correoElectronico) {
        if (validarCorrero(correoElectronico)) {
            this.correoElectronico = correoElectronico;
        }
    }

    /**
     * @return el numero de celular del Lector.
     */
    public String getNroCelular() {
        return nroCelular;
    }

    /**
     * Permite modificar el numer de celular.
     * 
     * @param nroCelular nuevo numero de celular
     */
    public void setNroCelular(String nroCelular) {
        if (validarNroCelular(nroCelular))
            this.nroCelular = nroCelular;
        else
            throw new IllegalArgumentException("Nro de celular invalido");

    }

    /**
     * @return la nacionalidad del Lector.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Permite modificar la nacionalidad.
     * 
     * @param nacionalidad
     */
    public void setNacionalidad(String nacionalidad) {
        if (validarNacionalidad(nacionalidad))
            this.nacionalidad = nacionalidad;
        else
            throw new IllegalArgumentException("Nacionalidad invalida");
    }

    /**
     * 
     * @return
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * 
     * @param domicilio
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * 
     * @return
     */
    public int getNroPostal() {
        return nroPostal;
    }

    /**
     * 
     * @param nroPostal
     * @exception IllegalArgumentException
     */
    public void setNroPostal(int nroPostal) {
        if (nroPostal > 0)
            this.nroPostal = nroPostal;
        else
            throw new IllegalArgumentException("Nro postal invalido");
    }

    /**
     * 
     * @return
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * 
     * @param departamento
     * @exception IllegalArgumentException
     */
    public void setDepartamento(String departamento) {
        if (validarDepartamento(departamento))
            this.departamento = departamento;
        else
            throw new IllegalArgumentException("Departamento invalido");

    }

    /**
     * 
     * @return
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * 
     * @param localidad
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * 
     * @param correo
     * @return
     */
    private boolean validarCorrero(String correo) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        return correo.matches(regexPattern);
    }

    /**
     * 
     * @param celular numero a validar.
     * @return {@code true} si el numero de celular contiene diez digitos; de
     *         cualquier otra forma {@code false}
     */
    private boolean validarNroCelular(String celular) {
        return celular.matches("^\\d{10}$");
    }

    /**
     * 
     * @param nacionalidad
     * @return {@code true} si la nacionalidad no contiene numero y/o caracteres
     *         especiales; de cualquier otra forma {@code false}
     */
    private boolean validarNacionalidad(String nacionalidad) {
        return nacionalidad.matches("[A-Z][a-zA-Z]*");
    }

    /**
     * 
     * @param departamento
     * @return {@code true} si departamento contiene solo caracteres del alfabeto
     *         castellano; de cualquier otra forma {@code false}
     */
    private boolean validarDepartamento(String departamento) {
        return departamento.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    /**
     * Valida que la localidad no sea
     * 
     * @param localidad localidad a validar.
     * @return {@code true} si localidad contiene solo caracteres del alfabeto
     *         castellano; de cualquier otra forma {@code false}
     */
    private boolean validarLocalidad(String localidad) {
        return localidad.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    /**
     * Formatea el objeto para guardarlo en .csv
     * 
     * @return 
     */
    public String toCSV() {
        return this.getClass() + "," + super.toCSV() + correoElectronico + "," + nroCelular + ","
                + nacionalidad + "," + domicilio + "," + nroPostal + ","
                + departamento + "," + localidad + "," + multasAcumuladas + ","
                + reserva + "," + prestamo;
    }

    
}