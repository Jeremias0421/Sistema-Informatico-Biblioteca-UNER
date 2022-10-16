package com.biblioteca;

import java.time.LocalDate;

/**
 * Esta clase {@code} Persona} representa una abstraccion de una persona
 * de la vida real.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public abstract class Persona {
    private final String nombre;
    private final String apellido;
    private final String sexo;
    private final LocalDate fechaNacimiento;
    private final String dni;
    private TipoDni tipoDni;

    /**
     * @param nombre
     * @param apellido
     * @param sexo
     * @param fechaNacimiento
     * @param dni
     * @param tipoDni
     * @throws IllegalArgumentException
     */
    public Persona(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni,
            TipoDni tipoDni) {

        if (nombre.matches("[A-Z][a-zA-Z]*")) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("Nombre invalido.");
        }

        if (apellido.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
            this.apellido = apellido;
        } else {
            throw new IllegalArgumentException("Apellido invalido.");
        }

        if (sexo.equals("Masculino") || sexo.equals("Femenino")) {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("Sexo invalido.");
        }

        if (fechaNacimiento.isAfter(LocalDate.of(1900, 1, 1)) && fechaNacimiento.isBefore(LocalDate.now())) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            throw new IllegalArgumentException("Fecha invalida");
        }

        if (dni.matches("\\d{8}")) {
            this.dni = dni;
        } else {
            throw new IllegalArgumentException("DNI invalido.");
        }

        this.tipoDni = tipoDni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public TipoDni getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(TipoDni tipoDni) {
        this.tipoDni = tipoDni;
    }
}
