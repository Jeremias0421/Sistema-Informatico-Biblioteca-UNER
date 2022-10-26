package com.biblioteca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.GUI.Login;

/**
 * Clase principal del sistema que permite transacciones de prestamos y
 * devoluciones a los clientes de la biblioteca.
 * 
 * Esta clase ademas permite el alta y baja de ejemplares.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Biblioteca {

    /**Listado de los clientes de la Biblioteca */
    static ArrayList<Lector> clientes = new ArrayList<Lector>();

    /**
     * Inicio del programa.
     * 
     * @param args
     * @throws FileNotFoundException si los archivos con los datos no son
     *                               encontrados.
     */
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Funcionario> funcionarios = cargarFuncionarios();
        ArrayList<Edicion> edicions = cargarEdiciones();
        ArrayList<Obra> obras = cargarObras(edicions);
        ArrayList<Ejemplar> ejemplaresDisponibles = cargarEjemplaresDisponibles(obras);
        ArrayList<Ejemplar> ejemplaresDeBaja = cargarEjemplaresDeBaja(obras);
        ArrayList<Ejemplar> ejemplaresPrestados;
        ArrayList<Ejemplar> ejemplaresRerservados;
        ArrayList<Lector> lectores = cargarLectores();

        // Look and Feel set
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

        new Login().setVisible(true);

        // new Login(funcionarios).setVisible(true);
    }

    /**
     * Lista a todos aquellos lectores que no han devuelto al momento los ejemplares
     * prestados.
     * 
     * @return listado de Lectores.
     */
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

    /**
     * Permite buscar un determinado Ejemplar que se encuentra disponible para un
     * Prestamo.
     * 
     * @param ID                    identificacion del Ejemplar
     * @param ejemplaresDisponibles ejemplares a buscar
     * @return ejemplar solicitado
     */
    public static Ejemplar buscarEjemplar(String ID, ArrayList<Ejemplar> ejemplaresDisponibles) {
        Ejemplar e = null;

        for (Ejemplar ejemplar : ejemplaresDisponibles) {
            if (ejemplar.getSeUbica().toString().equals(ID)) {
                e = ejemplar;
            }
        }
        return e;
    }

    /**
     *
     */
    public static void obrasMasSolicitadasAlumnosYDocentes() {

    }

    /**
     *
     */
    public static void obrasMasSolicitadasGeneral() {

    }

    /**
     * Permite listar a todos aquellos ejemplares, segun el area tematica
     * solicitada, que se encuentran disponibles para Prestamos.
     * 
     * @param areaReferencia area de referencia a buscar
     * @param listadoDeObras lista de obras en donde buscar
     * @return lista con los ejemplares pertenecientes al area tematica solicitada.
     */
    public static ArrayList<Ejemplar> ejemplaresDisponiblesSegunTematica(String areaReferencia,
            ArrayList<Obra> listadoDeObras) {
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

    /**
     * Permite listar a todos aquellos ejemplares que han sido reservados en la
     * fecha indicada.
     * 
     * @param fecha                fecha solicitada a buscar
     * @param ejemplaresReservados lista de ejemplares reservados
     * @return lista con los ejemplares reservados despues de la fecha
     */
    public static ArrayList<Ejemplar> obrasReservadasPorFecha(LocalDate fecha,
            ArrayList<Ejemplar> ejemplaresReservados) {
        ArrayList<Ejemplar> e = new ArrayList<>();

        for (Ejemplar ejemplar : ejemplaresReservados) {

            if (ejemplar.getReserva() != null) {
                LocalDate f = ejemplar.getReserva().getFecha();
                if (f.isAfter(fecha)) {
                    e.add(ejemplar);
                }
            }

        }
        return e;
    }

    /**
     *
     */
    public static void listarMultasPorPeriodo() {

    }

    /**
     * Lista los ejemplares pertenecientes a una editorial.
     * 
     * @param editorial             editorial a buscar
     * @param ejemplaresDisponibles lista de ejemplares en donde buscar
     * @return lista con los ejemplares pertenecientes a la editorial solicitada
     */
    public static ArrayList<Obra> listarPorEditorial(String editorial, ArrayList<Obra> obras) {
        ArrayList<Obra> lista = new ArrayList<>();

        for (Obra obra : obras) {
            for (Edicion e : obra.getEdiciones()) {
                if (e.getEditorial().equals(editorial)) {
                    lista.add(e.getObra());
                }
            }
        }
        return lista;
    }

    /**
     * Permite dar un Prestamo a domicilio a un determinado Lector.
     * 
     * Un Prestamo a domicilio contiene un plazo dias en la cual el Lector debe
     * devolver los ejemplares que solicito.
     * 
     * @param lector      lector que solicita el Prestamo
     * @param ejemplares  ejemplares solicitados
     * @param funcionario funcionario que otorga el Prestamo
     * @param plazo       plazo de dias
     * @param prestados   lista de ejemplares prestados
     * @param disponibles lista de ejemplares disponibles
     * @param reservados  lista de ejemplares reservados
     * @exception IllegalArgumentException si el ejemplar se encuentra reservado por
     *                                     otro Lector distinto al que solicita el
     *                                     Prestamo, si la reserva ha vencido, o si
     *                                     el Lector se encuentra
     *                                     multado
     * @see Prestamo
     */
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

    /**
     * Permite dar un Prestamo en sala a un determinado Lector.
     * 
     * @param lector      lector que solicita el Prestamo
     * @param ejemplares  ejemplares solicitados
     * @param funcionario funcionario que otorga el Prestamo
     * @param prestados   lista de ejemplares prestados
     * @param disponibles lista de ejemplares disponbles
     * @param reservados  lista de ejemplares reservados
     * @exception IllegalArgumentException si el ejemplar se encuentra reservado por
     *                                     otro Lector distinto al que solicita el
     *                                     Prestamo, si la reserva ha vencido, o si
     *                                     el Lector se encuentra
     *                                     multado
     */
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

    /**
     * Permite la devolucion de un Prestamo.
     * 
     * Si el plazo del Prestamo ha vencido el Lector sera multado, haciendo que no
     * pueda solicitar otro Prestamo hasta que el plazo se venza.
     *
     * @param prestamo    prestamo a devolver
     * @param funcionario funcionario que toma la devolucion
     * @param prestados   lista de ejemplares prestados
     * @param disponibles lista de ejemplares disponibles
     */
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

    /**
     * Permite la reserva de ejemplares, impidiendo que otros lectores pudieran
     * reservar o pedir prestado el ejemplar.
     * 
     * @param lector      lector que solicita la reserva
     * @param fecha       fecha para la cual se reserva
     * @param ejemplares  ejemplares a reservar
     * @param disponibles ejemplares disponibles
     * @param reservados  ejemplares reservados
     * @exception IllegalArgumentException si el ejemplar no esta disponible, o si
     *                                     el lector esta multado
     */
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

    /**
     * Permite levantar la reserva permitiendo al Lector solicitar el Prestamo que
     * reservo.
     * 
     * @param lector      Lector que solicito la reserva
     * @param reservados  ejemplares que reservo el Lector
     * @param disponibles lista de ejemplares disponibles
     */
    public static void levantarReserva(Lector lector, ArrayList<Ejemplar> reservados, ArrayList<Ejemplar> disponibles) {
        for (Ejemplar ejemplar : lector.getReserva().getEjemplares()) {
            disponibles.add(ejemplar);
            reservados.remove(ejemplar);
            ejemplar.sacarReserva();
        }
        lector.reservarEjemplares(null);
    }

    /**
     * Levanta la reserva de la lista de ejemplares reservados. Esto permite que el
     * Lector
     * 
     * @param ejemplar    ejemplar reservdo
     * @param reservados  lista de ejemplares reservados
     * @param disponibles lista de ejemplares disponibles
     * @exception IllegalArgumentException
     */
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

    // ****************Manejo de Ficheros**********************

    /**
     * Permite conocer el Funcionario que se encuentra en la sesion actual del
     * sistema.
     * 
     * @return funcionario logeado
     */
    public static Funcionario getSesionActual() {
        ArrayList<Funcionario> tempList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/actualSesion.csv"));
            String line = br.readLine();

            String[] c = line.split(",");

            Funcionario retorno = new Funcionario(c[0], c[1], c[2], LocalDate.parse(c[3]), c[4], TipoDni.valueOf(c[5]),
                    c[6], c[7], TipoFuncionario.valueOf(c[8]));
            tempList.add(retorno);
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempList.get(0);
    }

    /**
     * Permite guardar los datos del Funcionario que se encuentra logeado
     * actualmente en el sistema.
     * 
     * @param funcionario funcionario logeado
     */
    public static void guardarSesionActual(Funcionario funcionario) {
        try {
            PrintWriter w = new PrintWriter("csv/actualSesion.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new
            // FileReader("csv/actualSesion.csv"));
            FileWriter fw = new FileWriter("csv/actualSesion.csv", false);
            fw.append(funcionario.toCSV());
            fw.flush();
            fw.close();
            // br.close();ñ
        } catch (FileNotFoundException ex) {
            System.out.println("Main.guardarEnArchivo()");
        } catch (IOException ex) {
            System.out.println("Main.guardarEnArchivo()");
        }
    }

    /**
     * Lee del archivo funcionarios.csv los datos de los funcionarios.
     * 
     * @return lista con los datos de los funcionarios
     */
    public static ArrayList<Funcionario> cargarFuncionarios() {
        ArrayList<Funcionario> retorno = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/funcionarios.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                retorno.add(new Funcionario(c[0], c[1], c[2], LocalDate.parse(c[3]), c[4], TipoDni.valueOf(c[5]), c[6],
                        c[7], TipoFuncionario.valueOf(c[8])));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    /**
     * Escribe los datos de los Funcionarios en el archivo funcionarios.csv.
     * 
     * @param funcionarios datos de los funcionarios a escribir
     */
    public static void guardarFuncionarios(ArrayList<Funcionario> funcionarios) {
        try {
            PrintWriter w = new PrintWriter("csv/funcionarios.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new
            // FileReader("csv/funcionarios.csv"));
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

    /**
     * Lee del archivo ediciones.csv los datos de las distintas ediciones de los
     * ejemplares.
     * 
     * @return lista con las ediciones
     */
    public static ArrayList<Edicion> cargarEdiciones() {
        ArrayList<Edicion> retorno = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/ediciones.csv"));
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
                                TipoObra.valueOf(c[16]))));

                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    /**
     * Escribe en el archivo ediciones.csv los datos de las distintas ediciones de
     * los ejemplares.
     * 
     * @param ediciones datos de las ediciones a guardar
     */
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

    /**
     * Lee del arhcivo obras.csv los datos de las distintas obras guardadas en
     * biblioteca.
     * 
     * @param edicions ediciones de las obras
     * @return lista con las obras
     */
    public static ArrayList<Obra> cargarObras(ArrayList<Edicion> edicions) {
        ArrayList<Obra> retorno = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/obras.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                Obra obra = new Obra(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], new ArrayList<>(),
                        TipoObra.valueOf(c[8]));

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

    /**
     * Escribe en el archivo.csv los datos de las distintas obras disponibles.
     * 
     * @param obras obras a guardar
     */
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

    /**
     * Lee del archivo ejemplaresDisponibles.csv los datos de los ejemplares que se
     * encuentran disponibles.
     * 
     * @param obras obras a leer
     * @return lista con los ejemplares solicitadas
     */
    public static ArrayList<Ejemplar> cargarEjemplaresDisponibles(ArrayList<Obra> obras) {
        ArrayList<Ejemplar> retorno = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/ejemplaresDisponibles.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                if (Boolean.parseBoolean(c[11])) {// Controla el estado de Disponible

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
                            null);

                    for (Obra obra : obras) {
                        if (c[13].equals(obra.getIsbn())) {
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

    /**
     * Escribe los datos de los ejemplares disponibles en el archivo
     * ejemplaresDisponibles.csv
     * 
     * @param ejemplares ejemplares a guardar
     */
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

    /**
     * Lee los ejemplares que se encuentran de baja del archivo ejemplaresDeBaja.csv
     * 
     * 
     * @param obras obras a leer
     * @return lista de ejemplares que se encuentran de baja
     */
    public static ArrayList<Ejemplar> cargarEjemplaresDeBaja(ArrayList<Obra> obras) {
        ArrayList<Ejemplar> retorno = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/ejemplaresDeBaja.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                if (!Boolean.parseBoolean(c[11])) {// Controla el estado de Disponible

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
                            null);

                    // Control sobre si esta de baja o no
                    if (!c[9].equals("null")) {
                        ejemplar.setBajaCSV(LocalDate.parse(c[9]), c[1], Boolean.parseBoolean(c[11]));
                    }

                    for (Obra obra : obras) {
                        if (c[13].equals(obra.getIsbn())) {
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

    /**
     * Escribe los datos de los ejemplares que se encuentran de baja en el arhchivo
     * ejemplaresDeBaja.csv
     * 
     * @param ejemplares lista de ejemplares a guardar
     */
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

    // No funciona
    /**
     * Lee los ejemplares que se encuentran de reservados por lectores del archivo
     * ejemplaresReservados.csv
     * 
     * @param obras   obras con los ejemplares reservados
     * @param lectors listado de lectores que reservaron
     * @return lista de ejemplares que se encuentran reservados
     */
    public static ArrayList<Ejemplar> cargarEjemplaresRservados(ArrayList<Obra> obras, ArrayList<Lector> lectors) {
        ArrayList<Ejemplar> retorno = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/ejemplaresReservados.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                if (!Boolean.parseBoolean(c[11])) {// Controla el estado de Disponible

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
                            null);

                    // Control sobre si esta reservado para Linkearlo a su reserva
                    if (!c[14].equals("null")) {
                        for (Lector lector : lectors) {
                            if (lector.getReserva().getFecha().equals(LocalDate.parse(c[14]))
                                    && lector.getDni().equals(c[15])) {
                                ejemplar.reservarEjemplar(new Reserva(LocalDate.now(), lector, retorno));
                                ejemplar.getReserva().setReservaCSV(LocalDate.parse(c[14]));
                                lector.getReserva().linkEjemplarCSV(ejemplar);
                            }
                        }

                        ejemplar.reservarEjemplar(new Reserva(LocalDate.parse(c[14]), null, retorno));
                    }

                    // Linkeo de ejemplar con su respectuva obra
                    for (Obra obra : obras) {
                        if (c[13].equals(obra.getIsbn())) {
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

    /**
     * Escribe los datos de los ejemplares que se encuentran reservados por lectores
     * en el archivo ejemplaresReservados.csv
     * 
     * @param ejemplaresReservados lista de ejemplares reservados
     */
    public static void guardarEjemplaresReservados(ArrayList<Ejemplar> ejemplaresReservados) {
        try {
            PrintWriter w = new PrintWriter("csv/ejemplaresReservados.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new
            // FileReader("csv/ejemplaresReservados.csv"));
            FileWriter fw = new FileWriter("csv/ejemplaresReservados.csv", false);
            for (Ejemplar e : ejemplaresReservados) {
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

    /**
     * Escribe los datos de los ejemplares que se encuentran en prestamo en el
     * archivo ejemplaresPrestados.csv
     * 
     * @param obras        obras perteneciente a los ejemplares
     * @param lectors      lectores que solicitaron prestamos
     * @param funcionarios funcionarios que tomaron el prestamo
     * @return lista de ejemplares prestados
     */
    public static ArrayList<Ejemplar> cargarEjemplaresPrestados(ArrayList<Obra> obras, ArrayList<Lector> lectors,
            ArrayList<Funcionario> funcionarios) {
        ArrayList<Ejemplar> retorno = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/ejemplaresPrestados.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                if (!Boolean.parseBoolean(c[11])) {// Controla el estado de Disponible

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
                            null);

                    // Control sobre si esta reservado para Linkearlo a su reserva
                    if (!c[16].equals("null")) {
                        for (Lector lector : lectors) {
                            // Busqueda del prestamo en los lectores para Linkearlo al ejemplar
                            if (lector.getDni().equals(c[20])) {

                                // Busqueda del funcionario prestador para Linkearlo
                                int funcionarioIndex = 0;
                                for (Funcionario funcionario : funcionarios) {
                                    if (funcionario.getDni().equals(c[19])) {
                                        funcionarioIndex = funcionarios.indexOf(funcionario);
                                    }
                                }

                                Prestamo prestamo = new Prestamo(
                                        Integer.parseInt(c[14]),
                                        Lectura.valueOf(c[15]),
                                        LocalDate.parse(c[18]),
                                        funcionarios.get(funcionarioIndex),
                                        lector,
                                        new ArrayList<>()// relleno con basura
                                );
                                ejemplar.darEnPrestamo(prestamo);
                                ejemplar.getPrestamo().getEjemplaresPrestados().add(ejemplar);// (Funciona a medias)

                                // Linkeo de fecha, hora y Ejemplar con su lector
                                ejemplar.getPrestamo().setCSV(LocalDate.parse(c[16]), LocalTime.parse(c[7]));
                                lector.linkPrestamoCSV(prestamo);
                                lector.getPrestamo().linkEjemplarCSV(ejemplar);
                                // Linkeo de prestamo a Funcionario
                                funcionarios.get(funcionarioIndex).linkPrestamoCSV(prestamo);

                            }
                        }

                        ejemplar.reservarEjemplar(new Reserva(LocalDate.parse(c[14]), null, retorno));
                    }

                    // Linkeo de ejemplar con su respectivo prestamo
                    for (Obra obra : obras) {
                        if (c[13].equals(obra.getIsbn())) {
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

    /**
     * Escribe los datos de los ejemplares que se encuentran en prestamo en el
     * archivo ejemplaresPrestados.csv
     * 
     * @param ejemplaresPrestados lista con los ejemplares en prestamo
     */
    public static void guardarEjemplaresPrestados(ArrayList<Ejemplar> ejemplaresPrestados) {
        try {
            PrintWriter w = new PrintWriter("csv/ejemplaresPrestados.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new
            // FileReader("csv/ejemplaresPrestados.csv"));
            FileWriter fw = new FileWriter("csv/ejemplaresPrestados.csv", false);
            for (Ejemplar e : ejemplaresPrestados) {
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

    /**
     * Lee los lectores del archivo lectores.csv
     * 
     * @return listado con los lectores guardados
     */
    public static ArrayList<Lector> cargarLectores() {
        ArrayList<Lector> retorno = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/lectores.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] c = line.split(",");

                if (c[0].equals(Estudiante.class.toString())) {
                    Estudiante estudiante = new Estudiante(
                            c[1],
                            c[2],
                            c[3],
                            LocalDate.parse(c[4]),
                            c[5],
                            TipoDni.valueOf(c[6]),
                            c[7],
                            c[8],
                            c[9],
                            c[10],
                            Integer.parseInt(c[11]),
                            c[12],
                            c[13]);
                    retorno.add(estudiante);

                } else if (c[0].equals(Publico.class.toString())) {
                    Publico publico = new Publico(
                            c[1],
                            c[2],
                            c[3],
                            LocalDate.parse(c[4]),
                            c[5],
                            TipoDni.valueOf(c[6]),
                            c[7],
                            c[8],
                            c[9],
                            c[10],
                            Integer.parseInt(c[11]),
                            c[12],
                            c[13]);
                    retorno.add(publico);

                } else if (c[0].equals(Docente.class.toString())) {
                    Docente docente = new Docente(
                            c[1],
                            c[2],
                            c[3],
                            LocalDate.parse(c[4]),
                            c[5],
                            TipoDni.valueOf(c[6]),
                            c[7],
                            c[8],
                            c[9],
                            c[10],
                            Integer.parseInt(c[11]),
                            c[12],
                            c[13],
                            c[17]);
                    retorno.add(docente);
                }

                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    /**
     * Escribe los datos de los lectores en un archivo lectores.csv
     * 
     * @param lectores listado de lectores a guardar
     */
    public static void guardarLectores(ArrayList<Lector> lectores) {
        try {
            PrintWriter w = new PrintWriter("csv/lectores.csv");
            w.print("");
            w.close();
            // BufferedReader br = new BufferedReader(new FileReader("csv/lectores.csv"));
            FileWriter fw = new FileWriter("csv/lectores.csv", false);
            for (Lector f : lectores) {
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

}