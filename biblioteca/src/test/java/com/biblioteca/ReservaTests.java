package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ReservaTests {
    //Biblioteca
    ArrayList<Ejemplar> ejemplaresDisponibles = null;
    ArrayList<Ejemplar> ejemplaresReservados = null;

    //Reserva
    Estudiante estudiante = null;
    ArrayList<Ejemplar> ejemplaresPorReservar = null;

    @Before
    public void setup() {
        LocalDate nacimiento = LocalDate.of(2002, 3, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        
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

        ejemplaresPorReservar = new ArrayList<>();
        ejemplaresPorReservar.add(ejemplar1);
        ejemplaresPorReservar.add(ejemplar2);

        //Ejemplares Disponibles
        ejemplaresDisponibles = new ArrayList<>();
        ejemplaresDisponibles.add(ejemplar1);
        ejemplaresDisponibles.add(ejemplar2);

        //Inicio de lista de reservados
        ejemplaresReservados = new ArrayList<>();
    }
    
    @Test
    public void reservaTests(){
        LocalDate fechaReserva = LocalDate.of(2022, 10, 28);
        Biblioteca.reservarEjemplares(estudiante, fechaReserva, ejemplaresPorReservar, ejemplaresDisponibles,
        ejemplaresReservados);
        assertEquals(0, ejemplaresDisponibles.size());
        assertEquals(2, ejemplaresReservados.size());

        for (Ejemplar ejemplar : ejemplaresReservados) {
            assertEquals(false, ejemplar.isDisponible());
            assertNotNull(ejemplar.getReserva());
        }

        assertNotNull(estudiante.getReserva());

    }
}
