public class EjercicioBordes {

    static final char LINEA_VERTICAL = '║';
    static final char LINEA_HORIZONTAL = '═';
    static final char ESQUINA_SUP_IZQ = '╔';
    static final char ESQUINA_INF_IZQ = '╚';
    static final char ESQUINA_SUP_DER = '╗';
    static final char ESQUINA_INF_DER = '╝';
    static final char SEPARADOR_SUP = '╦';
    static final char SEPARADOR_INF = '╩';

    static final char SEPARADOR_IZQ = '╠';
    static final char SEPARADOR_DER = '╣';
    static final char SEPARADOR_CRUZ = '╬';

    static final int BORDE_SUP = 0;
    static final int BORDE_INF = 1;

    public static void main(String[] args) {

        int[][] nums1 = { { 1, 2 }, { 4, 5, 6, 7 }, { 8 }, { 2, 3, 1 }, { 3, 6, 5 } };
        int[][] nums2 = { { 121, 42 }, { 4, 35, 6, 127 }, { 12 }, { 23, 3, 42, 8 }, { 3, 16, 8 } };
        int[][] nums3 = { {}, { 11, 2, 3 }, { 415, 5 }, { 1 }, {}, {} };

        mostrarTextoConBordes("BORDES EN MATRICES");
        mostrarArrayConBordes(new int[] { 1, -2, -112, 564, 23, 1, 2323, 2, 3 });
        mostrarMatrizConBordes(nums1);
        mostrarMatrizConBordes(nums2);
        mostrarMatrizConBordes(nums3);
    }

    static void mostrarArrayConBordes(int[] array) {
        System.out.println(crearStringArrayConBordes(array));
    }

    static void mostrarMatrizConBordes(int[][] matriz) {
        System.out.println(crearStringMatrizConBordes(matriz));
    }

    static String crearStringArrayConBordes(int[] array) {

        String arrayConBordes = "";

        if (array.length > 0) {
            arrayConBordes += obtenerBordeSuperiorArray(array) + "\n";
            arrayConBordes += obtenerStringEnteros(array) + "\n";
            arrayConBordes += obtenerBordeInferiorArray(array) + "\n";
        }

        return arrayConBordes;
    }

    static String crearStringMatrizConBordes(int[][] matriz) {

        String matrizConBordes = "";

        if (matriz.length > 0) {
            matrizConBordes += obtenerBordeSuperiorArray(matriz[0]) + "\n";
            matrizConBordes += obtenerParteCentralMatriz(matriz);
            matrizConBordes += obtenerBordeInferiorArray(matriz[matriz.length - 1]) + "\n";
        }

        return matrizConBordes;
    }

    static String obtenerParteCentralMatriz(int[][] matriz) {

        String parteCentralMatriz = "";

        // recorremos cada fila de la matriz
        for (int i = 0; i < matriz.length; i++) {

            // añadir una String con los enteros de la fila actual
            parteCentralMatriz += obtenerStringEnteros(matriz[i]) + "\n";

            // si no es la última fila, obtenemos el borde intermedio
            if (i < matriz.length - 1) {

                // añadir la String con el borde intermedio
                parteCentralMatriz += obtenerBordeIntermedio(matriz[i], matriz[i + 1]) + "\n";
            }
        }
        return parteCentralMatriz;
    }

    static String obtenerBordeIntermedio(int[] filaActual, int[] filaInferior) {

        // array con los separadores de la fila actual
        int[] posicionesSeparadoresInferiores = posicionarSeparadores(filaActual);
        int anchoFilaActual = obtenerAnchoFila(posicionesSeparadoresInferiores);

        // array con los separadores de la fila inferior
        int[] posicionesSeparadoresSuperiores = posicionarSeparadores(filaInferior);
        int anchoFilaInferior = obtenerAnchoFila(posicionesSeparadoresSuperiores);

        // creamos un array de char para guardar cada uno de los caracteres
        int anchoBorde = anchoFilaActual > anchoFilaInferior ? anchoFilaActual : anchoFilaInferior;
        char[] bordeIntermedio = new char[anchoBorde];

        // establecemos las líneas horizontales y los separadores
        bordeIntermedio = establecerHorizontalesConSeparadores(bordeIntermedio, posicionesSeparadoresInferiores,
                posicionesSeparadoresSuperiores);

        // establecemos las esquinas
        bordeIntermedio = establecerEsquinas(bordeIntermedio, anchoFilaActual, anchoFilaInferior);

        // generar String a partir del array
        String bordeIntermedioFinal = "";
        for (char c : bordeIntermedio) {
            bordeIntermedioFinal += c;
        }
        return bordeIntermedioFinal;
    }

    private static char[] establecerEsquinas(char[] bordeIntermedio, int anchoFilaActual, int anchoFilaInferior) {

        //casos con arrays sin elementos
        if(anchoFilaActual == 1 || anchoFilaInferior == 1) {

            //si ambos tienen un array sin elementos
            if(anchoFilaActual == 1 && anchoFilaInferior == 1) {
                bordeIntermedio = new char[2];
                bordeIntermedio[0] = SEPARADOR_IZQ;
                bordeIntermedio[1] = SEPARADOR_DER;
            }
            //si la fila de arriba tiene elementos y la de bajo no
            else if(anchoFilaActual > 1 && anchoFilaInferior == 1) {
                bordeIntermedio[1] = SEPARADOR_SUP;
                bordeIntermedio[bordeIntermedio.length-1] = ESQUINA_INF_DER;
            }
            //si la fila de bajo tiene elementos y la de arriba no
            else if(anchoFilaActual == 1 && anchoFilaInferior > 1) {
                bordeIntermedio[1] = SEPARADOR_INF;
                bordeIntermedio[bordeIntermedio.length-1] = ESQUINA_SUP_DER;
            }
        }
        //casos con arrays con elementos
        else if (anchoFilaActual > anchoFilaInferior)
            bordeIntermedio[bordeIntermedio.length - 1] = ESQUINA_INF_DER;
        else if (anchoFilaActual < anchoFilaInferior)
            bordeIntermedio[bordeIntermedio.length - 1] = ESQUINA_SUP_DER;
        else
            bordeIntermedio[bordeIntermedio.length - 1] = SEPARADOR_DER;

        return bordeIntermedio;
    }

    private static char[] establecerHorizontalesConSeparadores(char[] bordeIntermedio,
            int[] posicionesSeparadoresInferiores, int[] posicionesSeparadoresSuperiores) {

        // ponemos el separador izquierdo
        bordeIntermedio[0] = SEPARADOR_IZQ;

        // separadores inferiores
        bordeIntermedio = establecerSeparadoresInferiores(bordeIntermedio, posicionesSeparadoresInferiores);

        // separadores superiores
        bordeIntermedio = establecerSeparadoresSuperiores(bordeIntermedio, posicionesSeparadoresSuperiores);

        return bordeIntermedio;
    }

    private static char[] establecerSeparadoresInferiores(char[] bordeIntermedio,
            int[] posicionesSeparadoresInferiores) {

        int contadorPosicionBorde = 1; // empezamos en 1, la pos 0 es del SEPARADOR_IZQ
        for (int i = 0; i < posicionesSeparadoresInferiores.length; i++) {

            // ponemos líneas horizontales
            for (int j = 0; j < posicionesSeparadoresInferiores[i]; j++) {
                bordeIntermedio[contadorPosicionBorde] = LINEA_HORIZONTAL;
                contadorPosicionBorde++;
            }
            // ponemos el separador inferior
            bordeIntermedio[contadorPosicionBorde] = SEPARADOR_INF;
            contadorPosicionBorde++;
        }
        return bordeIntermedio;
    }

    private static char[] establecerSeparadoresSuperiores(char[] bordeIntermedio,
            int[] posicionesSeparadoresSuperiores) {

        int contadorPosicionBorde = 1; // empezamos en 1, la pos 0 es del SEPARADOR_IZQ
        for (int i = 0; i < posicionesSeparadoresSuperiores.length; i++) {

            // ya están puestas las líneas horizontales, pero pueden faltar
            for (int j = 0; j < posicionesSeparadoresSuperiores[i]; j++) {

                if (bordeIntermedio[contadorPosicionBorde] == '\u0000') // si no hay nada, añadimos horizontal
                    bordeIntermedio[contadorPosicionBorde] = LINEA_HORIZONTAL;
                contadorPosicionBorde++;
            }
            // si tenemo separador en la misma posición, ponemos la cruz
            if (bordeIntermedio[contadorPosicionBorde] == SEPARADOR_INF)
                bordeIntermedio[contadorPosicionBorde] = SEPARADOR_CRUZ;
            // de lo contrario, ponemos separador sup únicamente
            else
                bordeIntermedio[contadorPosicionBorde] = SEPARADOR_SUP;
            contadorPosicionBorde++;
        }
        return bordeIntermedio;
    }

    static int[] posicionarSeparadores(int[] fila) {

        // colocamos un índice en la posición de cada separador
        int[] posicionesSeparadores = new int[fila.length];
        for (int i = 0; i < posicionesSeparadores.length; i++) {
            posicionesSeparadores[i] = digitos(Math.abs(fila[i])) + 2; // +2 por los espacios en blanco
            if (fila[i] < 0) // si es negativo, añadimos un espacio
                posicionesSeparadores[i]++;
        }
        return posicionesSeparadores;
    }

    static int obtenerAnchoFila(int[] posicionesSeparadores) {

        int anchoFila = 1; // carácter inicial, separador vertical
        for (int i = 0; i < posicionesSeparadores.length; i++) {
            anchoFila += posicionesSeparadores[i] + 1; // +1 por añadir el separador
        }
        return anchoFila;
    }

    static String obtenerStringEnteros(int[] array) {

        String enterosFila = "";

        // imprimimos los enteros
        enterosFila += LINEA_VERTICAL;
        for (int i = 0; i < array.length; i++) {
            enterosFila += " " + array[i] + " " + LINEA_VERTICAL;
        }

        // si tenemos un array sin elementos
        if (array.length == 0)
            enterosFila += LINEA_VERTICAL;

        return enterosFila;
    }

    static String obtenerBordeSuperiorArray(int[] array) {
        return obtenerBordeArray(array, BORDE_SUP);
    }

    static String obtenerBordeInferiorArray(int[] array) {
        return obtenerBordeArray(array, BORDE_INF);
    }

    static String obtenerBordeArray(int[] array, int tipoBorde) {

        String borde = "";

        // imprimimos la esquina suprior izquierda
        borde += tipoBorde == BORDE_SUP ? ESQUINA_SUP_IZQ : ESQUINA_INF_IZQ;

        // por cada entero del Array
        for (int i = 0; i < array.length; i++) {

            // imprimimos las líneas horizontales
            int lineas = digitos(Math.abs(array[i])) + 2;
            if (array[i] < 0)
                lineas++;
            for (int j = 0; j < lineas; j++)
                borde += LINEA_HORIZONTAL;

            // imprimimos el separador
            if (i < array.length - 1)
                borde += tipoBorde == BORDE_SUP ? SEPARADOR_SUP : SEPARADOR_INF;
        }

        // imprimimos la esquina suprior derecha
        borde += tipoBorde == BORDE_SUP ? ESQUINA_SUP_DER : ESQUINA_INF_DER;

        return borde;
    }

    static void mostrarTextoConBordes(String texto) {

        // pasamos a mayúsculas
        texto = texto.toUpperCase();

        // obtenemos un array de Strings
        String[] lineas = texto.split("\n");

        // obtenemos la longitud de la línea más larga
        int ancho = obtenerAnchoMaximo(lineas);

        // imprimimos el texto con los bordes
        imprimirLetrasBordes(lineas, ancho);
    }

    static void imprimirLetrasBordes(String[] lineas, int ancho) {

        // borde superior
        imprimirBordeSuperior(ancho);

        // líneas centrales
        imprimirLineas(lineas, ancho);

        // borde inferior
        imprimirBordeInferior(ancho);

    }

    static void imprimirBordeSuperior(int ancho) {
        imprimirBorde(BORDE_SUP, ancho);
    }

    static void imprimirBordeInferior(int ancho) {
        imprimirBorde(BORDE_INF, ancho);
    }

    static int obtenerAnchoMaximo(String[] lineas) {
        int anchoMax = 0;
        for (String lineaActual : lineas) {
            if (lineaActual.length() > anchoMax)
                anchoMax = lineaActual.length();
        }
        return anchoMax;
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

    static int digitos(int n) {

        if (n < 10)
            return 1;
        return 1 + digitos(n / 10);
    }
}
