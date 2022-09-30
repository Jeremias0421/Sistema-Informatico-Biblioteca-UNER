package com.biblioteca;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.Test;

public class ReservaTests {
    
    @Test
    public void reservaTests(){
        LocalDate nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        LocalDate fechaReserva = LocalDate.of(2023, Month.NOVEMBER, 04);

        ArrayList<Ejemplar> lista = new ArrayList<>();

        Lector lector = new Lector("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA", "jeremiaspanozzo@gmail.com", "3456025247", "Argentina", "Concejal Veiga 1881", 3200, "Concordia", "Concordia");

        Reserva reserva = new Reserva(fechaReserva, lector, lista);

        assertEquals(lista, reserva.getEjemplares());
        assertEquals(lector, reserva.getLector());

    }
}
