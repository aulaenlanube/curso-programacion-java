import java.util.Arrays;

public class Mergesort {

    static void mergeSort(int[] list, int start, int end) {
        // Verificar si el tamaño de la lista es menor o igual a 1
        if (end - start <= 1) {
            return;
        }

        // Dividir la lista en dos sublistas
        int mid = (start + end) / 2;
        int[] left = Arrays.copyOfRange(list, start, mid);
        int[] right = Arrays.copyOfRange(list, mid, end);

        // Ordenar recursivamente cada sublista
        mergeSort(left, 0, left.length);
        mergeSort(right, 0, right.length);

        // Fusionar las sublistas ordenadas en una sola lista ordenada
        int i = 0;
        int j = 0;
        int k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de la sublista izquierda (si hay alguno)
        while (i < left.length) {
            list[k] = left[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de la sublista derecha (si hay alguno)
        while (j < right.length) {
            list[k] = right[j];
            j++;
            k++;
        }
    }
    
}
