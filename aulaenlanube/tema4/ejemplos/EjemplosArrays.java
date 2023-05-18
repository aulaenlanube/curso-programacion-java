package aulaenlanube.tema4.ejemplos;
import java.util.Random;

class EjemplosArrays {

    public static void main(String[] args) {

        int[] nums = crearArray(10, 10);
        int[] nums2 = crearArray(5, 10);
        int[] maximos = crearMaximos(nums, nums2);

        mostrarArray(nums, " - ");
        mostrarArray(nums2, " - ");
        mostrarArray(maximos, " - ");
    }

    /**
     * Crea un Array de enteros con los valores máximos comparados a partir de 2
     * Arrays de enteros.
     * 
     * @param a - Array de enteros.
     * @param b - Array de enteros.
     * @return Array de tamaño mínimo entre los Arrays a y b, con los valores
     *         máximos en cada posición.
     */
    static int[] crearMaximos(int[] a, int[] b) {

        int maximos[];
        if (a.length > b.length)
            maximos = new int[a.length];
        else
            maximos = new int[b.length];

        for (int i = 0; i < maximos.length; i++) {
            if (i >= b.length)
                maximos[i] = a[i];
            else if (i >= a.length)
                maximos[i] = b[i];
            else if (a[i] > b[i])
                maximos[i] = a[i];
            else
                maximos[i] = b[i];
        }
        return maximos;
    }

    /**
     * Muestra un Array de enteros.
     * 
     * @param n - Array de enteros que se quiere mostrar.
     * @param s - Separador para los elementos.
     */
    static void mostrarArray(int[] n, String s) {
        for (int i = 0; i < n.length - 1; i++) {
            System.out.print(n[i] + s);
        }
        System.out.println(n[n.length - 1]);
    }

    /**
     * Crea un Array con enteros de forma aleatoria.
     * 
     * @param n   - Cantidad de elementos del Array.
     * @param max - Valor máximo de los elementos del Array, sin incluirlo.
     * @return Array de tamaño n, con enteros aleatorios.
     */
    static int[] crearArray(int n, int max) {
        Random r = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(max);
        }
        return array;
    }
}