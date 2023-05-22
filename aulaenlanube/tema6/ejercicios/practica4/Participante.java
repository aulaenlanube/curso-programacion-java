package aulaenlanube.tema6.ejercicios.practica4;

public class Participante {

    private String nombre;
    private String apellido;

    public Participante(String nombre, String apellido) throws ParticipanteNoValidoException {
        if (nombre == null || nombre.length() == 0)
            throw new ParticipanteNoValidoException(ParticipanteNoValidoException.NOMBRE_NO_VALIDO);
        if (apellido == null || apellido.length() == 0)
            throw new ParticipanteNoValidoException(ParticipanteNoValidoException.APELLIDO_NO_VALIDO);

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
