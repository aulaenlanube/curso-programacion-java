import java.util.Scanner;

class MenuExamen {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String opcion = "";

        do {
            mostrarMenu();
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    dibujarFiguraExamen(6);
                    break;
                case "2":
                    cantidadPalabras("Hoy es viernes, 25 de noviembre de 2022", 3);
                    break;
                case "3":
                    invertirString("Hoy es viernes, 25 de noviembre de 2022", 0);
                    break;
                case "4":
                    invertirArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, " - ");
                    break;
                case "5":
                    salir();
                    break;
                default:
                    opcionNoValida();
            }
        } while (!opcion.equals("5"));
        entrada.close();
    }

    /**
     * Dibuja un cuadrado formado por enteros que imprime en cada fila un entero,
     * empezando por el 1 hasta llegar a n. En las siguientes filas en valor de
     * decrementa hasta llegar a 1.
     * <p>
     * Ejemplo para n = 3
     * <p>
     * 1 1 1 1 1
     * <p>
     * 2 2 2 2 2
     * <p>
     * 3 3 3 3 3
     * <p>
     * 2 2 2 2 2
     * <p>
     * 1 1 1 1 1
     * <p>
     * 
     * @param n - Valor máximo que se mostrará en la fila central del cuadrado.
     */
    static void dibujarFiguraExamen(int n) {
        if (n > 9)
            System.out.println("Figura no válida");
        else {

            int dim = n * 2 - 1;
            for (int i = 1; i <= dim; i++) {

                for (int j = 1; j <= dim; j++) {

                    if (i <= n)
                        System.out.print(i + " ");
                    else
                        System.out.print(n * 2 - i + " ");
                }
                System.out.println();
            }
        }

    }

    /**
     * Método recursivo que muestra una string de forma invertida
     * 
     * @param s   - Cadena de texto a invertir
     * @param pos - Contador para recorrer la String, debe ser 0
     */
    static void invertirString(String s, int pos) {

        if (pos < s.length()) {
            invertirString(s, pos + 1);
            System.out.print(s.charAt(pos));
        }
    }

    /**
     * Cuenta la cantidad de palabras de una longitud mínima.
     * 
     * @param s - Cadena de texto que se debe analizar
     * @param n - Longitud mínima de las palabras que debe contar
     */
    static void cantidadPalabras(String s, int n) {

        int cantidadPalabras = 0;
        int contadorPalabraActual = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ')
                contadorPalabraActual++;
            else {
                if (contadorPalabraActual >= n)
                    cantidadPalabras++;
                contadorPalabraActual = 0;
            }
        }
        // analizamos de nuevo contadorPalabraActual, caso cuando la última letra del
        // String no es un espacio en blanco
        if (contadorPalabraActual >= n)
            cantidadPalabras++;

        System.out.println("Hay " + cantidadPalabras + " palabras");
    }

    /**
     * Método que imprime un Array de forma invertida utilizando un separador para
     * los elementos intermedios.
     * 
     * @param n - Array de enteros con los elementos que se mostrarán de forma
     *          invertida.
     * @param s - Separador utilizado para los elementos intermedios.
     */
    static void invertirArray(int[] n, String s) {

        for (int i = n.length - 1; i > 0; i--) {
            System.out.print(n[i] + s);
        }
        System.out.println(n[0]);
    }

    /**
     * Muestra un ménu personalizado con las opciones del examen
     */
    static void mostrarMenu() {
        String s = """


                ╔═══════════════════════════════════╗
                ║       M E N Ú    E X A M E N      ║
                ║═══════════════════════════════════║
                ║    1 - Dibujar figura             ║
                ║    2 - Analizar String            ║
                ║    3 - Recursivo                  ║
                ║    4 - Arrays                     ║
                ║    5 - Salir                      ║
                ╚═══════════════════════════════════╝


                """;
        System.out.println(s);
    }

    /**
     * Muestra un mensaje personalizado de ERROR al seleccionar una opción no válida
     */
    static void opcionNoValida() {

        String s = """

                ╔═════════════════════════════════════════════════════╗
                ║ ERROR:  Debes seleccionar una opción entre 1 y 5    ║
                ╚═════════════════════════════════════════════════════╝
                    """;
        System.out.println(s);

    }

    /**
     * Muestra un mensaje de despedida
     */
    static void salir() {

        String s = """

                ╔══════════════════════════════════════════════╗
                ║ Ha sido un honor servirle, hasta la próxima  ║
                ╚══════════════════════════════════════════════╝
                    """;
        System.out.println(s);
    }
}