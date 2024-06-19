import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Revisor {
    private int userId;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contraseña;
    private String especialidad;
    private int numArticulos;

    public Revisor(int userId, String nombre, String apellido, String correoElectronico, String contraseña, String especialidad, int numArticulos) {
        this.userId = userId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.especialidad = especialidad;
        this.numArticulos = numArticulos;
    }

    public void aceptarAsignacion() {
        // metodo para aceptarAsignacion 
    }

    public void guardarDatosRevisor() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("revisores.txt", true))) {
            writer.write(userId + "," + nombre + "," + apellido + "," + correoElectronico + "," + contraseña + "," + especialidad + "," + numArticulos);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumArticulos() {
        return numArticulos;
    }

    public void setNumArticulos(int numArticulos) {
        this.numArticulos = numArticulos;
    }

    @Override
    public String toString() {
        return "Revisor{" +
                "userId=" + userId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", numArticulos=" + numArticulos +
                '}';
    }
}
