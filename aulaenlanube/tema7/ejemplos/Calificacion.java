package aulaenlanube.tema7.ejemplos;
import java.util.ArrayList;

public class Calificacion {

    private Modulo modulo;
    private ArrayList<Double> notas;

    public Calificacion(Modulo modulo) {
        this.modulo = modulo;
        this.notas = new ArrayList<>();
    }

    public Modulo getModulo() {
        return modulo;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }
    
}
