public class Punto {

    private int x;
    private int y;
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
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

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
        return "[" + nombre + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
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

    public double calcularDistanciaCentro() {
        double z;
        z = Math.sqrt((x * x) + (y * y));
        return z;
    }

    public static boolean distintos(Punto p1, Punto p2) {
        return p1.getX() != p2.getX() || p1.getY() != p2.getY();
    }

    public static boolean distintos(Punto... puntos) {
        for (int i = 0; i < puntos.length; i++) {
            for (int j = i + 1; j < puntos.length; j++) {
                if (puntos[i].getX() == puntos[j].getX() && puntos[i].getY() == puntos[j].getY()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static double distancia(Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public static void areaTriangulo(Punto p1, Punto p2, Punto p3) {

        double a = distancia(p1, p2);
        double b = distancia(p2, p3);
        double c = distancia(p3, p1);
        double s = (a + b + c) / 2;
        double area = (Math.sqrt(s * (s - a) * (s - b) * (s - c)));

        if (area != 0) {
            String tipo = "isósceles";
            if (a == b && b == c)
                tipo = "equilátero";
            else if (a != b && b != c && a != c)
                tipo = "escaleno";            

            System.out.println("El triángulo es " + tipo + " y su área es " + area);
        } else
            System.out.println("ERROR: los puntos no forman un triángulo");
    }
}
