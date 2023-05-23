package aulaenlanube.tema6.ejercicios.practica4;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Carrera extends EventoDeportivo {

    private double distancia;

    public Carrera(String nombre, LocalDate fecha, String lugar, double distancia) {
        super(nombre, fecha, lugar);
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public ArrayList<Participante> obtenerGanador() {

        ArrayList<Participante> ganadores = new ArrayList<>();
        Participante ganador = null;
        Duration menorTiempo = null;

        for (Participante participante : getParticipantes()) {
            ParticipanteCarrera p = (ParticipanteCarrera) participante;
            if (menorTiempo == null || p.getTiempo().compareTo(menorTiempo) < 0) {
                menorTiempo = p.getTiempo();
                ganador = p;
            }
        }
        ganadores.add(ganador);
        return ganadores;
    }

    @Override
    public void mostrarGanador() {

        Participante ganador = obtenerGanador().get(0);
        System.out.println(
                "El ganador de la " + getNombre() + " ha sido " + ganador.getNombre() + " " + ganador.getApellido());
    }

}
