package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DevolucionTest {
    //Biblioteca
    ArrayList<Ejemplar> ejemplaresDisponibles = null;
    ArrayList<Ejemplar> ejemplaresPrestados = null;
    ArrayList<Ejemplar> ejemplaresReservados = null;

    //Listas para almacenar objetos creados
    ArrayList<Lector> lectores = new ArrayList<>();
    ArrayList<Lector> lectoresMultados = new ArrayList<>();

    //Para prestamo
    Funcionario funcionario = null;
    Estudiante estudiante = null;

    @Before
    public void setup() {
        //Objetos necesarios para el prestamo
        LocalDate nacimiento = LocalDate.of(2002, 3, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        lectores.add(estudiante);

        funcionario = new Funcionario("Jorge", "Hernandez", "Masculino", LocalDate.of(
            2001, 2, 23), "14798365", TipoDni.DNI_TARJETA,"jorgito",
            "jorgito123", TipoFuncionario.ADMIN);

        Edicion edicion1 = new Edicion("Editorial", "Argentina", 0, 
        2008, 2, 890, "Español", Formato.PAPEL, null);
        ArrayList<Edicion> edicones = new ArrayList<>();
        edicones.add(edicion1);

        Obra obra = new Obra("Titulo", "subtitulo", "autor01", "autor02", 
            "autor03", "Matematica", "Educativo", "9789700502748", edicones, TipoObra.LIBRO);
        edicion1.setObra(obra);

        Identificacion ubi = new Identificacion(null, 1, 1, 1, 1, 1);
        Ejemplar ejemplar1 = new Ejemplar("Observaciones", "9789700502748", 
                LocalDate.of(2008, 4, 21), "Donacion", ubi, obra);
        ubi.setSeUbica(ejemplar1);
        

        Identificacion ubi2 = new Identificacion(null, 1, 1, 1, 1, 2);
        Ejemplar ejemplar2 = new Ejemplar("Observaciones", "9789700502748", 
                LocalDate.of(2008, 4, 21), "Donacion", ubi2, obra);
        ubi2.setSeUbica(ejemplar2);

        ArrayList<Ejemplar> ejemplares = new ArrayList<>();
        ejemplares.add(ejemplar1);
        ejemplares.add(ejemplar2);

        //Ejemplares Disponibles
        ejemplaresDisponibles = new ArrayList<>();
        ejemplaresDisponibles.add(ejemplar1);
        ejemplaresDisponibles.add(ejemplar2);
        assertEquals(2, ejemplaresDisponibles.size());

        //Creacion de Lista de Prestados
        ejemplaresPrestados = new ArrayList<>();

        //Creacion de Lista de Reservados
        ejemplaresReservados = new ArrayList<>();

        //Test del metodo
        Biblioteca.darPrestamoDomicilio(estudiante,ejemplares,funcionario,5,ejemplaresPrestados,ejemplaresDisponibles, ejemplaresReservados);
        for (Ejemplar ejemplar : ejemplares) {
            assertEquals(false, ejemplar.isDisponible());
        }
        assertEquals(2, ejemplaresPrestados.size());//Se añadieron los 2 ejemplares prestados
        assertEquals(0, ejemplaresDisponibles.size());//Se removieron los 2 ejemplares disponibles
    }

    @Test
    public void DevolucionTesting() {
        Biblioteca.devolverPrestamo(estudiante.getPrestamo(), funcionario, ejemplaresPrestados, ejemplaresDisponibles);
        for (Ejemplar ejemplar : ejemplaresDisponibles) {
            assertEquals(true, ejemplar.isDisponible());
        }
        assertEquals(0, ejemplaresPrestados.size());
        assertEquals(2, ejemplaresDisponibles.size());
        assertNull(estudiante.getPrestamo());
    }
}
