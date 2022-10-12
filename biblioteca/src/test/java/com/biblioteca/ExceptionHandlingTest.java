package com.biblioteca;

import java.time.LocalDate;

import org.junit.Test;

public class ExceptionHandlingTest {
    Funcionario funcionario = null;

    @Test
    public void setterTest() {
        try {
            funcionario = new Funcionario("123", "Hernandez", "Masculino", LocalDate.of(
            2001, 2, 23), "14798365", TipoDni.DNI_TARJETA,"jorgito",
            "jorgito123");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
