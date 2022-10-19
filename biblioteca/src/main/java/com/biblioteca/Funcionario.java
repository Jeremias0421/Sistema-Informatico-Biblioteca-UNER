package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public class Funcionario extends Persona {
    private String usuario;
    private String contrasenia;
    private ArrayList<Prestamo> listaprestamos;

    public Funcionario(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, String dni, TipoDni tipoDni,
            String usuario, String contrasenia) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.listaprestamos = new ArrayList<>();
    }

    public void tomarPrestamo(Prestamo prestamo) { //Añade prestamo a la lista
        this.listaprestamos.add(prestamo);
    }

    public void tomarDevolucion(Prestamo prestamo){
        this.listaprestamos.remove(prestamo);
    }

    public ArrayList<Prestamo> getListaprestamos() {
        return listaprestamos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String toCSV() {
        return this.usuario + "," + this.contrasenia + "\n";
    }

    
}
