package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public Lector(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, int dni, String tipoDni,
            String correoElectronico, String nroCelular, String nacionalidad, String domicilio, int nroPostal,
            String departamento, String localidad) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni);
        this.correoElectronico = correoElectronico;
        this.nroCelular = nroCelular;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        setNroPostal(nroPostal);
        this.departamento = departamento;
        this.localidad = localidad;
        this.multasAcumuladas = new ArrayList<>();
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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
