package aulaenlanube.tema6.ejercicios.practica4;

import java.util.ArrayList;

public abstract class EventoDeportivo implements Ganador {

    private String nombre;
    private String fecha;
    private String lugar;
    private ArrayList<Participante> participantes;

    public EventoDeportivo(String nombre, String fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.participantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void inscribirParticipante(Participante p) {
        participantes.add(p);
    }

    public abstract ArrayList<Participante> obtenerGanador();

}
