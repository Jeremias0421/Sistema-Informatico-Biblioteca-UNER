package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa un Funcionario de la biblioteca con permisos especiales para dar
 * de alta y baja determinadas Obras.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Funcionario extends Persona {

    /** Nombre de usuario registrado en el sistema. */
    private String usuario;
    /** Contrasenia registrada en el sistema. */
    private String contrasenia;
    /** Tipo de funcionario */
    private TipoFuncionario tipoFuncionario;
    /** Listas de prestamos tomados por el Funcionario. */
    private ArrayList<Prestamo> listaprestamos;

    /**
     * Instancia un nuevo Funcionario.
     * 
     * @param nombre
     *                        nombre
     * @param apellido
     *                        apellido
     * @param sexo
     *                        sexo
     * @param fechaNacimiento
     *                        fecha de nacimiento
     * @param dni
     *                        Documento Nacional de Identidad
     * @param tipoDni
     *                        tipo de documento
     * @param usuario
     *                        nombre de usuario
     * @param contrasenia
     *                        contrasenia
     * @param tipoFuncionario
     *                        tipo de funcionario @see {@link TipoFuncionario}
     */
    public Funcionario(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni,
            TipoDni tipoDni,
            String usuario, String contrasenia, TipoFuncionario tipoFuncionario) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipoFuncionario = tipoFuncionario;
        this.listaprestamos = new ArrayList<>();
    }

    /**
     * Agrega a la lista de prestamos un nuevo Prestamo realizado.
     * 
     * @param prestamo nuevo prestamo a tomar
     */
    public void tomarPrestamo(Prestamo prestamo) { // Añade prestamo a la lista
        this.listaprestamos.add(prestamo);
    }

    /**
     * Quita un prestamo de la lista de prestamos.
     * 
     * @param prestamo prestamo a quitar.
     */
    public void tomarDevolucion(Prestamo prestamo) {
        this.listaprestamos.remove(prestamo);
    }

    /**
     * 
     * @return lista de los prestamos realizados
     */
    public ArrayList<Prestamo> getListaprestamos() {
        return listaprestamos;
    }

    /**
     * @return nombre de usuario guardado en el sistema
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Permite cambiar el nombre del usuario.
     * 
     * @param usuario nuevo nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * 
     * @return contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Permite cambiar la contrasenia.
     * 
     * @param contrasenia nueva contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * 
     * @return tipo de funcionario
     */
    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    /**
     * Convierte los atributos del funcionario a formato String para ser guardados
     * en un archivo SCV.
     * 
     * @return representacion en String de los atributos del Funcionario
     */
    public String toCSV() {
        return super.toCSV() + usuario + "," + contrasenia + ","
                + tipoFuncionario + "," + listaprestamos + "\n";
    }

    public void linkPrestamoCSV(Prestamo prestamo) {
        this.listaprestamos.add(prestamo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (contrasenia == null) {
            if (other.contrasenia != null)
                return false;
        } else if (!contrasenia.equals(other.contrasenia))
            return false;
        if (tipoFuncionario != other.tipoFuncionario)
            return false;
        return true;
    }

    

    
}
