package aulaenlanube.tema6.ejemplos;
public abstract class Figura2D {

    private int numeroLados;

    public Figura2D(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    public abstract double area();

    @Override
    public String toString() {
        return "Figura [numeroLados=" + numeroLados + "]";
    }
}
