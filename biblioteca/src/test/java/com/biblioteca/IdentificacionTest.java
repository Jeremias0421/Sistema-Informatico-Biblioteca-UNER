package com.biblioteca;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

public class IdentificacionTest {
    
    @Test
    public void test1() {
        Identificacion identificacion = new Identificacion(null, 5, 12, 8, 6, 1);
        assertEquals("5-12-8-6-1", identificacion.toString());
    }

    @Test
    public void test2() {
        Identificacion identificacion2 = new Identificacion(null, 5, 6, 7, 0, 7);
        assertEquals("5-6-7-0-7", identificacion2.toString());
    }

    @Test
    public void test3() {
        Identificacion identificacion3 = new Identificacion(null, 10, 12, 7, 19, 7);
        assertEquals("10-12-7-19-7", identificacion3.toString());
    }

    @Test
    public void cambiarUbicacion(){
        Identificacion identificacion3 = new Identificacion(null, 10, 12, 7, 19, 7);
        assertEquals("10-12-7-19-7", identificacion3.toString());
        identificacion3.cambiarUbicacion(1, 1, 1, 1, 1);
        assertEquals("1-1-1-1-1", identificacion3.toString());
    }

}
