package com.biblioteca;

import java.time.LocalDate;

public class Docente extends Lector {
    private String carrera;

    public Docente(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, int dni, String tipoDni,
            String correoElectronico, String nroCelular, String nacionalidad, String domicilio, int nroPostal,
            String departamento, String localidad, String carrera) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni, correoElectronico, nroCelular, nacionalidad,
                domicilio, nroPostal, departamento, localidad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    
}
