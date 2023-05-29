package aulaenlanube.tema7.ejercicios.practica1;

import java.util.*;

public class Equipo {

    private static final Map<Posicion, Integer> MAX_FUTBOLISTAS_POSICION = new HashMap<>();
    static {
        MAX_FUTBOLISTAS_POSICION.put(Posicion.PORTERO, 2);
        MAX_FUTBOLISTAS_POSICION.put(Posicion.DEFENSA, 5);
        MAX_FUTBOLISTAS_POSICION.put(Posicion.CENTROCAMPISTA, 5);
        MAX_FUTBOLISTAS_POSICION.put(Posicion.DELANTERO, 4);
    }

    private String nombre;
    private List<Futbolista> futbolistas;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.futbolistas = new ArrayList<>();
    }

    public void agregarFutbolista(Futbolista futbolista) {

        try {
            //obtenemos la cantidad de jugadores en la posición del jugador que queremos añadir
            int futbolistasPosicion = obtenerJugadoresPosicion(futbolista.getPosicion());

            //si se ha llegado al máximo en esa posición, lanzamos excepción
            if (futbolistasPosicion == MAX_FUTBOLISTAS_POSICION.get(futbolista.getPosicion())) {
                throw new RegistroFutbolistaException(futbolista);
            }
            //añadimos futbolista al equipo
            futbolistas.add(futbolista);
            futbolista.agregarEquipo(this.nombre);

        } catch (RegistroFutbolistaException e) {
            System.out.println(e.getMessage());
        }
    }

    private int obtenerJugadoresPosicion(Posicion posicion) {
        int contador = 0;
        for (Futbolista futbolista : futbolistas) {
            if (futbolista.getPosicion() == posicion)
                contador++;
        }
        return contador;
    }

    public void listarFormacionDelEquipo() {

        //ordenamos jugadores del equipo por posición
        futbolistas.sort(new Comparator<Futbolista>() {
            @Override
            public int compare(Futbolista o1, Futbolista o2) {
                return Integer.compare(prioridadPosicion(o1.getPosicion()), prioridadPosicion(o2.getPosicion()));
            }
            public int prioridadPosicion(Posicion posicion) {
                switch (posicion) {
                    case PORTERO:         return 1;
                    case DEFENSA:         return 2;
                    case CENTROCAMPISTA:  return 3;
                    case DELANTERO:       return 4;
                }
                return 0;
            }
        });

        //mostramos los jugadores del equipo ordenados
        Iterator<Futbolista> iteratorEquipo = futbolistas.iterator();
        while(iteratorEquipo.hasNext()) {
            System.out.println(iteratorEquipo.next());
        }
    }
}
