public class Editor extends Usuario {
    private String nombreJournal;

    public Editor(String nombre, String apellido, String correoElectronico, String user, String contrasena, String nombreJournal) {
        super(nombre, apellido, correoElectronico, user, contrasena, "E");
        this.nombreJournal = nombreJournal;
    }

    @Override
    public void generarCorreo() {
        String emailDominio= "jorunal.com";
        String email= (nombre+"."+apellido+"@"+emailDominio).toLowerCase().replace("",".");
        this.correoElectronico= email;
    }

    @Override
    public void decidirSobreArticulo() {
         boolean decision = tomarDecision(calidad, relevancia, cumplimientoNormas);
         registrarDecisionFinal(codigoArticulo, decision);
    }

    public registrarDecisionFinal(String codigoArticulo) {
        return boolean;
        
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
