package practica4;
import java.util.ArrayList;

public class Equipo  {

    private String nombre;
    private ArrayList<Participante> jugadores;
    private int puntos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.jugadores = new ArrayList<>();        
    }

    public ArrayList<Participante> getJugadores() {
        return jugadores;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void añadirJugador(Participante jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(Participante jugador) throws JugadorNoEncontradoException {
        boolean encontrado = jugadores.remove(jugador);
        if (!encontrado) {
            throw new JugadorNoEncontradoException("El jugador " + jugador.getNombre() + " " + jugador.getApellido()
                    + " no se encuentra en el equipo.");
        }
    }

    @Override
    public String toString() {
        String s = "Equipo: " + nombre + "\n";
        for (Participante p : jugadores) {
            s += p.toString();
        }
        return s;
    }
}
