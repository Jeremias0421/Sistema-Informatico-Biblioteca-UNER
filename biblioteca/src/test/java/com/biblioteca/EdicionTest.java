package com.biblioteca;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class EdicionTest {
    
    Edicion edicion = null;
    Obra obra = null;

    @Before
    public void setup(){
        obra = new Obra("Calculo de Varias Variables. Trascendentes Tempranas.", "", "Stewart, James", "", "", "Calculo", "Ciencias exactas", "9789700502748", null, TipoObra.LIBRO);
        edicion = new Edicion("Cengage Learning", "Mexico", 8, 2018, 10_000, 656, "Español", Formato.PAPEL, obra);
        assertNotNull(obra);
        assertNotNull(edicion);
    }

    @Test
    public void test(){
        assertEquals("Calculo", obra.getAreaTematica());
        assertEquals("Cengage Learning", edicion.getEditorial());
        assertEquals(TipoObra.LIBRO, obra.getTipoObra());
    }
}
