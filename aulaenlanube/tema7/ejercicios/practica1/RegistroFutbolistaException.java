package aulaenlanube.tema7.ejercicios.practica1;

public class RegistroFutbolistaException extends Exception {
    public RegistroFutbolistaException(Futbolista futbolista) {
        super("No se puede añadir el futbolista '" + futbolista.getNombre() + "' a la posición "
                + futbolista.getPosicion().getNombrePosicion()+": Se ha alcanzado el máximo de jugadores para esa posición");
    }
}
