package aulaenlanube.tema2.ejercicios;
public class FigurasRombos {

    public static void main(String[] args) {

        romboTipo1(10,'■');
        System.out.println();

        romboTipo1SinRelleno(10,'■');
        System.out.println();

        romboTipo1Diagonales(10);
        System.out.println();

        romboTipo2(10,'■');
        System.out.println();

        romboTipo2SinRelleno(10,'■');
        System.out.println();

        romboTipo2Creciente(10);
        System.out.println();

        romboTipo2Decreciente(10);
        System.out.println();

        romboTipo2CrecienteHorizontal(10);
        System.out.println();

        romboTipo2DecrecienteHorizontal(10);
        System.out.println();

        romboTipo2CrecienteVertical(10);
        System.out.println();

        romboTipo2DecrecienteVertical(10);
        System.out.println();

        romboDoble(10, '■', '□');
        System.out.println();
    }

    static void romboTipo1(int n, char c) {

        // parte superior
        for (int fila = n; fila >= 1; fila--) {
            for (int espacios = 1; espacios <= fila; espacios++) {
                System.out.print(" ");
            }
            for (int caracteres = fila; caracteres <= n; caracteres++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        // parte inferior
        n--;
        for (int fila = n; fila >= 1; fila--) {
            for (int espacios = fila; espacios <= n; espacios++) {
                System.out.print(" ");
            }
            for (int caracteres = 1; caracteres <= fila; caracteres++) {
                System.out.print(" " + c);
            }
            System.out.println();
        }
    }

    static void romboTipo1SinRelleno(int n, char c) {

        // parte superior
        for (int fila = n; fila >= 1; fila--) {
            for (int espacios = 1; espacios <= fila; espacios++) {
                System.out.print(" ");
            }
            for (int columna = fila; columna <= n; columna++) {
                if (columna == fila || columna == n)
                    System.out.print(c + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        // parte inferior
        n--;
        for (int fila = n; fila >= 1; fila--) {
            for (int j = fila; j <= n; j++) {
                System.out.print(" ");
            }
            for (int columna = 1; columna <= fila; columna++) {
                if (columna == 1 || columna == fila)
                    System.out.print(" " + c);
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

    }

    static void romboTipo1Diagonales(int n) {

        // parte superior
        for (int fila = n; fila >= 1; fila--) {
            for (int espacios = 1; espacios <= fila; espacios++) {
                System.out.print(" ");
            }
            for (int k = fila; k <= n; k++) {
                System.out.print(k % 10 + " ");
            }
            System.out.println();
        }

        // parte inferior
        n--;
        for (int fila = n; fila >= 1; fila--) {
            for (int espacios = fila; espacios <= n; espacios++) {
                System.out.print(" ");
            }
            for (int caracteres = 1; caracteres <= fila; caracteres++) {
                System.out.print(" " + caracteres % 10);
            }
            System.out.println();
        }
    }

    static void romboTipo2(int n, char c) {

        int filas = n / 2 + 1;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");
            }
            // carácter
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        // parte inferior
        filas--; // eliminamos la fila superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
            }
            // carácter
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    static void romboTipo2SinRelleno(int n, char c) {

        int filas = n / 2 + 1;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");
            }
            // carácter
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {

                if (caracter == 1 || caracter == 2 * altura - 1)
                    System.out.print(c + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        // parte inferior
        filas--; // eliminamos la fila superior

        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
            }
            // carácter
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {

                if (caracter == 1 || caracter == (filas - altura) * 2 + 1)
                    System.out.print(c + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void romboTipo2Creciente(int n) {

        int filas = n / 2 + 1;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            int num = 1;
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {
                System.out.print(num + " ");
                if (caracter >= altura)
                    num--;
                else
                    num++;
            }
            System.out.println("");
        }
        // parte inferior
        filas--; // eliminamos la fila superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            int num = 1;
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {
                System.out.print(num + " ");
                if (caracter >= filas - altura + 1)
                    num--;
                else
                    num++;
            }
            System.out.println();
        }
    }

    static void romboTipo2Decreciente(int n) {

        int filas = n / 2 + 1;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            int num = filas;
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {
                System.out.print(num + " ");
                if (caracter >= altura)
                    num++;
                else
                    num--;
            }
            System.out.println("");
        }
        // parte inferior
        filas--; // eliminamos la fila superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            int num = n / 2 + 1;
            ;
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {
                System.out.print(num + " ");
                if (caracter >= filas - altura + 1)
                    num++;
                else
                    num--;
            }
            System.out.println();
        }
    }

    static void romboTipo2CrecienteHorizontal(int n) {

        int filas = n / 2 + 1;
        int cont = 1;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {
                System.out.print(cont + " ");
            }
            System.out.println("");
            cont++;
        }
        // parte inferior
        filas--; // eliminamos la fila superior
        cont = filas;
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {
                System.out.print(cont + " ");
            }
            System.out.println();
            cont--;
        }
    }

    static void romboTipo2DecrecienteHorizontal(int n) {

        int filas = n / 2 + 1;
        int cont = filas;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");

            }
            // caracter
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {
                System.out.print(cont + " ");

            }
            System.out.println("");
            cont--;
        }
        // parte inferior
        filas--; // eliminamos la fila superior
        cont += 2;
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {
                System.out.print(cont + " ");

            }
            System.out.println();
            cont++;
        }
    }

    static void romboTipo2CrecienteVertical(int n) {

        int filas = n / 2 + 1;
        int cont = 1;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");
                cont++;
            }
            // num
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {
                System.out.print(cont + " ");
                if (caracter < altura)
                    cont++;
                else
                    cont--;
            }
            System.out.println("");
            cont = 1;

        }
        // parte inferior
        filas--; // eliminamos la fila superior
        cont = 1;
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
                cont++;
            }
            // num
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {
                System.out.print(cont + " ");
                if (caracter < filas - altura + 1)
                    cont++;
                else
                    cont--;
            }
            System.out.println();
            cont = 1;

        }
    }

    static void romboTipo2DecrecienteVertical(int n) {

        int filas = n / 2 + 1;
        int cont = filas;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");
                cont--;
            }
            // num
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {
                System.out.print(cont + " ");
                if (caracter < altura)
                    cont--;
                else
                    cont++;
            }
            System.out.println("");
            cont = filas;
        }
        // parte inferior
        filas--; // eliminamos la fila superior
        cont = n / 2 + 1;
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
                cont--;
            }
            // num
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {
                System.out.print(cont + " ");
                if (caracter < filas - altura + 1)
                    cont--;
                else
                    cont++;
            }
            System.out.println();
            cont = n / 2 + 1;
        }
    }

    static void romboDoble(int n, char c1, char c2) {

        int filas = n / 2 + 1;

        // parte superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= filas - altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            int num = 1;
            for (int caracter = 1; caracter <= (2 * altura) - 1; caracter++) {
                System.out.print((num % 2 == 1 ? c1 : c2) + " ");
                num++;
            }
            System.out.println();
        }
        // parte inferior
        filas--; // eliminamos la fila superior
        for (int altura = 1; altura <= filas; altura++) {
            // espacios
            for (int espacios = 1; espacios <= altura; espacios++) {
                System.out.print("  ");
            }
            // caracter
            int num = 1;
            for (int caracter = 1; caracter <= (filas - altura) * 2 + 1; caracter++) {
                System.out.print((num % 2 == 1 ? c1 : c2) + " ");
                num++;
            }
            System.out.println();
        }
    }

}
