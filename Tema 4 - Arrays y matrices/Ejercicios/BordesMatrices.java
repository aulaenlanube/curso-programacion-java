public class BordesMatrices {

    private static final char LINEA_VERTICAL = '║';
    private static final char LINEA_HORIZONTAL = '═';
    private static final char ESQUINA_SUP_IZQ = '╔';
    private static final char ESQUINA_INF_IZQ = '╚';
    private static final char ESQUINA_SUP_DER = '╗';
    private static final char ESQUINA_INF_DER = '╝';
    private static final char SEPARADOR_SUP = '╦';
    private static final char SEPARADOR_INF = '╩';

    private static final char SEPARADOR_IZQ = '╠';
    private static final char SEPARADOR_DER = '╣';
    private static final char SEPARADOR_CRUZ = '╬';

    private static final char SEPARADOR_FILAS_MATRICES = '■';

    private static final int BORDE_SUP = 0;
    private static final int BORDE_INF = 1;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    // MÉTODOS PÚBLICOS
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Imprime por pantalla un texto dentro de un rectángulo con bordes unicode
     * 
     * @param texto - Cadena de texto incluida dentro de los bordes, será pasada a
     *              mayúsculas
     */
    public static void mostrarTextoConBordes(String texto) {

        // pasamos a mayúsculas
        texto = texto.toUpperCase();

        // obtenemos un array de Strings
        String[] lineas = texto.split("\n");

        // obtenemos la longitud de la línea más larga
        int ancho = obtenerAnchoMaximo(lineas);

        // imprimimos el texto con los bordes
        imprimirLetrasBordes(lineas, ancho);
    }

    /**
     * Imprime por pantalla un Array de enteros dentro de un rectángulo con bordes
     * unicode
     * 
     * @param array - Array de enteros que imprimirá por pantalla
     */
    public static void mostrarArrayConBordes(int[] array) {
        System.out.println(crearStringArrayConBordes(array));
    }

    /**
     * Imprime por pantalla una matriz de enteros con bordes unicode
     * 
     * @param matriz - Matriz de enteros que imprimirá por pantalla
     */
    public static void mostrarMatrizConBordes(int[][] matriz) {
        System.out.println(crearStringMatrizConBordes(matriz));
    }

    /**
     * Imprime por pantalla una cantidad indeterminada de matrices de enteros con
     * bordes unicode en una misma fila
     * 
     * @param separacion - Distancia de separación horizontal entre cada una de las
     *                   matrices
     * @param matrices   - Matrices que se imprimirán una al lado de la otra, se
     *                   pueden añadir tantas como sean necesarias
     */
    public static void mostrarMatricesConBordes(int separacion, int[][]... matrices) {
        System.out.println(crearStringMatricesConBordes(separacion, matrices));

        // línea horizontal para separar las filas
        for (int i = 0; i < 120; i++)
            System.out.print(SEPARADOR_FILAS_MATRICES);
        System.out.println("\n");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String crearStringMatricesConBordes(int separacion, int[][]... matrices) {

        String[][] lineasMatrices = obtenerLineasMatrices(matrices);
        int[] cantidadLineasMatrices = obtenerCantidadesLineasMatrices(lineasMatrices);
        String[] textoMatrices = new String[obtenerCantidadLineasMaxima(lineasMatrices)];
        String textoFinal = "";

        // por cada línea, debemos obtener la línea de cada una de las matrices
        for (int i = 0; i < textoMatrices.length; i++) {

            textoMatrices[i] = "";
            int anchoAcumulado = 0;
            for (int j = 0; j < matrices.length; j++) {

                // si existe la línea en la matriz
                if (i < cantidadLineasMatrices[j])
                    textoMatrices[i] += lineasMatrices[j][i];

                // calcular la cantidad de espacios
                anchoAcumulado += obtenerAnchoMaximo(lineasMatrices[j]) + separacion;
                int espacios = anchoAcumulado - textoMatrices[i].length();
                for (int k = 0; k < espacios; k++) // añadimos los espacios
                    textoMatrices[i] += " ";
            }
            textoFinal += textoMatrices[i] + "\n";
        }
        return textoFinal;
    }

    private static String[][] obtenerLineasMatrices(int[][]... matrices) {

        String[][] lineasMatrices = new String[matrices.length][];
        for (int i = 0; i < matrices.length; i++)
            lineasMatrices[i] = crearStringMatrizConBordes(matrices[i]).split("\n");
        return lineasMatrices;
    }

    private static int[] obtenerCantidadesLineasMatrices(String[][] lineasMatrices) {

        int[] cantidadLineasMatrices = new int[lineasMatrices.length];
        int lineasMax = 0;
        for (int i = 0; i < lineasMatrices.length; i++) {

            cantidadLineasMatrices[i] = lineasMatrices[i].length;
            if (cantidadLineasMatrices[i] > lineasMax)
                lineasMax = cantidadLineasMatrices[i];
        }
        return cantidadLineasMatrices;
    }

    private static int obtenerCantidadLineasMaxima(String[][] lineasMatrices) {

        int lineasMax = 0;
        for (int i = 0; i < lineasMatrices.length; i++)
            if (lineasMatrices[i].length > lineasMax)
                lineasMax = lineasMatrices[i].length;
        return lineasMax;
    }

    private static String crearStringArrayConBordes(int[] array) {

        String arrayConBordes = "";

        if (array.length > 0) {
            arrayConBordes += obtenerBordeSuperiorArray(array) + "\n";
            arrayConBordes += obtenerStringEnteros(array) + "\n";
            arrayConBordes += obtenerBordeInferiorArray(array) + "\n";
        }

        return arrayConBordes;
    }

    private static String crearStringMatrizConBordes(int[][] matriz) {

        String matrizConBordes = "";

        if (matriz.length > 0) {
            matrizConBordes += obtenerBordeSuperiorArray(matriz[0]) + "\n";
            matrizConBordes += obtenerParteCentralMatriz(matriz);
            matrizConBordes += obtenerBordeInferiorArray(matriz[matriz.length - 1]) + "\n";
        }

        return matrizConBordes;
    }

    private static String obtenerParteCentralMatriz(int[][] matriz) {

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

    private static String obtenerBordeIntermedio(int[] filaActual, int[] filaInferior) {

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

        // casos con arrays sin elementos
        if (anchoFilaActual == 1 || anchoFilaInferior == 1) {

            // si ambos tienen un array sin elementos
            if (anchoFilaActual == 1 && anchoFilaInferior == 1) {
                bordeIntermedio = new char[2];
                bordeIntermedio[0] = SEPARADOR_IZQ;
                bordeIntermedio[1] = SEPARADOR_DER;
            }
            // si la fila de arriba tiene elementos y la de bajo no
            else if (anchoFilaActual > 1 && anchoFilaInferior == 1) {
                bordeIntermedio[1] = SEPARADOR_SUP;
                bordeIntermedio[bordeIntermedio.length - 1] = ESQUINA_INF_DER;
            }
            // si la fila de bajo tiene elementos y la de arriba no
            else if (anchoFilaActual == 1 && anchoFilaInferior > 1) {
                bordeIntermedio[1] = SEPARADOR_INF;
                bordeIntermedio[bordeIntermedio.length - 1] = ESQUINA_SUP_DER;
            }
        }
        // casos con arrays con elementos
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

    private static int[] posicionarSeparadores(int[] fila) {

        // colocamos un índice en la posición de cada separador
        int[] posicionesSeparadores = new int[fila.length];
        for (int i = 0; i < posicionesSeparadores.length; i++) {
            posicionesSeparadores[i] = digitos(Math.abs(fila[i])) + 2; // +2 por los espacios en blanco
            if (fila[i] < 0) // si es negativo, añadimos un espacio
                posicionesSeparadores[i]++;
        }
        return posicionesSeparadores;
    }

    private static int obtenerAnchoFila(int[] posicionesSeparadores) {

        int anchoFila = 1; // carácter inicial, separador vertical
        for (int i = 0; i < posicionesSeparadores.length; i++) {
            anchoFila += posicionesSeparadores[i] + 1; // +1 por añadir el separador
        }
        return anchoFila;
    }

    private static String obtenerStringEnteros(int[] array) {

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

    private static String obtenerBordeSuperiorArray(int[] array) {
        return obtenerBordeArray(array, BORDE_SUP);
    }

    private static String obtenerBordeInferiorArray(int[] array) {
        return obtenerBordeArray(array, BORDE_INF);
    }

    private static String obtenerBordeArray(int[] array, int tipoBorde) {

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

    private static void imprimirLetrasBordes(String[] lineas, int ancho) {

        // borde superior
        imprimirBordeSuperior(ancho);

        // líneas centrales
        imprimirLineas(lineas, ancho);

        // borde inferior
        imprimirBordeInferior(ancho);

    }

    private static void imprimirBordeSuperior(int ancho) {
        imprimirBorde(BORDE_SUP, ancho);
    }

    private static void imprimirBordeInferior(int ancho) {
        imprimirBorde(BORDE_INF, ancho);
    }

    private static int obtenerAnchoMaximo(String[] lineas) {
        int anchoMax = 0;
        for (String lineaActual : lineas) {
            if (lineaActual.length() > anchoMax)
                anchoMax = lineaActual.length();
        }
        return anchoMax;
    }

    private static void imprimirLineas(String[] lineas, int lineaMax) {
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

    private static void imprimirBorde(int tipoBorde, int ancho) {

        System.out.print(tipoBorde == BORDE_SUP ? ESQUINA_SUP_IZQ : ESQUINA_INF_IZQ);
        for (int i = 0; i < ancho * 2 + 3; i++)
            System.out.print(LINEA_HORIZONTAL);
        System.out.println(tipoBorde == BORDE_SUP ? ESQUINA_SUP_DER : ESQUINA_INF_DER);

    }

    private static int digitos(int n) {

        if (n < 10)
            return 1;
        return 1 + digitos(n / 10);
    }

}
