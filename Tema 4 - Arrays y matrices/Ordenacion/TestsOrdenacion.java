import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;

public class TestsOrdenacion {

    public static void main(String[] args) {

        test(10_000_000, 10);
    }

    static void test(int cantidadPruebas, int elementosArray) {

        int[] array1, array2, array3;
        long tiempoQuicksort = 0, tiempoHeapsort = 0, tiempoMergesort = 0;
        Instant inicio, fin;        

        for (int i = 0; i < cantidadPruebas; i++) {

            array1 = GeneradorArrays.generarArray(elementosArray);
            array2 = array1.clone();
            array3 = array1.clone();

            // quicksort
            inicio = Instant.now();
            Quicksort.quicksort(array1, 0, array1.length - 1);
            fin = Instant.now();
            tiempoQuicksort += Duration.between(inicio, fin).toNanos();

            // heapsort
            inicio = Instant.now();
            Heapsort.heapSort(array2);
            fin = Instant.now();
            tiempoHeapsort += Duration.between(inicio, fin).toNanos();

            // mergesort
            inicio = Instant.now();
            Mergesort.mergeSort(array3, 0, array3.length - 1);
            fin = Instant.now();
            tiempoMergesort += Duration.between(inicio, fin).toNanos();
        }

        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Duración total de quicksort en ordenar " + df.format(cantidadPruebas) + " Arrays de "
                + df.format(elementosArray)
                + " elementos: " + (tiempoQuicksort / 1_000_000) + "ms");
        System.out.println("Duración total de heapsort en ordenar " + df.format(cantidadPruebas) + " Arrays de "
                + df.format(elementosArray)
                + " elementos: " + (tiempoHeapsort / 1_000_000) + "ms");
        System.out.println("Duración total de mergesort en ordenar " + df.format(cantidadPruebas) + " Arrays de "
                + df.format(elementosArray)
                + " elementos: " + (tiempoMergesort / 1_000_000) + "ms");

    }

}
