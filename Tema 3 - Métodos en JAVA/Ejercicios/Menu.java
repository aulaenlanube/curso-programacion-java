import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        int dimension = 10; //aquí va la altura de la figura

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

    //método que muestra el menú
    static void mostrarMenu() {
        System.out.println("MENU FIGURAS");
        System.out.println("Selecciona una opción");
        System.out.println("-----------------------------------");
        System.out.println("1 - Dibujar cuadrado");
        System.out.println("2 - Dibujar cuadrado sin relleno");
        System.out.println("3 - Dibujar triángulo");
        System.out.println("4 - Dibujar triángulo sin relleno");
        System.out.println("5 - SALIR");
        System.out.println("-----------------------------------");
    }

    // método que dibuja un rectángulo con relleno
    static void cuadrado(int lado) {

        System.out.println();
        for (int i = 0; i < lado; i++) {

            for (int j = 0; j < lado; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // método que dibuja un rectángulo sin relleno
    static void cuadradoSinRelleno(int lado) {

        System.out.println();
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {

                if (i == 0 || i == lado - 1 || j == 0 || j == lado - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // método que dibuja un triángulo con relleno
    static void triangulo(int altura) {

        System.out.println();
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // método que dibuja un tritángulo sin relleno
    static void trianguloSinRelleno(int altura) {

        System.out.println();
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j <= i; j++) {

                if (i == 0 || i == altura - 1 || j == 0 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
