package com.biblioteca;

import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String dni;
    private TipoDni tipoDni;

    public Persona(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni, TipoDni tipoDni) {
        setNombre(nombre);
        setApellido(apellido);
        setSexo(sexo);;
        setFechaNacimiento(fechaNacimiento);
        setDni(dni);
        this.tipoDni = tipoDni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.matches("[A-Z][a-zA-Z]*"))
            this.nombre = nombre;
        else
            throw new IllegalArgumentException("Nombre invalido.");

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido.matches("[a-zA-z]+([ '-][a-zA-Z]+)*"))
            this.apellido = apellido;
        else
            throw new Error("Apellido invalido.");

    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if (sexo.equals("Masculino") || sexo.equals("Femenino"))
            this.sexo = sexo;
        else
            throw new Error("Sexo invalido.");
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento.isAfter(LocalDate.of(1900, 1, 1))&& fechaNacimiento.isBefore(LocalDate.now())) {
            this.fechaNacimiento = fechaNacimiento;
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni.matches("\\d{8}"))
            this.dni = dni;
        else
            throw new Error("DNI invalido.");

    }

    public TipoDni getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(TipoDni tipoDni) {
        this.tipoDni = tipoDni;
    }

}
