public class Participante {

    private String nombre; 
    private String apellido;   

    public Participante(String nombre, String apellido) throws ParticipanteNoValidoException{
        if (nombre == null || apellido == null ) {
            throw new ParticipanteNoValidoException("Los atributos de un participante no pueden ser nulos.");
        }
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public String toString() {
        return "Participante [nombre=" + nombre + "]";
    }
    
}
