package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;

public class EstudianteTest {

    Estudiante estudiante = null;
    LocalDate nacimiento = null;

    @Before
    public void setup() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);

        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino",
                nacimiento, "44441299", TipoDni.DNI_TARJETA, "jeremiaspanozzo@gmail.com",
                "3456025247", "Argentina", "Concejal Veiga 1881", 3200, "Concordia", "Concordia");

    }

    @Test
    public void construccionTest() {
        assertNotNull(estudiante);
    }

    @Test(expected = Error.class)
    public void correo_Electronico_Incorrecto_Test() {
        estudiante.setCorreoElectronico("jeremiaspanozzogmail.com");
    }

    @Test(expected = Error.class)
    public void nombre_Incorrecto_Test() {
        estudiante.setNombre("_Panozzo");
    }

    @Test(expected = Error.class)
    public void apellido_Incorrecto_Test() {
        estudiante.setNombre("._jeremias3");
    }

    @Test(expected = Error.class)
    public void sexo_incorrecto() {
        estudiante.setSexo("._jeremias3");
        estudiante.setSexo("Masculi");
    }

    @Test(expected = Error.class)
    public void dni_incorrecto() {
        estudiante.setDni("4444923");
    }

    @Test
    public void setFechaNacimientoTest() {
        LocalDate fecha = LocalDate.of(1880, 1, 1);
        estudiante.setFechaNacimiento(fecha);
        //No se espera modificacion debido al control del setter
        assertEquals(nacimiento, estudiante.getFechaNacimiento());
    }


}
