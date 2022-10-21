package com.biblioteca;

import java.time.LocalDate;

/**
 * Clase que representa a un Estudiante de la Facultad.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public final class Estudiante extends Lector {
    /**
     * 
     * @param nombre            nombre
     * @param apellido          apellido
     * @param sexo              sexo
     * @param fechaNacimiento   fecha de nacimiento
     * @param dni               Documento Nacional de identidad
     * @param tipoDni           tipo de documento
     * @param correoElectronico correo electronico
     * @param nroCelular        numero de celular
     * @param nacionalidad      nacionalidad
     * @param domicilio         domicilio
     * @param nroPostal         codigo postal del departamento donde reside el
     *                          Estudiante
     * @param departamento      departamento donde reside el docente
     * @param localidad         localidad donde reside el docente
     */
    public Estudiante(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni,
            TipoDni tipoDni,
            String correoElectronico, String nroCelular, String nacionalidad, String domicilio, int nroPostal,
            String departamento, String localidad) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni, correoElectronico, nroCelular, nacionalidad,
                domicilio, nroPostal, departamento, localidad);
    }

}
