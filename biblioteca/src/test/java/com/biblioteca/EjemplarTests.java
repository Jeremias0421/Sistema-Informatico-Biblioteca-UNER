package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class EjemplarTests {

    Ejemplar ejemplar = null;

    @Before
    public void setup(){
        Edicion edicion = new Edicion("FEditorial", "Argentina", 1, 2002, 10_000, 367, "Español", Formato.PAPEL, null);
        Edicion edicion1 = new Edicion("FEditorial", "Argentina", 2, 2008, 10_000, 367, "Español", Formato.PAPEL, null);
        Edicion edicion2 = new Edicion("FEditorial", "Argentina", 3, 20015, 10_100, 367, "Español", Formato.PAPEL, null);

        ArrayList<Edicion> ediciones = new ArrayList<>();
        ediciones.add(edicion);
        ediciones.add(edicion1);
        ediciones.add(edicion2);

        Obra obra = new Obra("Calculo 1", "Subtitulo", "Autor1", "Autor2", "Autor3", "Matematica", "Educacion", "9780313338", ediciones, TipoObra.LIBRO);
        
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
    public void constructorTests(){
        assertNotNull(ejemplar);
    }    

    @Test
    public void darDeBajatest() {
        assertEquals(true, ejemplar.isDisponible());
        assertNull(ejemplar.getMotivoBaja());
        assertNull(ejemplar.getFechaBaja());
        try {
            ejemplar.darDeBaja("Sin razon");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(false, ejemplar.isDisponible());
        assertEquals(LocalDate.now(), ejemplar.getFechaBaja());
        assertEquals("Sin razon", ejemplar.getMotivoBaja());
    }
}
