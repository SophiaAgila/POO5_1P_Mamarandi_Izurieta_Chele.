import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Autor {
    private String codigoIdentificacion;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String institucion;
    private String campoInvestigacion;

    public Autor(String codigoIdentificacion, String nombre, String apellido, String correoElectronico, String institucion, String campoInvestigacion) {
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.institucion = institucion;
        this.campoInvestigacion = campoInvestigacion;
    }

    public void subirArticulo(Articulo articulo) {
        // Guardar datos del autor y del artículo en los archivos correspondientes
        guardarDatosAutor();
        articulo.guardarDatosArticulo();
    }

    public void guardarDatosAutor() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("investigadores.txt", true))) {
            writer.write(codigoIdentificacion + "," + nombre + "," + apellido + "," + correoElectronico + "," + institucion + "," + campoInvestigacion);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public void setCodigoIdentificacion(String codigoIdentificacion) {
        this.codigoIdentificacion = codigoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCampoInvestigacion() {
        return campoInvestigacion;
    }

    public void setCampoInvestigacion(String campoInvestigacion) {
        this.campoInvestigacion = campoInvestigacion;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "codigoIdentificacion='" + codigoIdentificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", institucion='" + institucion + '\'' +
                ", campoInvestigacion='" + campoInvestigacion + '\'' +
                '}';
    }
}
