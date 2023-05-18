package aulaenlanube.tema3.ejemplos;
public class Triangulo2 {

    static void filaTriangulo(int n) {
        if (n > 0) {
            System.out.print("* ");
            filaTriangulo(n - 1);
        } else
            System.out.println();
    }

    static void triangulo(int n) {
        if (n > 0) {
            triangulo(n - 1);
            filaTriangulo(n);
        }
    }

    public static void main(String[] args) {
        triangulo(5);
    }
}
