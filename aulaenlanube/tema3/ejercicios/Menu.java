package aulaenlanube.tema3.ejercicios;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        int dimension = 10; // aquí va la altura de las figuras

        do {
            mostrarMenu();
            opcion = entrada.nextInt();               

            switch (opcion) {
                case 1:
                    cuadrado(dimension);
                    break;
                case 2:
                    cuadradoSinRelleno(dimension);
                    break;
                case 3:
                    triangulo(dimension);
                    break;
                case 4:
                    trianguloSinRelleno(dimension);
                    break;
            }
        } while (opcion != 5);
        entrada.close();
    }

    /**
     * Muestra el menú de selección de figura
     */
    static void mostrarMenu() {
        System.out.println(
            """                
            
            /-----------------------------------------/
            / Selecciona una opción entre 1 y 5       /
            /-----------------------------------------/
            /  1 - Dibujar cuadrado                   /
            /  2 - Dibujar cuadrado sin relleno       / 
            /  3 - Dibujar triángulo                  /
            /  4 - Dibujar triángulo sin relleno      /
            /  5 - Salir                              /
            /-----------------------------------------/           
            """);
    }

    /**
     * Dibuja un cuadrado con relleno formado por asteriscos
     * 
     * @param n Es el lado del cuadrado
     */
    static void cuadrado(int n) {

        System.out.println();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Dibuja un cuadrado sin relleno formado por asteriscos
     * 
     * @param n Es el lado del cuadrado
     */
    static void cuadradoSinRelleno(int n) {

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || i == n - 1 || j == 0 || j == n - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Dibuja un triángulo formado por asteriscos
     * 
     * @param n El la altura del triángulo
     */
    static void triangulo(int n) {

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Dibuja un triángulo sin relleno formado por asteriscos
     * 
     * @param n Es la altura del triángulo
     */
    static void trianguloSinRelleno(int n) {

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {

                if (i == 0 || i == n - 1 || j == 0 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
