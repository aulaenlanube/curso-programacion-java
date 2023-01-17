import java.util.Arrays;
import java.util.Random;

public class GeneredorMatrices {

    /**
     * Genera una matriz cuadrada con enteros aleatorios
     * 
     * @param lado   - Anchura y altura de la matriz
     * @param numMax - Valor máximo para cada uno de los enteros de la matriz, los
     *               valores posibles serán desde 0 hasta numMax
     * @return Matriz con enteros generados de forma aleatoria
     */
    public static int[][] generarMatriz(int lado, int numMax) {
        return generarMatriz(lado, lado, lado, lado, numMax);
    }

    /**
     * Genera una matriz regular con un ancho y alto predefinidos con enteros
     * aleatorios
     * 
     * @param ancho  - Cantidad de elementos de cada una de las filas de la matriz
     * @param alto   - Cantidad de filas de la matriz
     * @param numMax - Valor máximo para cada uno de los enteros de la matriz, los
     *               valores posibles serán desde 0 hasta numMax
     * @return Matriz con enteros generados de forma aleatoria
     */
    public static int[][] generarMatriz(int ancho, int alto, int numMax) {
        return generarMatriz(ancho, ancho, alto, alto, numMax);
    }

    /**
     * Genera una matriz irregular con enteros aleatorios
     * 
     * @param anchoMin - Anchura mínima de las filas de la matriz, si se pone un
     *                 cero, pueden haber filas sin elementos, los valores negativos
     *                 se convierten a 0 de forma automática. Debe ser igual o
     *                 menor a anchoMax, de lo contrario, se establecerá anchoMin al
     *                 mismo valor que anchoMax
     * @param anchoMax - Anchura máxima de las filas de la matriz, debe ser igual o
     *                 mayor a anchoMin, de lo contrario, se establecerá anchoMin al
     *                 mismo valor que anchoMax. Los valores negativos se convierten
     *                 a 0 de forma automática.
     * @param altoMin  - Altura mínima de la matriz, debe ser 1 o superior, de lo
     *                 contrario puede no tener filas. Los valores negativos se
     *                 convierten a 0 de forma automática. Debe ser igual o
     *                 menor a altoMax, de lo contrario, se establecerá anchoMin al
     *                 mismo valor que anchoMax
     * @param altoMax  - Cantidad máxima de filas de la matriz, debe ser igual o
     *                 mayor a altoMin, de lo contrario, se establecerá altoMin al
     *                 valor de altoMax, los valores negativos se convierten a 0 de
     *                 forma automática
     * @param numMax   - Valor máximo para cada uno de los enteros de la matriz, los
     *                 valores posibles serán desde 0 hasta numMax
     * @return Matriz con enteros generados de forma aleatoria
     */
    public static int[][] generarMatriz(int anchoMin, int anchoMax, int altoMin, int altoMax, int numMax) {

        // si hay negativos los convertimos a 0
        if (anchoMin < 0)
            anchoMin = 0;
        if (anchoMax < 0)
            anchoMax = 0;
        if (altoMin < 0)
            altoMin = 0;
        if (altoMax < 0)
            altoMax = 0;

        // si los mínimos son mayores, los igualamos
        if (anchoMin > anchoMax)
            anchoMin = anchoMax;
        if (altoMin > altoMax)
            altoMin = altoMax;

        // generamos matriz
        Random r = new Random();
        int[][] matriz = new int[r.nextInt(altoMin, altoMax+1)][];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new int[r.nextInt(anchoMin, anchoMax+1)];
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(numMax + 1);
            }
        }
        return matriz;
    }

}
