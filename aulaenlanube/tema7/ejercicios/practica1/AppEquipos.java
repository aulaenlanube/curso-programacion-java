package aulaenlanube.tema7.ejercicios.practica1;

public class AppEquipos {

    public static void main(String[] args) {

        Equipo equipo = new Equipo("Valencia");
       
        equipo.agregarFutbolista(new Futbolista("Portero_1", 22, Posicion.PORTERO));
        equipo.agregarFutbolista(new Futbolista("Centrocampista_1", 24, Posicion.CENTROCAMPISTA));
        equipo.agregarFutbolista(new Futbolista("Defensa_1", 25, Posicion.DEFENSA));
        equipo.agregarFutbolista(new Futbolista("Delantero_1", 21, Posicion.DELANTERO));
        equipo.agregarFutbolista(new Futbolista("Delantero_2", 24, Posicion.DELANTERO));
        equipo.agregarFutbolista(new Futbolista("Portero_2", 32, Posicion.PORTERO));
        equipo.agregarFutbolista(new Futbolista("Portero_3", 33, Posicion.PORTERO));
        equipo.agregarFutbolista(new Futbolista("Delantero_3", 31, Posicion.DELANTERO));
        equipo.agregarFutbolista(new Futbolista("Delantero_4", 33, Posicion.DELANTERO));
        equipo.agregarFutbolista(new Futbolista("Delantero_5", 30, Posicion.DELANTERO));
        equipo.agregarFutbolista(new Futbolista("Defensa_2", 30, Posicion.DEFENSA));
        equipo.agregarFutbolista(new Futbolista("Centrocampista_2", 36, Posicion.CENTROCAMPISTA));
        equipo.agregarFutbolista(new Futbolista("Centrocampista_3", 22, Posicion.CENTROCAMPISTA));
        equipo.agregarFutbolista(new Futbolista("Defensa_3", 28, Posicion.DEFENSA));

        equipo.listarFormacionDelEquipo();
    }
}
