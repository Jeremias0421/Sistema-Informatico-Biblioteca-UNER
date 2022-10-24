package com.biblioteca;

/**
 * Tipos de funcionarios registrados en el sistema.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public enum TipoFuncionario {

    /**
     * Representa a un Funcionario con permisos especiales para dar de alta y baja
     * ejemplares.
     */
    ADMIN,

    /** Funcionario comun sin permisos especiales. */
    REGULAR
}
