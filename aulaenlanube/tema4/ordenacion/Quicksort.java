package aulaenlanube.tema4.ordenacion;
import java.util.Stack;

public class Quicksort {

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
    
    static void quickSortIterativo(int[] array) {
        // Creamos una pila para almacenar el rango de índices a ordenar
        Stack<Integer> pila = new Stack<>();
        // Añadimos el rango completo al principio
        pila.push(0);
        pila.push(array.length - 1);
    
        // Mientras haya elementos en la pila
        while (!pila.isEmpty()) {
            // Obtenemos el índice final del rango
            int fin = pila.pop();
            // Obtenemos el índice inicial del rango
            int inicio = pila.pop();
    
            // Si el rango tiene más de un elemento
            if (fin > inicio) {
                // Particionamos el rango
                int particionIndice = particion(array, inicio, fin);
    
                // Añadimos el rango izquierdo a la pila
                pila.push(inicio);
                pila.push(particionIndice - 1);
    
                // Añadimos el rango derecho a la pila
                pila.push(particionIndice + 1);
                pila.push(fin);
            }
        }
    }

    static int particion(int[] array, int inicio, int fin) {
        // Escogemos el elemento final como pivote
        int pivote = array[fin];
        // Inicializamos el índice de la partición en el inicio
        int particionIndice = inicio;
    
        // Recorremos el rango
        for (int i = inicio; i < fin; i++) {
            // Si el elemento es menor que el pivote, lo intercambiamos con el elemento de la partición y aumentamos el índice de la partición
            if (array[i] < pivote) {
                intercambiar(array, i, particionIndice);
                particionIndice++;
            }
        }
        // Intercambiamos el pivote con el elemento de la partición
        intercambiar(array, particionIndice, fin);
    
        // Devolvemos el índice de la partición
        return particionIndice;
    }

    static void intercambiar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}