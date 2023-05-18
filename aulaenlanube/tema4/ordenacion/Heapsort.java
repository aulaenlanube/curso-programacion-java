package aulaenlanube.tema4.ordenacion;
public class Heapsort {

    static void heapSort(int[] array) {
        // Creamos el montículo
        buildMaxHeap(array);

        // Recorremos el array desde el final hasta el principio
        for (int i = array.length - 1; i > 0; i--) {
            // Intercambiamos el elemento máximo con el último elemento
            swap(array, 0, i);
            // Ajustamos el montículo
            adjustHeap(array, 0, i);
        }
    }

    static void buildMaxHeap(int[] array) {
        // Calculamos el índice del primer elemento que no es hoja
        int firstNonLeaf = (array.length - 1) / 2;
        // Recorremos todos los nodos que no son hojas
        for (int i = firstNonLeaf; i >= 0; i--) {
            // Ajustamos el montículo
            adjustHeap(array, i, array.length);
        }
    }

    static void adjustHeap(int[] array, int root, int heapSize) {
        // Calculamos el índice del hijo izquierdo
        int leftChild = 2 * root + 1;
        // Si el hijo izquierdo es menor que heapSize, entonces el nodo tiene hijos
        if (leftChild < heapSize) {
            // Calculamos el índice del hijo derecho
            int rightChild = 2 * root + 2;
            // Si el hijo derecho es menor que heapSize, entonces el nodo tiene dos hijos
            if (rightChild < heapSize) {
                // Si el hijo derecho es mayor que el hijo izquierdo, entonces el mayor de los
                // dos hijos es el derecho
                if (array[rightChild] > array[leftChild]) {
                    leftChild = rightChild;
                }
            }
            // Si el hijo mayor es mayor que el nodo, entonces intercambiamos los dos
            // elementos
            if (array[leftChild] > array[root]) {
                swap(array, root, leftChild);
                // Ajustamos el montículo desde el hijo intercambiado
                adjustHeap(array, leftChild, heapSize);
            }
        }
    }
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
