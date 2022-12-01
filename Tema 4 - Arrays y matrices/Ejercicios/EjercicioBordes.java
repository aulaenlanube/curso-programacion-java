public class EjercicioBordes {

    static final char LINEA_VERTICAL = '║';
    static final char LINEA_HORIZONTAL = '═';
    static final char ESQUINA_SUP_IZQ = '╔';
    static final char ESQUINA_INF_IZQ = '╚';
    static final char ESQUINA_SUP_DER = '╗';
    static final char ESQUINA_INF_DER = '╝';
    static final char SEPARADOR_SUP = '╦';
    static final char SEPARADOR_INF = '╩';

    static final int BORDE_SUP = 0;
    static final int BORDE_INF = 1;

    public static void main(String[] args) {

        String texto = """
                Programación en JAVA
                Tema 4
                Estamos haciendo ejercicios de repaso
                """;

        mostrarTituloConBorde("Hoy es jueves, 1 de diciembre de 2022");
        mostrarTituloConBorde(texto);

    }

    static void mostrarTituloConBorde(String texto) {

        // pasamos a mayúsculas
        texto = texto.toUpperCase();

        // obtenemos un array de Strings
        String[] lineas = texto.split("\n");

        // obtenemos la longitud de la línea más larga
        int lineaMax = obtenerLineaMax(lineas);

        // borde superior
        imprimirBorde(BORDE_SUP, lineaMax);

        // líneas centrales
        imprimirLineas(lineas, lineaMax);

        // borde inferior
        imprimirBorde(BORDE_INF, lineaMax);
    }

    static int obtenerLineaMax(String[] lineas) {
        int lineaMax = 0;
        for (String lineaActual : lineas) {
            if (lineaActual.length() > lineaMax)
                lineaMax = lineaActual.length();
        }
        return lineaMax;
    }

    static void imprimirLineas(String[] lineas, int lineaMax) {
        for (int i = 0; i < lineas.length; i++) {
            System.out.print(LINEA_VERTICAL + "  ");
            for (int j = 0; j < lineaMax; j++) {
                if (j < lineas[i].length())
                    System.out.print(lineas[i].charAt(j) + " ");
                else
                    System.out.print("  ");
            }
            System.out.println(" " + LINEA_VERTICAL);
        }
    }

    static void imprimirBorde(int tipoBorde, int ancho) {

        System.out.print(tipoBorde == BORDE_SUP ? ESQUINA_SUP_IZQ : ESQUINA_INF_IZQ);
        for (int i = 0; i < ancho * 2 + 3; i++)
            System.out.print(LINEA_HORIZONTAL);
        System.out.println(tipoBorde == BORDE_SUP ? ESQUINA_SUP_DER : ESQUINA_INF_DER);

    }
}
