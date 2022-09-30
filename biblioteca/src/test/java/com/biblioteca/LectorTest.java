package com.biblioteca;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

public class LectorTest {
    
    @Test
    public void construccionTest(){
        LocalDate nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);

        Lector yo = new Lector("Jeremias", "Panozzo", "Masculino",
        nacimiento, 44441299, "DNI TARJETA", "jeremiaspanozzo@gmail.com", 
         "3456025247", "Argentina", "Concejal Veiga 1881", 3200, "Concordia", "Concordia");

        assertNotNull(yo);
    }
}
