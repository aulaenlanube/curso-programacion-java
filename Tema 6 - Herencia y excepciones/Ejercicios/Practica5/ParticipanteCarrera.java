import java.time.Duration;

public class ParticipanteCarrera extends Participante {    
    
    private int edad;
    private Duration tiempo;

    public ParticipanteCarrera(String nombre, String apellido, int edad) throws ParticipanteNoValidoException {
        super(nombre, apellido);
        if (nombre == null || apellido == null || edad == 0) {
            throw new ParticipanteNoValidoException("Los atributos de un participante no pueden ser nulos.");
        }
        this.edad = edad;
    }  

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Duration getTiempo() {
        return tiempo;
    }

    public void setTiempo(Duration tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "ParticipanteCarrera{" +
                "nombre=" + super.getNombre() + " " +
                ", apellido=" + super.getApellido() + " " +
                ", edad=" + edad +
                ", tiempo=" + tiempo.toHoursPart() + "h "+tiempo.toMinutesPart()+"min"+
                "}";
    }

    public String toStringEquipo() {
        return super.getNombre() + " " + super.getApellido();

    }
}
