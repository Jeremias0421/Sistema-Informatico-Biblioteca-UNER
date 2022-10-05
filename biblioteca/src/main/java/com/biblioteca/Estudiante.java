package com.biblioteca;

import java.time.LocalDate;

public class Estudiante extends Lector {

    public Estudiante(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni, TipoDni tipoDni,
            String correoElectronico, String nroCelular, String nacionalidad, String domicilio, int nroPostal,
            String departamento, String localidad) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni, correoElectronico, nroCelular, nacionalidad,
                domicilio, nroPostal, departamento, localidad);
    }
    
}
