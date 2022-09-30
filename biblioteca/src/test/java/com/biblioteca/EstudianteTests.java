package com.biblioteca;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class EstudianteTests {

    LocalDate nacimiento;
    Estudiante estudiante;

    @Before
    public void setup() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
    }

    @Test
    public void getApellidoTest() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
        "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
        "Argentina");
        assertEquals("Panozzo", estudiante.getApellido());
    }

    @Test
    public void getNombreTest() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        assertEquals("Jeremias", estudiante.getNombre());
    }

    @Test
    public void getSexoTest() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        assertEquals("Masculino", estudiante.getSexo());
    }

    @Test
    public void getNacimientoTest() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");

        assertEquals(nacimiento, estudiante.getFechaNacimiento());
        assertEquals(nacimiento.getDayOfMonth(), estudiante.getFechaNacimiento().getDayOfMonth());

        assertEquals(nacimiento, estudiante.getFechaNacimiento());
        assertEquals(nacimiento.getMonth(), estudiante.getFechaNacimiento().getMonth());

        assertEquals(nacimiento, estudiante.getFechaNacimiento());
        assertEquals(nacimiento.getYear(), estudiante.getFechaNacimiento().getYear());

    }

    @Test
    public void getDNITests() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        assertEquals(44441299, estudiante.getDni());
    }

    @Test
    public void getTipoDNITest() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
        "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
        "Argentina");
        assertEquals("DNI TARJETA", estudiante.getTipoDni());
    }

    @Test
    public void getNacinalidadTest() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        assertEquals("Argentino", estudiante.getNacionalidad());
    }

    @Test
    public void getCorreoTest() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, 44441299, "DNI TARJETA",
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        assertEquals("jeremiaspanozzo@gmail.com", estudiante.getCorreoElectronico());
    }

}
