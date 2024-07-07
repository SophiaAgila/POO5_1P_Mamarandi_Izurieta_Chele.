package main.java.com.revista.entidad;

import java.io.IOException;

import main.java.com.revista.Sistema;
import main.java.com.revista.util.Persistencia;
import main.java.com.revista.util.Archivos;
import main.java.com.revista.util.Correos;
import main.java.com.revista.util.EstadoRevision;

public class Revisor extends Usuario {
    private String especialidad;
    private int articulosRevisados;

    /**
     * Instancia un nuevo revisor
     * @param codigo Código del revisor
     * @param nombre Nombre del revisor
     * @param apellido Apellido del revisor
     * @param correo Correo del revisor
     * @param especialidad Especialidad del revisor
     * @param articulosRevisados Número de artículos revisados por el revisor
     */
    public Revisor(String codigo, String nombre, String apellido, String correo, String especialidad, int articulosRevisados) {
        super(codigo, nombre, apellido, correo);
        this.especialidad = especialidad;
        this.articulosRevisados = articulosRevisados;
    }

    
    /** 
     * @return String
     */
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getArticulosRevisados() {
        return articulosRevisados;
    }

    public void setArticulosRevisados(int numeroArticulosRevisados) {
        this.articulosRevisados = numeroArticulosRevisados;
    }

    @Override
    /**
     * Devuelve una representación en cadena del Revisor
     */
    public String toString() {
        return String.format("Revisor: %s %s\nCorreo: %s\n" +
                "Especialidad: %s\nArtículos revisados: %d",
                nombre, apellido, correo, especialidad, articulosRevisados);
    }

    @Override
    /**
     * Genera un correo electrónico con el asunto y mensaje dados
     * y lo envía al destinatario
     * @param destinatario Correo del destinatario
     * @param asunto Asunto del correo
     * @param mensaje Cuerpo del correo
     * @return true si el correo se envió con éxito, false en caso contrario
     */
    public boolean generarCorreo(String destinatario, String asunto, String mensaje) {
        return Correos.enviar(destinatario, asunto, mensaje);
    }

    @Override
    /**
     * Revisor ingresa comentarios y decide si aceptar o rechazar un artículo
     * @param articulo Artículo a revisar
     */
    public void decidirSobreArticulo(Articulo articulo) {
        System.out.println("Ingrese sus comentarios: (en una sola línea y sin \";\")");
        String comentarios = Sistema.sc.nextLine().strip();
        System.out.println("¿Aceptar el artículo? S\\N");
        String respuesta = Sistema.sc.nextLine().strip();
        String decision = respuesta.equalsIgnoreCase("S") ? "Aceptado" : "Rechazado";
        String registro = EstadoRevision.REVISADO + ";" + codigo + ";" + articulo.getCodigo() + ";" + comentarios + ";" + decision;
        try {
            String revisorVieja = Persistencia.busquedaEnArchivo(Archivos.REVISORES, codigo);
            String[] revisorNueva = revisorVieja.split(",");
            revisorNueva[5] = String.valueOf(Integer.parseInt(revisorNueva[5]) + 1);
            Persistencia.modificarLineaDeArchivo(Archivos.REVISORES, revisorVieja,
                    String.join(",", revisorNueva));

            String revisionVieja = Persistencia.busquedaEnArchivo(Archivos.REVISIONES,
                    codigo + ";" + articulo.getCodigo());
            Persistencia.modificarLineaDeArchivo(Archivos.REVISIONES, revisionVieja, registro);

            System.out.println("Revisión enviada con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al enviar revisión");
        }
    }
}

