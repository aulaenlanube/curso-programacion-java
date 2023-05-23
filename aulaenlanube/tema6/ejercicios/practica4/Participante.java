package aulaenlanube.tema6.ejercicios.practica4;

public class Participante {

    protected String nombre;
    protected String apellido;
    protected int edad;

    public Participante(String nombre, String apellido, int edad) throws Exception {

        if (nombre == null || nombre.length() == 0)
            throw new ParticipanteNombreNoValidoException();

        if (apellido == null || apellido.length() == 0)
            throw new ParticipanteApellidoNoValidoException();

        if (edad < 14)
            throw new ParticipanteEdadNoValidaException();

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "[nombre=" + nombre + "]";
    }

}
