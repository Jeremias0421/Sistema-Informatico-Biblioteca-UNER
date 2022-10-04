package com.biblioteca;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.*;

public class EstudianteTests {

    LocalDate nacimiento = null;
    Estudiante estudiante = null;

    @Before
    public void setup() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", "DNI TARJETA",
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
    }

    @Test
    public void getApellidoTest() {
        assertEquals("Panozzo", estudiante.getApellido());
    }

    @Test
    public void getNombreTest() {
        assertEquals("Jeremias", estudiante.getNombre());
        estudiante.getNombre();
    }

    @Test
    public void getSexoTest() {
        assertEquals("Masculino", estudiante.getSexo());
    }

    @Test
    public void getNacimientoTest() {
        assertEquals(nacimiento, estudiante.getFechaNacimiento());
        assertEquals(nacimiento.getDayOfMonth(), estudiante.getFechaNacimiento().getDayOfMonth());

        assertEquals(nacimiento, estudiante.getFechaNacimiento());
        assertEquals(nacimiento.getMonth(), estudiante.getFechaNacimiento().getMonth());

        assertEquals(nacimiento, estudiante.getFechaNacimiento());
        assertEquals(nacimiento.getYear(), estudiante.getFechaNacimiento().getYear());

    }

    @Test
    public void getDNITests() {
        assertEquals("44441299", estudiante.getDni());
    }

    @Test
    public void getTipoDNITest() {
        assertEquals("DNI TARJETA", estudiante.getTipoDni());
    }

    @Test
    public void getNacinalidadTest() {
        assertEquals("Argentino", estudiante.getNacionalidad());
    }

    @Test
    public void getCorreoTest() {
        assertEquals("jeremiaspanozzo@gmail.com", estudiante.getCorreoElectronico());
    }

    @Test(expected = Error.class)
    public void nombre_invalido() {
        estudiante.setNombre("_jeremias");
    }

    @Test(expected = Error.class)
    public void apellido_invalido() {
        estudiante.setApellido("{Panozzo");
    }

    @Test(expected = Error.class)
    public void sexo_invalido() {
        estudiante.setSexo("{Panozzo");
    }


}
