package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import org.junit.Test;

public class DocenteTest {
    
    @Test ()
    public void validarCarrera(){
        Docente docente = new Docente("Jeremias", "Panozzo", "Masculino", LocalDate.of(2002, 11, 4), "44441299", TipoDni.DNI_LIBRETA_CELESTE, "jermeiaspanozzo@gmail.com", "3456015147", "Argentina", "Concejal Veiga 1881", 0, "Concordia", "Concordia", "Lic en Sistemas");
        assertNotNull(docente);
    }

    @Test (expected = IllegalArgumentException.class) 
    public void CarreraInvalida(){
        Docente docente = new Docente("Jeremias", "Panozzo", "Masculino", LocalDate.of(2002, 11, 4), "44441299", TipoDni.DNI_LIBRETA_CELESTE, "jermeiaspanozzo@gmail.com", "3456015147", "Argentina", "Concejal Veiga 1881", 0, "Concordia", "Concordia", "Lic en Siste_mas");
        assertNotNull(docente);
    }
}
