package com.biblioteca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IdentificacionTest {
    Identificacion identificacion = null;

    @Before
    public void setup(){
        identificacion = new Identificacion(null, 5, 12, 8, 6, 1);
    }
    @Test
    public void test1(){
        assertEquals("5-12-8-6-1", identificacion.toString());
        identificacion.cambiarUbicacion(2, 2, 7, 5, 10);
        assertEquals("2-2-7-5-10", identificacion.toString());
}

    @Test
    public void asignacionInvalidaTest(){
        identificacion.cambiarUbicacion(-1, 2, 1, 1, 1);
        assertEquals("5-12-8-6-1", identificacion.toString());
    }
}
