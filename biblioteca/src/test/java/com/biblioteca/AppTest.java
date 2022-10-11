package com.biblioteca;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {
    //Biblioteca
    ArrayList<Ejemplar> ejemplaresDisponibles = null;
    ArrayList<Ejemplar> ejemplaresPrestados = null;

    //Para prestamo
    Funcionario funcionario = null;
    Lector lector = null;


    @Before
    void setup(){
        ejemplaresPrestados = new ArrayList<>();
        
    }
   
    @Test
    void realizarPrestamoTest(){
        //Objetos necesarios para el prestamo
        LocalDate nacimiento = LocalDate.of(2002, 3, 04);
        Estudiante estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");

        funcionario = new Funcionario("Jorge", "Hernandez", "Masculino", LocalDate.of(
            2001, 2, 23), "14798365", TipoDni.DNI_TARJETA,"jorgito",
            "jorgito123");

        Edicion edicion1 = new Edicion("Editorial", "Argentina", 0, 
        2008, 2, 890, "Español", Formato.PAPEL, null);
        ArrayList<Edicion> edicones = new ArrayList<>();
        edicones.add(edicion1);

        Obra obra = new Obra("Titulo", "subtitulo", "autor01", "autor02", 
            "autor03", "Matematica", "Educativo", "9788869185182", edicones);
        edicion1.setObra(obra);

        Identificacion ubi = new Identificacion(null, 1, 1, 1, 1, 1);
        Ejemplar ejemplar1 = new Ejemplar("Observaciones", "9788869185182", 
                LocalDate.of(2008, 4, 21), "Donacion", ubi, obra);
        ubi.setSeUbica(ejemplar1);
        

        Identificacion ubi2 = new Identificacion(null, 1, 1, 1, 1, 2);
        Ejemplar ejemplar2 = new Ejemplar("Observaciones", "9788869185182", 
                LocalDate.of(2008, 4, 21), "Donacion", ubi2, obra);
        ubi2.setSeUbica(ejemplar2);

        ArrayList<Ejemplar> ejemplares = new ArrayList<>();
        ejemplares.add(ejemplar1);
        ejemplares.add(ejemplar2);


        Biblioteca.darPrestamoDomicilio(lector,ejemplares,funcionario,5,ejemplaresPrestados);
        for (Ejemplar ejemplar : ejemplares) {
            assertEquals(false, ejemplar.isDisponible());
        }
    }
}
