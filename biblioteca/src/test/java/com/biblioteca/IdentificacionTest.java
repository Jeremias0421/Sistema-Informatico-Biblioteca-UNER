package com.biblioteca;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IdentificacionTest {

    @Test
    public void test1() {
        Identificacion identificacion = new Identificacion(null, 5, 12, 8, 6, 1);
        assertEquals("5-12-8-6-1", identificacion.toString());
    }

    @Test
    public void test2() {
        Identificacion identificacion2 = new Identificacion(null, 5, 6, 7, 1, 7);
        assertEquals("5-6-7-1-7", identificacion2.toString());
    }

    @Test
    public void test3() {
        Identificacion identificacion3 = new Identificacion(null, 10, 12, 7, 19, 7);
        assertEquals("10-12-7-19-7", identificacion3.toString());
    }

    @Test
    public void cambiarUbicacion() {
        Identificacion identificacion3 = new Identificacion(null, 10, 12, 7, 19, 7);
        assertEquals("10-12-7-19-7", identificacion3.toString());
        identificacion3.cambiarID(1, 1, 1, 1, 1);
        assertEquals("1-1-1-1-1", identificacion3.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pasilloInvalidoTest() {
        Identificacion identificacion = new Identificacion(null, -10, 12, 7, 19, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void estanteInvalidoTest() {
        Identificacion identificacion = new Identificacion(null, 10, -12, 7, 19, 7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void filaInvalidaTest() {
        Identificacion identificacion = new Identificacion(null, 10, 12, -7, 19, 7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void columnaInvalidaTest() {
        Identificacion identificacion = new Identificacion(null, 10, 12, 7, -19, 7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void posicionInvalidaTest() {
        Identificacion identificacion = new Identificacion(null, 10, 12, 7, 19, -7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void cambiarUbicacionInvalida(){
        Identificacion identificacion = new Identificacion(null, 10, 12, 7, 19, -7);
        identificacion.cambiarID(-1, -1, -1, -1, -1);
    }

    @Test (expected = IllegalArgumentException.class) 
    public void identificacionEnCero(){
        Identificacion identificacion = new Identificacion(null, 0, 0, 0, 0, 0);
    }
}
