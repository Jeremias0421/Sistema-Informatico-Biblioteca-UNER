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
        estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
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
        assertEquals(TipoDni.DNI_TARJETA, estudiante.getTipoDni());
    }

    @Test
    public void getNacinalidadTest() {
        assertEquals("Argentino", estudiante.getNacionalidad());
    }

    @Test
    public void getCorreoTest() {
        assertEquals("jeremiaspanozzo@gmail.com", estudiante.getCorreoElectronico());
    }

    @Test (expected = IllegalArgumentException.class)
    public void nombreInvalidoTest(){
        Estudiante estudiante = new Estudiante("-Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
    }

    @Test (expected = IllegalArgumentException.class)
    public void apellidoInvalidoTest(){
        Estudiante estudiante = new Estudiante("Jeremias", "Pano2-zzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
    }

    @Test (expected = IllegalArgumentException.class)
    public void sexoInvalidoTest(){
        Estudiante estudiante = new Estudiante("Jeremias", "Panozzo", "Masculine", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "3456025247", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");
        
    }

    @Test (expected = IllegalArgumentException.class)
    public void telefonoInvalidoTest(){
        Estudiante estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "345602524", "Argentino", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");        
    }

    @Test (expected = IllegalArgumentException.class)
    public void nacionalidadInvalidoTest(){
        Estudiante estudiante = new Estudiante("Jeremias", "Panozzo", "Masculino", nacimiento, "44441299", TipoDni.DNI_TARJETA,
                "jeremiaspanozzo@gmail.com", "3456025247", "Argenti43", "Concejal Veiga 1881", 3200, "Concordia",
                "Argentina");        
    }

    @Test (expected = IllegalArgumentException.class)
    public void setCelularInvalidoTest(){
        estudiante.setNroCelular("asdas");
    }

    @Test (expected = IllegalArgumentException.class)
    public void setNroPostalInvalidoTest(){
        estudiante.setNroPostal(-12);
    }

}
