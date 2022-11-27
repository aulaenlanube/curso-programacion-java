public class FigurasComplejas {

    public static void main(String[] args) {

        ejercicio1(5,'3','2');
        System.out.println();

        ejercicio9(5);
        System.out.println();
    }

    static void ejercicio1(int n, char c1, char c2) {

        int contador = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1)
                    System.out.print((contador % 2 == 0 ? c1 : c2) + " ");
                else
                    System.out.print("  ");
                contador++;
            }
            System.out.println();
        }
    }

    static void ejercicio2Impar(int n, char c) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n / 2 || j == n / 2)
                    System.out.print(c + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void ejercicio2Par(int n, char c) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n / 2)
                    System.out.print(c + " ");
                else if (j == n / 2)
                    System.out.print("\b" + c);
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void ejercicio2(int n, char c) {

        if (n % 2 == 0)
            ejercicio2Par(n, c);
        else
            ejercicio2Impar(n, c);
    }

    static void ejercicio3(int base, int altura, char c) {

        for (int i = 0; i < altura; i++) {

            for (int j = 0; j < base + i; j++) {
                if (j > i)
                    System.out.print(c + " ");
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void ejercicio4(int n) {
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            cont = i;
            for (int j = 1; j <= n; j++) {
                System.out.print(cont % 10 + " ");
                if (j >= i)
                    cont++;
            }
            System.out.println();
        }
    }

    static void ejercicio5(int n) {
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            cont = 1;
            for (int j = 1; j <= n; j++) {
                System.out.print(cont % 10 + " ");
                if (j < i)
                    cont++;
            }
            System.out.println();
        }
    }

    static void ejercicio6(int n) {
        int cont = 0;
        for (int i = n; i >= 1; i--) {
            cont = 1;
            for (int j = 1; j <= n; j++) {
                System.out.print(cont % 10 + " ");
                if (j < i)
                    cont++;
            }
            System.out.println();
        }
    }

    static void ejercicio7(int n) {
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            cont = i;
            for (int j = n; j >= 1; j--) {
                System.out.print(cont % 10 + " ");
                if (j <= i)
                    cont--;
            }
            System.out.println();
        }
    }

    static void ejercicio8(int n) {
        for (int i = 0; i < n; i++) {
            int cont = i;
            for (int j = 0; j < n; j++) {
                cont++;
                System.out.print(cont % 10 + " ");
            }
            System.out.println();
        }
    }

    static void ejercicio9(int n) {
        for (int i = 0; i < n; i++) {
            int cont = 0;
            for (int j = 0; j < n; j++) {
                if (i >= j)
                    cont++;
                if (j >= n - i)
                    cont--;
                System.out.print(cont % 10 + " ");
            }
            System.out.println();
        }
    }

    //ejer extra
    static void ejercicio10(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i || j == n - i + 1)
                    System.out.print(i % 10 + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();
        }
    }

    //ejer extra
    static void ejercicio11(int n) {

        for (int i = 0; i < n; i++) {
            int cont = 1;
            if (i >= n / 2)
                cont += 2;
            for (int j = 0; j < n; j++) {
                if (j == n / 2)
                    cont++;
                System.out.print(cont % 10 + " ");
            }
            System.out.println();
        }
    }

}

