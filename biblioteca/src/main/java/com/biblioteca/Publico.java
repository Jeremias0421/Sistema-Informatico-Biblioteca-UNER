package com.biblioteca;

import java.time.LocalDate;

/**
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public final class Publico extends Lector {

    /**
     * Inicializa un nuevo objeto Lector de tipo publico.
     * 
     * @param nombre
     * @param apellido
     * @param sexo
     * @param fechaNacimiento
     * @param dni
     * @param tipoDni
     * @param correoElectronico
     * @param nroCelular
     * @param nacionalidad
     * @param domicilio
     * @param nroPostal
     * @param departamento
     * @param localidad
     */
    public Publico(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni, TipoDni tipoDni,
            String correoElectronico, String nroCelular, String nacionalidad, String domicilio, int nroPostal,
            String departamento, String localidad) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni, correoElectronico, nroCelular, nacionalidad,
                domicilio, nroPostal, departamento, localidad);
    }

}
