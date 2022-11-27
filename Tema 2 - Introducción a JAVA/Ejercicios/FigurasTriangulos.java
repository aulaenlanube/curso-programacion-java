public class FigurasTriangulos {

    public static void main(String[] args) {

        final int ALTURA = 10; // poner aquí la altura del triángulo

        triangulo4(ALTURA);
        trianguloSinRelleno4(ALTURA);
    }

    //método que dibuja un triángulo con relleno
    static void triangulo(int altura) {

        System.out.println("\n\n");

        for (int i = 0; i < altura; i++) {
            System.out.print("\t");
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }

    //método que dibuja un triángulo sin relleno
    static void trianguloSinRelleno(int altura) {

        System.out.println("\n\n");

        for (int i = 0; i < altura; i++) {
            System.out.print("\t");
            for (int j = 0; j <= i; j++) {

                if (i == 0 || i == altura - 1 || j == 0 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }

    //método que dibuja un triángulo decreciente con relleno
    static void triangulo2(int altura) {

        System.out.println("\n\n");

        for (int i = altura - 1; i >= 0; i--) {
            System.out.print("\t");
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }

    //método que dibuja un triángulo decreciente sin relleno
    static void trianguloSinRelleno2(int altura) {

        System.out.println("\n\n");

        for (int i = altura - 1; i >= 0; i--) {
            System.out.print("\t");
            for (int j = 0; j <= i; j++) {
                //primera y última fila, primera y última columna
                if (i == 0 || i == altura - 1 || j == 0 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }

    //método que dibuja un triángulo creciente con relleno alineado a la derecha
    static void triangulo3(int altura) {

        System.out.println("\n\n");

        for (int i = 0; i < altura; i++) {
            System.out.print("\t");
            for (int j = 0; j < altura; j++) {
                if (j >= altura - i - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }

    //método que dibuja un triángulo creciente sin relleno alineado a la derecha
    static void trianguloSinRelleno3(int altura) {

        System.out.println("\n\n");

        for (int i = 0; i < altura; i++) {
            System.out.print("\t");
            for (int j = 0; j < altura; j++) {
                //última fila, primera y última columna
                if (i == altura - 1 || j == altura - i - 1 || j == altura - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }

    //método que dibuja un triángulo decreciente con relleno alineado a la derecha
    static void triangulo4(int altura) {

        System.out.println("\n\n");

        for (int i = 0; i < altura; i++) {
            System.out.print("\t");
            for (int j = 0; j < altura; j++) {
                if (j >= i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }

    //método que dibuja un triángulo decreciente sin relleno alineado a la derecha
    static void trianguloSinRelleno4(int altura) {

        System.out.println("\n\n");

        for (int i = 0; i < altura; i++) {
            System.out.print("\t");
            for (int j = 0; j < altura; j++) {

                //primera fila, primera y última columna
                if (i == 0 || j == i || j == altura - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }

}
