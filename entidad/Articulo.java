package main.java.com.revista.entidad;
o
import java.io.IOException;

import main.java.com.revista.util.Persistencia;
import main.java.com.revista.util.Archivos;

public class Articulo {
    private String codigo;
    private String titulo;
    private String resumen;
    private String contenido;
    private String[] palabrasClave;
    private String autor;

    /**
     * Instancia un nuevo artículo
     * @param titulo Título del artículo
     * @param resumen Resumen del artículo
     * @param contenido Contenido del artículo
     * @param palabrasClave Palabras clave del artículo
     * @param autor Autor del artículo
     */
    public Articulo(String titulo, String resumen, String contenido, String[] palabrasClave, String autor) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.contenido = contenido;
        this.palabrasClave = palabrasClave;
        this.autor = autor;
        this.codigo = this.hashCode() + "";
    }

    
    /** 
     * @return String
     */
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String[] getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String[] palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    @Override
    /**
     * Devuelve un entero hasheado basado en el título y resumen del artículo
     * @return Entero hasheado
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((resumen == null) ? 0 : resumen.hashCode());
        return result;
    }

    @Override
    /**
     * Devuelve una representación en cadena del artículo
     * @return Cadena con los datos del artículo
     */
    public String toString() {
        String keywords = "#" + String.join("#", palabrasClave);
        return String.format("%s,%s,%s,%s,%s,%s", codigo, titulo, resumen, contenido, keywords, autor);
    }

    /**
     * Guarda el artículo en el archivo de artículos
     */
    public void guardarArticulo() {
        try {
            Persistencia.escribirArchivo(Archivos.ARTICULOS, toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
