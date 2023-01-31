public class Punto {

    private static int puntos = 1;
    public int x;
    public int y;
    public String nombre;

    public Punto(int x) {
        this.x = x;
        this.y = x;
    }

    public Punto(int x, String nombre) {
        this(x);
        this.nombre = nombre;
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Punto(int x, int y, String nombre) {
        this(x, y);
        this.nombre = nombre;
    }

    public double calcularDistanciaCentro() {
        double z;
        z = Math.sqrt((x * x) + (y * y));
        return z;
    }

    public void mostrarDatos() {
        if (this.nombre == null)
            System.out.println("El punto no tiene nombre, sus datos son:");
        else
            System.out.println("El punto de nombre " + nombre + " tiene los siguientes datos:");
        System.out.println("X=" + x);
        System.out.println("Y=" + y);
        System.out.println("La distancia respecto al centro es " + calcularDistanciaCentro());
        System.out.println("--------------------------------------------------------------");
    }

    public static void getPuntos() {
        System.out.println("Puntos=" + puntos);
    }

    public static void setPuntos(int puntos) {
        Punto.puntos = puntos;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Punto [x=" + x + ", y=" + y + ", nombre=" + nombre + "]";
    }

}
