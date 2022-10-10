package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PrestamoTest {
    Estudiante estudiante = null;
    Prestamo prestamo = null;
    Funcionario funcionario = null;
    ArrayList<Ejemplar> ejemplares;



    @Before
    public void setup(){
        //Datos necesarios para la creacion del Prestamo
        LocalDate nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        funcionario = new Funcionario("Jorge", "Hernandez", "Masculino", LocalDate.of(
                2001, 2, 23), "14798365", TipoDni.DNI_TARJETA,"jorgito",
                "jorgito123");

        Edicion edicion1 = new Edicion("Editorial", "Argentina", 0, 
            2008, 2, 890, "Español", Formato.PAPEL, null);
        ArrayList<Edicion> edicones = new ArrayList<>();
        edicones.add(edicion1);

        Obra obra = new Obra("Titulo", "subtitulo", "autor01", "autor02", 
            "autor03", "Matematica", "Educativo", "9788869185182", edicones);
        edicion1.setObra(obra);

        Identificacion ubi = new Identificacion(null, 1, 1, 1, 1, 1);
        Ejemplar ejemplar1 = new Ejemplar("Observaciones", "9788869185182", 
                LocalDate.of(2008, 4, 21), "Donacion", ubi, obra);
        ubi.setSeUbica(ejemplar1);
        

        Identificacion ubi2 = new Identificacion(null, 1, 1, 1, 1, 2);
        Ejemplar ejemplar2 = new Ejemplar("Observaciones", "9788869185182", 
                LocalDate.of(2008, 4, 21), "Donacion", ubi2, obra);
        ubi2.setSeUbica(ejemplar2);

        ejemplares = new ArrayList<>();
        ejemplares.add(ejemplar1);
        ejemplares.add(ejemplar2);

        //Creacion de prestamo
        
    }

    @Test
    public void darPrestamo() {
        prestamo = new Prestamo(5, Lectura.DOMICILO, LocalDate.now(), LocalTime.now(),
            LocalDate.of(2022,10,15), funcionario, estudiante, ejemplares);
        funcionario.tomarPrestamo(prestamo);
        assertEquals(1, funcionario.getListaprestamos().size());
        for (Ejemplar ejemplar : ejemplares) {
            assertEquals(false, ejemplar.isDisponible());//No cambia la disponibilidad del Ejemplar
        }
    }
}
