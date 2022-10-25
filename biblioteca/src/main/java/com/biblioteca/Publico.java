package com.biblioteca;

import java.time.LocalDate;

/**
 * Representa a un Publico general.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public final class Publico extends Lector {

    /**
     * Inicializa un nuevo objeto Lector de tipo publico.
     * 
     * @param nombre            nombre de pila
     * @param apellido          apellido
     * @param sexo              sexo
     * @param fechaNacimiento   fehca de nacimineto
     * @param dni               Documento Nacional de identidad
     * @param tipoDni           tipo de documento
     * @param correoElectronico correo electronico
     * @param nroCelular        numero de telefono
     * @param nacionalidad      nacionalidad
     * @param domicilio         domicilio
     * @param nroPostal         codigo postal del lugar donde habita
     * @param departamento      departamento donde nacio el Lector
     * @param localidad         localidad donde nacio el Lector
     * @exception IllegalArgumentException si {@code correoElectronico} no
     *                                     correspone a un correo electronico
     *                                     estandar, {@code nroCelular} no es
     *                                     numerico, {@code nacionalidad},
     *                                     {@code departamento},
     *                                     {@code localidad} contiene numeros y/o
     *                                     caracteres
     *                                     especiales, o {@code nroPostal} es
     *                                     negativo
     */
    public Publico(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni, TipoDni tipoDni,
            String correoElectronico, String nroCelular, String nacionalidad, String domicilio, int nroPostal,
            String departamento, String localidad) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni, correoElectronico, nroCelular, nacionalidad,
                domicilio, nroPostal, departamento, localidad);
    }

    public String toCSV() {
        return super.toCSV() + "\n";
    }


    
}
