package aulaenlanube.tema6.ejercicios.practica4;

import java.time.Duration;
import java.time.LocalDate;

public class Practica4Main {

    public static void main(String[] args) {

        // CARRERA
        Carrera maratonValencia = new Carrera("Maratón de Valencia", LocalDate.of(2023, 12, 3), "Valencia", 42.195);
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

            maratonValencia.mostrarGanador();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // TORNEO DE FÚTBOL
        TorneoDeFutbol torneoDeFutbol = new TorneoDeFutbol("Liga", LocalDate.of(2023, 1, 1), "España");

        Equipo vlc = new Equipo("Valencia C.F.");
        Equipo bcn = new Equipo("Barcelona F.C");

        try {
            Participante p1 = new Participante("Pep", "Gómez", 20);
            Participante p2 = new Participante("Tom", "García", 22);
            Participante p3 = new Participante("Jon", "Pérez", 23);
            Participante p4 = new Participante("Kal", "Martínez", 19);

            torneoDeFutbol.inscribirEquipo(vlc);
            torneoDeFutbol.inscribirEquipo(bcn);

            vlc.añadirJugador(p1);
            vlc.añadirJugador(p2);
            bcn.añadirJugador(p3);
            bcn.añadirJugador(p4);

            vlc.setPuntos(82);
            bcn.setPuntos(80);

            // ganador torneo de fútbol
            torneoDeFutbol.mostrarGanador();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
