package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Lector extends Persona {
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
        setCorreoElectronico(correoElectronico);
        this.nroCelular = nroCelular;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        setNroPostal(nroPostal);
        this.departamento = departamento;
        this.localidad = localidad;
        this.multasAcumuladas = new ArrayList<>();
    }

    public void pedirPrestamo() {

    }

    public void devolverPrestamo() {

    }

    public void consultarLibros() {

    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if (correoElectronico.matches(regexPattern))
            this.correoElectronico = correoElectronico;
        else
            throw new Error("Correo invalido");

        // if (evaluarRegex(correoElectronico, regexPattern))
        // this.correoElectronico = correoElectronico;
        // else
        // throw new Error("Correo invalido");

    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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
        if (nroPostal > 0) {
            this.nroPostal = nroPostal;
        } else {

        }
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

}
