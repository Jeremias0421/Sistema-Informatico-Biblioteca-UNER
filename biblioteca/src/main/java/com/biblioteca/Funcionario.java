package com.biblioteca;

import java.time.LocalDate;

public class Funcionario extends Persona {
    private String usuario;
    private String contrasenia;

    public Funcionario(String nombre, String apellido, String sexo, LocalDate fechaNacimiento, int dni, String tipoDni,
            String usuario, String contrasenia) {
        super(nombre, apellido, sexo, fechaNacimiento, dni, tipoDni);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
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

    
}
