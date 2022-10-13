package com.biblioteca;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class ObraTest {
    // Edicion edicion = null;
    Obra obra = null;


    @Before
    public void setup(){
        //Requisitos para el constructor
        Edicion edicion = new Edicion("FEditorial", "Argentina", 3, 2001, 2, 367, "Español", Formato.PAPEL, null);
        ArrayList<Edicion> ediciones = new ArrayList<>();
        ediciones.add(edicion);
        obra = new Obra("Calculo 1", "Subtitulo", "Autor1", "Autor2", "Autor3", "Matematica", "Educacion", "9780313338", ediciones);
        edicion.setObra(obra);
    }

    @Test
    public void noNull(){
        assertNotNull(obra);;
    }

    @Test
    public void getIsbnTest() {
        assertEquals("9780313338", obra.getIsbn());
    }
    // @Test
    // public void setIsbnTest(){
    //     obra.setIsbn("9780313332");
    //     //No se debe modificar porque el ultimo digito no cumple los requisitos
    //     //para ser un isbn valido
    //     assertNotEquals("9780313332", obra.getIsbn());
    // }

    @Test
    public void gettersTest(){
        assertEquals("Calculo 1",obra.getTitulo());
        assertEquals("Subtitulo",obra.getSubtitulo());
        assertEquals("Autor1",obra.getAutor01());
        assertEquals("Autor2",obra.getAutor02());
        assertEquals("Autor3",obra.getAutor03());
        assertEquals("Matematica",obra.getAreaTematica());
        assertEquals("Educacion",obra.getGenero());
        assertEquals("9780313338",obra.getIsbn());
    }

    @Test
    public void añadirEjemplarTest(){
        Ejemplar ejemplar1 = new Ejemplar("", "9780313338", null, null, null, obra);
        Ejemplar ejemplar2 = new Ejemplar("", "9780313338", null, null, null, obra);
        
        obra.añadirEjemplar(ejemplar1);
        obra.añadirEjemplar(ejemplar2);
        assertEquals(2, obra.getEjemplares().size());
    }
}
