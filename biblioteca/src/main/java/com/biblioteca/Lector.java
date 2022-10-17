package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Lector extends Persona {
    private String correoElectronico;
    private String nroCelular;
    private String nacionalidad;
    private String domicilio;
    private int nroPostal;
    private String departamento;
    private String localidad;
    private ArrayList<Multa> multasAcumuladas;
    private Reserva reserva;
    private Prestamo prestamo;

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

    public void pedirPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public void devolverPrestamo() {
        this.prestamo = null;// Idea: retornar el prestamo en otra variable para poder manipularlo fuera
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void consultarLibros() {

    }

    public void cargarMulta(Multa multa) {
        multasAcumuladas.add(multa);
    }

    public void levantarMulta() {
        // Completar
    }

    public boolean isMultado() {
        return multasAcumuladas.size() > 0;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        if (validarCorrero(correoElectronico)) {
            this.correoElectronico = correoElectronico;
        }
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        if (validarNroCelular(nroCelular))
            this.nroCelular = nroCelular;
        else
            throw new IllegalArgumentException("Nro de celular invalido");

    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        if (validarNacionalidad(nacionalidad))
            this.nacionalidad = nacionalidad;
        else
            throw new IllegalArgumentException("Nacionalidad invalida");
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getNroPostal() {
        return nroPostal;
    }

    public void setNroPostal(int nroPostal) {
        if (nroPostal > 0)
            this.nroPostal = nroPostal;
        else
            throw new IllegalArgumentException("Nro postal invalido");
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (validarDepartamento(departamento))
            this.departamento = departamento;
        else
            throw new IllegalArgumentException("Departamento invalido");

    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    private boolean validarCorrero(String correo) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        return correo.matches(regexPattern);
    }

    private boolean validarNroCelular(String celular) {
        return celular.matches("^\\d{10}$");
    }

    private boolean validarNacionalidad(String nacionalidad) {
        return nacionalidad.matches("[A-Z][a-zA-Z]*");
    }

    private boolean validarDepartamento(String departamento) {
        return departamento.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    private boolean validarLocalidad(String localidad) {
        return localidad.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }
}