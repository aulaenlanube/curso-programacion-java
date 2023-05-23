package aulaenlanube.tema6.ejercicios.practica4;

import java.time.Duration;

public class ParticipanteCarrera extends Participante {

    private Duration tiempo;

    public ParticipanteCarrera(String nombre, String apellido, int edad) throws Exception {
        super(nombre, apellido, edad);        
    }

    public Duration getTiempo() {
        return tiempo;
    }

    public void setTiempo(Duration tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "[" +
                "nombre=" + nombre + " " +
                ", apellido=" + apellido + " " +
                ", edad=" + edad +
                ", tiempo=" + tiempo.toHoursPart() + "h " + tiempo.toMinutesPart() + "min" +
                "]";
    }

}
