package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class EjemplarTests {

    Ejemplar ejemplar = null;

    @Before
    public void setup(){
        Edicion edicion = new Edicion("FEditorial", "Argentina", 3, 2001, 2, 367, "Español", Formato.PAPEL, null);
        ArrayList<Edicion> ediciones = new ArrayList<>();
        ediciones.add(edicion);
        Obra obra = new Obra("Calculo 1", "Subtitulo", "Autor1", "Autor2", "Autor3", "Matematica", "Educacion", "9780313338", ediciones);
        LocalDate adquisicion = LocalDate.of(2019, 7, 22);
        Identificacion seUbica = new Identificacion(null, 1, 1, 1, 1, 1);

        ejemplar = new Ejemplar("Observaciones", "9780313338", adquisicion, "Internet", seUbica, obra);
        seUbica.setSeUbica(ejemplar);
        obra.añadirEjemplar(ejemplar);
    }

    @Test
    public void gettersTest() {
        assertEquals("Observaciones", ejemplar.getObservacionesGenerales());        
        assertEquals("9780313338", ejemplar.getCodigoDeBarra());        
        assertEquals(LocalDate.of(2019, 7, 22), ejemplar.getFechaAdquisicion());        
        assertEquals("Internet", ejemplar.getFormaAquisicion()); 
        assertEquals(1, ejemplar.getSeUbica().getPosicion());        
        assertEquals("Calculo 1", ejemplar.getObra().getTitulo());
    }

    @Test
    public void darDeBajatest() {
        assertEquals(true, ejemplar.isDisponible());
        assertNull(ejemplar.getMotivoBaja());
        assertNull(ejemplar.getFechaBaja());
        ejemplar.darDeBaja("Sin razon");
        assertEquals(false, ejemplar.isDisponible());
        assertEquals(LocalDate.now(), ejemplar.getFechaBaja());
        assertEquals("Sin razon", ejemplar.getMotivoBaja());
    }
}
