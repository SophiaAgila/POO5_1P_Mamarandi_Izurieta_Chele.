public class Editor extends Usuario {
    private String nombreJournal;

    public Editor(String nombre, String apellido, String correoElectronico, String user, String contrasena, String nombreJournal) {
        super(nombre, apellido, correoElectronico, user, contrasena, "E");
        this.nombreJournal = nombreJournal;
    }

    @Override
    public void generarCorreo() {
        // Implementar lógica para generar correo
    }

    @Override
    public void decidirSobreArticulo() {
        // Implementar lógica para decidir sobre artículo
    }

    public void registrarDecisionFinal(String codigoArticulo, boolean decision) {
        // Implementar lógica para registrar la decisión final sobre el artículo
        // Actualizar archivo revisiones.txt
    }

    // Getters y Setters
    public String getNombreJournal() {
        return nombreJournal;
    }

    public void setNombreJournal(String nombreJournal) {
        this.nombreJournal = nombreJournal;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "nombreJournal='" + nombreJournal + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", user='" + user + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
