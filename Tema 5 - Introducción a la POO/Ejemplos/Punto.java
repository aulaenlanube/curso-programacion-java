public class Punto {

    public int x;
    public int y;

    public Punto(int a) {
        x = a;
        y = a;
    }

    public Punto(int a, int b) {
        x = a;
        y = b;
    }

    public double calcularDistanciaCentro() {
        double z;
        z = Math.sqrt((x * x) + (y * y));
        return z;
    }

}
