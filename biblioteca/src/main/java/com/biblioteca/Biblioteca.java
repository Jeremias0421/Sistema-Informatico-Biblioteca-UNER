package com.biblioteca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

import com.GUI.Login;

/**
 * Clase que representa a un sistema de Biblioteca.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Biblioteca {

    static ArrayList<Ejemplar> ejemplaresPrestados = new ArrayList<Ejemplar>();
    static ArrayList<Ejemplar> ejemplaresReservados = new ArrayList<Ejemplar>();
    static ArrayList<Obra> listadoDeObras = new ArrayList<Obra>();
    static ArrayList<Lector> clientes = new ArrayList<Lector>();

    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<Funcionario> funcionarios = cargarFuncionarios();
        ArrayList<Edicion> edicions = cargarEdiciones();
        ArrayList<Obra> obras = cargarObras(edicions);
        ArrayList<Ejemplar> ejemplaresDisponibles = cargarEjemplaresDisponibles(obras);
        ArrayList<Ejemplar> ejemplaresDeBaja = cargarEjemplaresDeBaja(obras);


        //Look and Feel set
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new Login(funcionarios, ejemplaresDisponibles, obras, edicions).setVisible(true);



        // new Login(funcionarios).setVisible(true);
    }

    public ArrayList<Lector> lectoresConObrasNoDevueltas() {
        ArrayList<Lector> listado = new ArrayList<>();

        for (Lector lector : clientes) {
            if (lector.getPrestamo() != null) {
                lector.getPrestamo().getPlazo();

                listado.add(lector);
            }
        }
        return listado;
    }

    public static Ejemplar buscarEjemplar(String ID, ArrayList<Ejemplar> ejemplaresDisponibles) {
        Ejemplar e = null;

        for (Ejemplar ejemplar : ejemplaresDisponibles) {
            if (ejemplar.getSeUbica().toString().equals(ID)) {
                e = ejemplar;
            }
        }
        return e;
    }

    public static void obrasMasSolicitadasAlumnosYDocentes() {

    }

    public static void obrasMasSolicitadasGeneral() {

    }

    public static ArrayList<Ejemplar> ejemplaresDisponiblesSegunTematica(String areaReferencia) {
        ArrayList<Ejemplar> lista = new ArrayList<>();

        for (Obra obra : listadoDeObras) {

            if (obra.getAreaTematica().equals(areaReferencia)) {

                for (Ejemplar ejemplar : obra.getEjemplares()) {
                    if (ejemplar.isDisponible()) {
                        lista.add(ejemplar);
                    }
                }
            }
        }

        return lista;
    }

    public static ArrayList<Ejemplar> obrasReservadasPorFecha(LocalDate fecha) {
        ArrayList<Ejemplar> e = new ArrayList<>();

        for (Ejemplar ejemplar : ejemplaresReservados) {

            LocalDate f = ejemplar.getReserva().getFecha();
            if (f.isAfter(fecha)) {
                e.add(ejemplar);
            }
        }
        return e;
    }

    public static void listarMultasPorPeriodo() {

    }

    public static void listarPorEditorial(String editorial) {

    }

    public static void darPrestamoDomicilio(Lector lector, ArrayList<Ejemplar> ejemplares, Funcionario funcionario,
            int plazo, ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles, ArrayList<Ejemplar> reservados) {

        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar.getReserva() != null) {
                if (ejemplar.getReserva() != lector.getReserva()) { // Comprueba si fue reservado por el lector
                    // Si Paso la fecha de la reserva saca la reserva
                    if ((ejemplar.getReserva().getFecha()).isBefore(LocalDate.now())) {
                        reservaVencida(ejemplar, reservados, disponibles);
                    } else {
                        throw new IllegalArgumentException(ejemplar + " Reservado");
                    }
                } else {
                    // Comprueba si fue reservado para el dia del prestamo
                    if ((ejemplar.getReserva().getFecha()).isBefore(LocalDate.now())) {
                        throw new IllegalArgumentException("Fecha de prestamo anticipada a la reservada");
                    } else {
                        levantarReserva(lector, reservados, disponibles);
                    }
                }
            }
            if (!ejemplar.isDisponible()) {
                throw new IllegalArgumentException(ejemplar + ": No disponible");
            }
        }

        if (lector.isMultado()) {
            throw new IllegalArgumentException("Lector multado");
        }
        Prestamo prestamo = new Prestamo(plazo, Lectura.DOMICILIO,
                LocalDate.of(2022, 10, 15), funcionario, lector, ejemplares);
        funcionario.tomarPrestamo(prestamo);
        lector.pedirPrestamo(prestamo);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.darEnPrestamo(prestamo);
            prestados.add(ejemplar);
            disponibles.remove(ejemplar);
        }
    }

    public static void darPrestamoSala(Lector lector, ArrayList<Ejemplar> ejemplares, Funcionario funcionario,
            ArrayList<Ejemplar> prestados, ArrayList<Ejemplar> disponibles, ArrayList<Ejemplar> reservados) {

        // Itera cada ejemplar para comprobar si esta reservado
        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar.getReserva() != null) {
                if (ejemplar.getReserva() != lector.getReserva()) { // Comprueba si fue reservado por el lector
                    // Si Paso la fecha de la reserva saca la reserva
                    if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) > 0) {
                        reservaVencida(ejemplar, reservados, disponibles);
                    } else {
                        throw new IllegalArgumentException(ejemplar + " Reservado");
                    }
                } else {
                    // Comprueba si fue reservado para el dia del prestamo
                    if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) < 0) {
                        throw new IllegalArgumentException("Fecha de prestamo anticipada a la reservada");
                    } else {
                        levantarReserva(lector, reservados, disponibles);
                    }
                }
            }
            if (!ejemplar.isDisponible()) {
                throw new IllegalArgumentException(ejemplar + ": No disponible");
            }
        }

        if (lector.isMultado()) {
            throw new IllegalArgumentException("Lector multado");
        }

        Prestamo prestamo = new Prestamo(0, Lectura.SALA,
                LocalDate.now(), funcionario, lector, ejemplares);
        funcionario.tomarPrestamo(prestamo);
        lector.pedirPrestamo(prestamo);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.darEnPrestamo(prestamo);
            prestados.add(ejemplar);
            disponibles.remove(ejemplar);
        }
    }

    public static void devolverPrestamo(Prestamo prestamo, Funcionario funcionario, ArrayList<Ejemplar> prestados,
            ArrayList<Ejemplar> disponibles) {
        for (Ejemplar ejemplar : prestamo.getEjemplaresPrestados()) {
            prestados.remove(ejemplar);
            disponibles.add(ejemplar);
            ejemplar.devolverEjemplar();
        }
        Lector lector = prestamo.getLector();
        funcionario.tomarDevolucion(prestamo);
        if (Duration.between(prestamo.getFecha().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays() > prestamo
                .getPlazo()) {
            lector.cargarMulta(new Multa(100f, 5, prestamo, lector));
        }
        lector.devolverPrestamo();
    }

    public static void reservarEjemplares(Lector lector, LocalDate fecha, ArrayList<Ejemplar> ejemplares,
            ArrayList<Ejemplar> disponibles,
            ArrayList<Ejemplar> reservados) {

        for (Ejemplar ejemplar : ejemplares) {
            if (!ejemplar.isDisponible()) {
                if (ejemplar.getFechaBaja() != null || ejemplar.getReserva() != null) {
                    throw new IllegalArgumentException(ejemplar + "No disponible");
                }
            }
        }

        if (lector.isMultado()) {
            throw new IllegalArgumentException("Lector Multado");
        }
        Reserva reserva = new Reserva(fecha, lector, ejemplares);
        lector.reservarEjemplares(reserva);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.reservarEjemplar(reserva);
            disponibles.remove(ejemplar);
            reservados.add(ejemplar);
        }
    }

    public static void levantarReserva(Lector lector, ArrayList<Ejemplar> reservados, ArrayList<Ejemplar> disponibles) {
        for (Ejemplar ejemplar : lector.getReserva().getEjemplares()) {
            disponibles.add(ejemplar);
            reservados.remove(ejemplar);
            ejemplar.sacarReserva();
        }
        lector.reservarEjemplares(null);
    }

    public static void reservaVencida(Ejemplar ejemplar, ArrayList<Ejemplar> reservados,
            ArrayList<Ejemplar> disponibles) {
        // Revoca la reserva de todos los ejemplares, Metodo llamado cuando supero la
        // fecha de reserva
        if ((ejemplar.getReserva().getFecha()).compareTo(LocalDate.now()) <= 0) {
            throw new IllegalArgumentException("Fecha de prestamo debe ser menor");
        }
        ejemplar.getReserva().getLector().reservarEjemplares(null);
        for (Ejemplar ejemplarRes : ejemplar.getReserva().getEjemplares()) {
            ejemplar.sacarReserva();
            reservados.remove(ejemplarRes);
            disponibles.add(ejemplarRes);
        }
    }


    //****************Manejo de Ficheros**********************

    public static ArrayList<Funcionario> cargarFuncionarios() {
        ArrayList<Funcionario> retorno = new ArrayList<>();

        try {
            BufferedReader br  = new BufferedReader(new FileReader("csv/funcionarios.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                retorno.add(new Funcionario(c[0], c[1], c[2], LocalDate.parse(c[3]), c[4], TipoDni.valueOf(c[5]), c[6], c[7], TipoFuncionario.valueOf(c[8])));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public static void guardarFuncionarios(ArrayList<Funcionario> funcionarios) {
        try {
            PrintWriter w = new PrintWriter("csv/funcionarios.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new FileReader("csv/funcionarios.csv"));
            FileWriter fw = new FileWriter("csv/funcionarios.csv", false);
            for (Funcionario f : funcionarios) {
                fw.append(f.toCSV());
            }
            fw.flush();
            fw.close();
            // br.close();ñ
        } catch (FileNotFoundException ex) {
            System.out.println("Main.guardarEnArchivo()");
        } catch (IOException ex) {
            System.out.println("Main.guardarEnArchivo()");
        }
    }

    public static ArrayList<Edicion> cargarEdiciones() {
        ArrayList<Edicion> retorno = new ArrayList<>();

        try {
            BufferedReader br  = new BufferedReader(new FileReader("csv/ediciones.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                retorno.add(new Edicion(
                    c[0],
                    c[1],
                    Integer.parseInt(c[2]),
                    Integer.parseInt(c[3]),
                    Integer.parseInt(c[4]),
                    Integer.parseInt(c[5]),
                    c[6],
                    Formato.valueOf(c[7]),
                    new Obra(
                        c[8],
                        c[9],
                        c[10],
                        c[11],
                        c[12],
                        c[13],
                        c[14],
                        c[15],
                        new ArrayList<>(),
                        TipoObra.valueOf(c[16])
                    )
                ));

                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public static void guardarEdiciones(ArrayList<Edicion> ediciones) {
        try {
            PrintWriter w = new PrintWriter("csv/ediciones.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new FileReader("csv/ediciones.csv"));
            FileWriter fw = new FileWriter("csv/ediciones.csv", false);
            for (Edicion e : ediciones) {
                fw.append(e.toCSV());
            }
            fw.flush();
            fw.close();
            // br.close();ñ
        } catch (FileNotFoundException ex) {
            System.out.println("Main.guardarEnArchivo()");
        } catch (IOException ex) {
            System.out.println("Main.guardarEnArchivo()");
        }
    }

    public static ArrayList<Obra> cargarObras(ArrayList<Edicion> edicions) {
        ArrayList<Obra> retorno = new ArrayList<>();

        try {
            BufferedReader br  = new BufferedReader(new FileReader("csv/obras.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                Obra obra = new Obra(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], new ArrayList<>(),TipoObra.valueOf(c[8]));

                retorno.add(obra);
                for (Edicion edicion : edicions) {
                    if (c[7].equals(edicion.getObra().getIsbn())) {
                        obra.getEdiciones().add(edicion);
                        edicion.setObra(obra);
                    }
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public static void guardarObras(ArrayList<Obra> obras) {
        try {
            PrintWriter w = new PrintWriter("csv/obras.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new FileReader("csv/obras.csv"));
            FileWriter fw = new FileWriter("csv/obras.csv", false);
            for (Obra e : obras) {
                fw.append(e.toCSV());
            }
            fw.flush();
            fw.close();
            // br.close();ñ
        } catch (FileNotFoundException ex) {
            System.out.println("Main.guardarEnArchivo()");
        } catch (IOException ex) {
            System.out.println("Main.guardarEnArchivo()");
        }
    }

    public static ArrayList<Ejemplar> cargarEjemplaresDisponibles(ArrayList<Obra> obras) {
        ArrayList<Ejemplar> retorno = new ArrayList<>();

        try {
            BufferedReader br  = new BufferedReader(new FileReader("csv/ejemplaresDisponibles.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                if (Boolean.parseBoolean(c[11])) {//Controla el estado de Disponible
                
                    Ejemplar ejemplar = new Ejemplar(
                        c[5],
                        c[6],
                        LocalDate.parse(c[7]),
                        c[8],
                        new Identificacion(null, Integer.parseInt(c[0]), 
                            Integer.parseInt(c[1]),
                            Integer.parseInt(c[2]),
                            Integer.parseInt(c[3]),
                            Integer.parseInt(c[4])),
                            null
                    );

                    for (Obra obra : obras) {
                        if(c[13].equals(obra.getIsbn())){
                            ejemplar.setObra(obra);
                            obra.añadirEjemplar(ejemplar);
                        }
                    }
                    ejemplar.getSeUbica().setSeUbica(ejemplar);
                    retorno.add(ejemplar);
                }

                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public static void guardarEjemplaresDisponibles(ArrayList<Ejemplar> ejemplares) {
        try {
            PrintWriter w = new PrintWriter("csv/ejemplaresDisponibles.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new FileReader("csv/ejemplares.csv"));
            FileWriter fw = new FileWriter("csv/ejemplaresDisponibles.csv", false);
            for (Ejemplar e : ejemplares) {
                fw.append(e.toCSV());
            }
            fw.flush();
            fw.close();
            // br.close();ñ
        } catch (FileNotFoundException ex) {
            System.out.println("Main.guardarEnArchivo()");
        } catch (IOException ex) {
            System.out.println("Main.guardarEnArchivo()");
        }
    }

    
    public static ArrayList<Ejemplar> cargarEjemplaresDeBaja(ArrayList<Obra> obras) {
        ArrayList<Ejemplar> retorno = new ArrayList<>();

        try {
            BufferedReader br  = new BufferedReader(new FileReader("csv/ejemplaresDeBaja.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                if (Boolean.parseBoolean(c[11])) {//Controla el estado de Disponible
                
                    Ejemplar ejemplar = new Ejemplar(
                        c[5],
                        c[6],
                        LocalDate.parse(c[7]),
                        c[8],
                        new Identificacion(null, Integer.parseInt(c[0]), 
                            Integer.parseInt(c[1]),
                            Integer.parseInt(c[2]),
                            Integer.parseInt(c[3]),
                            Integer.parseInt(c[4])),
                            null
                    );

                    //Control sobre si esta de baja o no
                    if (!c[9].equals("null")) {
                        ejemplar.setBajaCSV(LocalDate.parse(c[9]), c[1], Boolean.parseBoolean(c[11]));
                    }

                    for (Obra obra : obras) {
                        if(c[13].equals(obra.getIsbn())){
                            ejemplar.setObra(obra);
                            obra.añadirEjemplar(ejemplar);
                        }
                    }
                    ejemplar.getSeUbica().setSeUbica(ejemplar);
                    retorno.add(ejemplar);
                }

                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public static void guardarEjemplaresDeBaja(ArrayList<Ejemplar> ejemplares) {
        try {
            PrintWriter w = new PrintWriter("csv/ejemplaresDeBaja.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new FileReader("csv/ejemplares.csv"));
            FileWriter fw = new FileWriter("csv/ejemplaresDeBaja.csv", false);
            for (Ejemplar e : ejemplares) {
                fw.append(e.toCSV());
            }
            fw.flush();
            fw.close();
            // br.close();ñ
        } catch (FileNotFoundException ex) {
            System.out.println("Main.guardarEnArchivo()");
        } catch (IOException ex) {
            System.out.println("Main.guardarEnArchivo()");
        }
    }

    
}
