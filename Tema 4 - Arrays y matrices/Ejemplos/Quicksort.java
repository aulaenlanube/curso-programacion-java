import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Quicksort {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
        mostrarBusquedaBinaria(nums, 4); // El número 4 está en el Array.
        mostrarBusquedaBinaria(nums, 9); // El número 9 NO está en el Array.

    }

    static int[] generarArray(int elementos) {
        Random r = new Random();
        int[] array = new int[elementos];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(elementos);
        }
        return array;
    }

    static void quicksort(int A[], int izq, int der) {
        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) { // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j)
                i++; // busca elemento mayor que pivote
            while (A[j] > pivote)
                j--; // busca elemento menor que pivote
            if (i < j) { // si no se han cruzado
                aux = A[i]; // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1)
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        if (j + 1 < der)
            quicksort(A, j + 1, der); // ordenamos subarray derecho
    }

    static void burbuja(int[] vector) {
        int aux;
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                // El valor máximo lo más a la derecha posible
                if (vector[j] > vector[j + 1]) {
                    aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }
    }

    static boolean busquedaB(int[] nums, int numBuscado, int limiteInf, int limiteSup) {

        System.out.println("limiteInf:"+limiteInf+" -- limiteSup:"+limiteSup);
        if (limiteInf > limiteSup)
            return false; // no quedan elementos por analizar, NO ENCONTRADO

        int mitad = (limiteInf + limiteSup) / 2;

        if (nums[mitad] < numBuscado)
            return busquedaB(nums, numBuscado, mitad + 1, limiteSup); // buscamos por la mitad der

        else if (nums[mitad] > numBuscado)
            return busquedaB(nums, numBuscado, limiteInf, mitad - 1); // buscamos por la mitad izq

        else
            return true; // el elemento de la mitad coincide con numBuscado, ENCONTRADO
    }

    static void mostrarBusquedaBinaria(int[] numeros, int numeroBuscado) {

        if (busquedaB(numeros, numeroBuscado, 0, numeros.length - 1))
            System.out.println("El número " + numeroBuscado + " está en el Array.");
        else
            System.out.println("El número " + numeroBuscado + " NO está en el Array.");
    }

}