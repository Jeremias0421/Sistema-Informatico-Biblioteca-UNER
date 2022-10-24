package com.biblioteca;

import java.time.LocalDate;

/**
 * Persona es la clase base en la jerarquia de lectores de la biblioteca. Esta
 * clase representa una abstraccion de una persona de la vida real.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public abstract class Persona {
    /** Primer nombre de la persona */
    private final String nombre;
    /** Apellido paterno de la persona */
    private final String apellido;
    /** Sexo de la persona especificado en el DNI */
    private final String sexo;
    /** Fecha de nacimiento de la persona */
    private final LocalDate fechaNacimiento;
    /** Documento Nacional de Identidad de la persona */
    private final String dni;
    /** Tipo de documento de la persona */
    private TipoDni tipoDni;

    /**
     * @param nombre          el nombre de la persona
     * @param apellido        el apellido de la persona
     * @param sexo            el sexo de la persona
     * @param fechaNacimiento la fecha de nacimiento de la persona
     * @param dni             el numero de documento de la persona
     * @param tipoDni         el tipo de documento de la persona
     * @throws IllegalArgumentException si recibe como parametros valores invalidos
     * 
     */
    public Persona(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni,
            TipoDni tipoDni) {

        if (!validarNombre(nombre)) {
            throw new IllegalArgumentException("Nombre invalido.");
        }

        if (!validarApellido(apellido)) {
            throw new IllegalArgumentException("Apellido invalido.");
        }

        if (!validarSexo(sexo)) {
            throw new IllegalArgumentException("Sexo invalido.");
        }

        if (!validarFechaNacimiento(fechaNacimiento)) {
            throw new IllegalArgumentException("Fecha invalida");
        }

        if (!validarDni(dni)) {
            throw new IllegalArgumentException("DNI invalido.");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.tipoDni = tipoDni;
    }

    /**
     * @return el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return sexo de la persona
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @return fecha de nacimiento de la persona
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @return numero de documento de la persona
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return tipo de documento de la persona
     */
    public TipoDni getTipoDni() {
        return tipoDni;
    }

    /**
     * @param tipoDni
     */
    public void setTipoDni(TipoDni tipoDni) {
        this.tipoDni = tipoDni;
    }

    /**
     * 
     * @param dni
     * @return {@code true} si el numero de documento esta formado por ocho
     *         caracteres numericos
     */
    private boolean validarDni(String dni) {
        return dni.matches("\\d{8}");
    }

    /**
     * 
     * @param fechaNacimiento
     * @return {@code true} si la edad es mayor a dieciseis años; de
     *         cualquier otra forma {@code false}
     */
    private boolean validarFechaNacimiento(LocalDate fechaNacimiento) {
        return fechaNacimiento.isAfter(LocalDate.of(1900, 1, 1))
                && fechaNacimiento.isBefore(LocalDate.of(2006, 10, 22));
    }

    /**
     * 
     * @param sexo
     * @return {@code true} si el sexo es Femenino o Masculino; de
     *         cualquier otra forma {@code false}
     */
    private boolean validarSexo(String sexo) {
        return sexo.equals("Masculino") || sexo.equals("Femenino");
    }

    /**
     * 
     * @param apellido
     * @return {@code true} si es un appellido valido en el idioma castellano; de
     *         cualquier otra forma {@code false}
     */
    private boolean validarApellido(String apellido) {
        return apellido.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    }

    /**
     * 
     * @param nombre
     * @return {@code true} si es un nombre valido en el idioma castellano; de
     *         cualquier otra forma {@code false}
     */
    private boolean validarNombre(String nombre) {
        return nombre.matches("[A-Z][a-zA-Z]*");
    }

    public String toCSV() {
        return nombre + "," + apellido + "," + sexo + ","
                + fechaNacimiento + "," + dni + "," + tipoDni + ",";
    }

    
}
