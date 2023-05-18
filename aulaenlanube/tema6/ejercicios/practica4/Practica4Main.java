package aulaenlanube.tema6.ejercicios.practica4;
import java.time.Duration;

public class Practica4Main {

    public static void main(String[] args) {

        // CARRERA
        Carrera maratonValencia = new Carrera("Maratón de Valencia", "03-12-2023", "Valencia", 42.195);
        try {
            ParticipanteCarrera p1 = new ParticipanteCarrera("Pep", "Gómez", 20);
            ParticipanteCarrera p2 = new ParticipanteCarrera("Tom", "García", 25);
            ParticipanteCarrera p3 = new ParticipanteCarrera("Jon", "Pérez", 40);
            ParticipanteCarrera p4 = new ParticipanteCarrera("Kal", "Martínez", 35);

            maratonValencia.inscribirParticipante(p1);
            maratonValencia.inscribirParticipante(p2);
            maratonValencia.inscribirParticipante(p3);
            maratonValencia.inscribirParticipante(p4);

            p1.setTiempo(Duration.ofHours(2).plusMinutes(40));
            p2.setTiempo(Duration.ofHours(3).plusMinutes(10));
            p3.setTiempo(Duration.ofHours(2).plusMinutes(25));
            p4.setTiempo(Duration.ofHours(2).plusMinutes(55));

            System.out.println(maratonValencia.obtenerGanador());

        } catch (ParticipanteNoValidoException e) {
            System.out.println(e);
        }

        //ganador carrera
        maratonValencia.obtenerGanador();

        // TORNEO DE FÚTBOL
        TorneoDeFutbol torneoDeFutbol = new TorneoDeFutbol("Liga", "01-01-2023", "España");

        Equipo vlc = new Equipo("Valencia C.F.");
        Equipo bcn = new Equipo("Barcelona F.C");

        try {
            Participante p1 = new Participante("Pep", "Gómez");
            Participante p2 = new Participante("Tom", "García");
            Participante p3 = new Participante("Jon", "Pérez");
            Participante p4 = new Participante("Kal", "Martínez");

            torneoDeFutbol.inscribirEquipo(vlc);
            torneoDeFutbol.inscribirEquipo(bcn);

            vlc.añadirJugador(p1);
            vlc.añadirJugador(p2);
            bcn.añadirJugador(p3);
            bcn.añadirJugador(p4);

            vlc.setPuntos(82);
            bcn.setPuntos(80);

        } catch (ParticipanteNoValidoException e) {
            System.out.println(e);
        }

        //ganador torneo de fútbol
        System.out.println(torneoDeFutbol.obtenerGanador());
    }

}
