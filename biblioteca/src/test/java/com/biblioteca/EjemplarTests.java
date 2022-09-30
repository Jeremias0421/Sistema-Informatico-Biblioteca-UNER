package com.biblioteca;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

public class EjemplarTests {
    
    @Test
    public void constructorTests(){
       Edicion edicion = new Edicion(null, null, 0, null, 0, 0, null, null, null);
       Obra obra = new Obra(null, null, null, null, null, null, null, null, null);
       Identificacion i = new Identificacion(null, 0, 0, 0, 0, 0);
       Ejemplar ejemplar = new Ejemplar(null, null, null, null, i, obra);



    }
}
