public class AplicacionPunto {

    public static void main(String[] args) {

        int num = 1;
        String nombre = "Los Strings son inmutables";
        Punto p1 = new Punto(2, "p1");
        Punto p2 = new Punto(1, 3, "p2");
        Punto p3 = new Punto(1, "p3");

        p1.mostrarDatos();
        p2.mostrarDatos();
        p3.mostrarDatos();

        modificarPunto(p1);
        modificarEntero(num);
        modificarString(nombre);

        System.out.println("Punto.x=" + p1.getX());
        System.out.println("num=" + num);
        System.out.println("nombre="+nombre);

        System.out.println(p1);
    }

    public static void mostrarPuntos(Punto... puntos) {

        for (Punto p : puntos) {
            p.mostrarDatos();

        }
    }

    public static void modificarPunto(Punto p) {
        p.setX(999);

    }

    public static void modificarEntero(int n) {
        n = 999;
    }

    public static void modificarString(String s) {
        s = "String modificada";
    }

}
