package aulaenlanube.tema4.generadores;

import java.util.Random;

public class GeneradorArrays {

    /**
     * Crea un Array con enteros aleatorios
     * 
     * @param elementos - Cantidad de elementos del Array
     * @return - Array con los enteros generados
     */
    public static int[] generarArray(int elementos) {
        Random r = new Random();
        int[] array = new int[elementos];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(elementos);
        }
        return array;
    }

    /**
     * Crea un Array con enteros aleatorios
     * 
     * @param elementos - Cantidad de elementos del Array
     * @param numMax    - Valor máximo de cada uno de los elementos del Array, el
     *                  valor estará entre 0 y numMax
     * @return - Array con los enteros generados
     */
    public static int[] generarArray(int elementos, int numMax) {
        Random r = new Random();
        int[] array = new int[elementos];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(numMax + 1);
        }
        return array;
    }

}
