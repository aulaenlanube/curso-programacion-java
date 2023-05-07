import java.util.ArrayList;
import java.util.List;

public class TorneoDeFutbol extends EventoDeportivo {
    private List<Equipo> equipos;

    public TorneoDeFutbol(String nombre, String fecha, String lugar) {
        super(nombre, fecha, lugar);
        this.equipos = new ArrayList<>();
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void inscribirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    @Override
    public ArrayList<Participante> obtenerGanador() {
        ArrayList<Participante> ganadores = new ArrayList<>();
        Equipo ganador = null;
        int maxPuntos = Integer.MIN_VALUE;
        for (Equipo e : equipos) {
            if (e.getPuntos() > maxPuntos) {
                maxPuntos = e.getPuntos();
                ganador = e;
            }
        }
        //recorremos los jugadores del equipo ganador
        for (Participante p : ganador.getJugadores()) {
            ganadores.add(p);            
        }
        return ganadores;
    }
}
