package com.biblioteca;

import java.time.LocalDate;

/**
 * Clase que representa a un Docente de la Facultad.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public final class Docente extends Lector {

    /** Carrera en la que imparte el docente. */
    private String carrera;

    /**
     * Crea una nueva instancia de la clase.
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
     *                          docente
     * @param departamento      departamento donde reside el docente
     * @param localidad         localidad donde reside el docente
     * @param carrera           carrera en la que imparte el docente
     * @exception IllegalArgumentException si la carrera contiene caracteres
     *                                     numericos y/o especiales.
     */
    public Docente(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni, TipoDni tipoDni,
            String correoElectronico, String nroCelular, String nacionalidad, String domicilio, int nroPostal,
            String departamento, String localidad, String carrera) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni, correoElectronico, nroCelular, nacionalidad,
                domicilio, nroPostal, departamento, localidad);

        if (!validarCarrera(carrera)) {
            throw new IllegalArgumentException("Carrera no valida");
        }

        this.carrera = carrera;
    }

    /**
     * 
     * @return el nombre de la carrera en la que imparte.
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Permite modificar la carrera por una nueva.
     * 
     * @param carrera Una nueva carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Comprueba la validacion de la carrera.
     * 
     * @param carrera
     * @return {@code true} si la carrera no contiene caracteres
     *         numericos y/o especiales.
     */
    private boolean validarCarrera(String carrera) {
        return carrera.matches("[A-Z][a-z A-Z]*");
    }

    public String toCSV() {
        return super.toCSV() + "," + carrera + "\n";
    }


    
}
