package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;

public class LectorTest {

    Lector lector = null;
    LocalDate nacimiento = null;

    @Before
    public void setup() {
        nacimiento = LocalDate.of(2002, Month.NOVEMBER, 04);

        lector = new Lector("Jeremias", "Panozzo", "Masculino",
                nacimiento, "44441299", TipoDni.DNI_TARJETA, "jeremiaspanozzo@gmail.com",
                "3456025247", "Argentina", "Concejal Veiga 1881", 3200, "Concordia", "Concordia");

    }

    @Test
    public void construccionTest() {
        assertNotNull(lector);
    }

    @Test(expected = Error.class)
    public void correo_Electronico_Incorrecto_Test() {
        lector.setCorreoElectronico("jeremiaspanozzogmail.com");
    }

    @Test(expected = Error.class)
    public void nombre_Incorrecto_Test() {
        lector.setNombre("_Panozzo");
    }

    @Test(expected = Error.class)
    public void apellido_Incorrecto_Test() {
        lector.setNombre("._jeremias3");
    }

    @Test(expected = Error.class)
    public void sexo_incorrecto() {
        lector.setSexo("._jeremias3");
        lector.setSexo("Masculi");
    }

    @Test(expected = Error.class)
    public void dni_incorrecto() {
        lector.setDni("4444923");
    }

    @Test
    public void setFechaNacimientoTest() {
        LocalDate fecha = LocalDate.of(1880, 1, 1);
        lector.setFechaNacimiento(fecha);
        //No se espera modificacion debido al control del setter
        assertEquals(nacimiento, lector.getFechaNacimiento());
    }


}
