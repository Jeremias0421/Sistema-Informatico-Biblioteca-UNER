package com.biblioteca;

/**
 * Esta clase representa una edicion especifica de una Obra en particular.
 * 
 * @author Ezequiel Dalzotto
 * @author Jeremias Panozzo
 * @version 1.0
 */
public class Edicion {

    /** Editorial creadora de la Edicion */
    private String editorial;
    /** Pais original en el que fue creado la Edicion */
    private String paisEdicion;
    /** NUmero correspondiente a la Edicion */
    private int numeroEdicion;
    /** Anio en que se lanzo la Edicion */
    private int anio;
    /** Cantidad de volumenes fabricados */
    private int volumenes;
    /** Cantidad total de paginas del Ejemplar perteneciente */
    private int paginas;
    /** Idioma original de la edicion */
    private String idioma;
    /** Tipo de formato */
    private Formato formato;
    /** Obra al cual pertenece */
    private Obra obra;

    /**
     * Instancia una nueva Edicion.
     * 
     * @param editorial     nombre de la editorial
     * @param paisEdicion   pais en la cual fue creada
     * @param numeroEdicion numero de edicion
     * @param anio          anio de la edicion
     * @param volumenes     cantida de volumenes creados
     * @param paginas       total de paginas del ejemplar
     * @param idioma        idioma
     * @param formato       tipo de formato
     * @param obra          Obra al cual pertenece
     */
    public Edicion(String editorial, String paisEdicion, int numeroEdicion, int anio, int volumenes, int paginas,
            String idioma, Formato formato, Obra obra) {
        this.editorial = editorial;
        this.paisEdicion = paisEdicion;
        this.numeroEdicion = numeroEdicion;
        this.anio = anio;
        this.volumenes = volumenes;
        this.paginas = paginas;
        this.idioma = idioma;
        this.formato = formato;
        this.obra = obra;
    }

    /**
     * @return nombre de la editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Permite modificar la editorial por una nueva
     * 
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return pais en la cual fue creada la Edicion
     */
    public String getPaisEdicion() {
        return paisEdicion;
    }

    /**
     * Permite modificar el pais de la Edicion por uno nuevo
     * 
     * @param paisEdicion
     */
    public void setPaisEdicion(String paisEdicion) {
        this.paisEdicion = paisEdicion;
    }

    /**
     * @return numero de Edicion
     */
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    /**
     * Permite modificar el numero de la Edicion
     * 
     * @param numeroEdicion
     */
    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    /**
     * @return anio en que fue lanzado la Edicion
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Permite modificar el anio de la Edicion
     * 
     * @param anio
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return cantidad de volumenes de la Edicion
     */
    public int getVolumenes() {
        return volumenes;
    }

    /**
     * Permite modificar la cantidad de volumenes pertenencientes a la Edicion
     * 
     * @param volumenes
     */
    public void setVolumenes(int volumenes) {
        this.volumenes = volumenes;
    }

    /**
     * @return cantidad de paginas de la Edicion
     */
    public int getPaginas() {
        return paginas;
    }

    /**
     * Permite modificar las cantidades de paginas del Ejemplar al cual pertenece
     * esta Edicion
     * 
     * @param paginas
     */
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    /**
     * @return idioma de la Edicion
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Permite modificar el idioma de la Edicion
     * 
     * @param idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return tipo de formato de la Edicion
     */
    public Formato getFormato() {
        return formato;
    }

    /**
     * Permite modificar el formato de la Edicion
     * 
     * @param formato
     */
    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    /**
     * @return Obra al cual pertenece la Edicion
     */
    public Obra getObra() {
        return obra;
    }

    /**
     * Permite modificar la Obra al cual pertenece la Edicion
     * 
     * @param obra
     */
    public void setObra(Obra obra) {
        this.obra = obra;
    }

}