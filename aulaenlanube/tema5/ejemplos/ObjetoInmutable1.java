package aulaenlanube.tema5.ejemplos;

public final class ObjetoInmutable1 {

    private final int n;
    private final String s;
    private final Punto p;

    public ObjetoInmutable1(int n, String s, Punto p) {
        this.n = n;
        this.s = s;
        this.p = new Punto(p.getX(), p.getY());
    }

    public int getN() {
        return n;
    }

    public String getS() {
        return s;
    }

    public Punto getPunto() {
        return new Punto(p.getX(), p.getY());
    }
}
