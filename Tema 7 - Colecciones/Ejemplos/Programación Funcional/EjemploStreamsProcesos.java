import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class EjemploStreamsProcesos {

    public static void main(String[] args) {

        // creamos array con enteros aleatorios
        int[] arrayDesordenado = GeneradorArrays.generarArray(100_000_000);

        // convertimos array a list
        List<Integer> listaDesordenada = Arrays.stream(arrayDesordenado)
                .boxed()
                .toList();

        // ordenamos y medimos el tiempo
        Instant inicio = Instant.now();
        listaDesordenada.stream().sorted().toArray();
        Instant fin = Instant.now();

        // mostramos la duración en milisegundos
        System.out.println("Duración en milisegundos: " + Duration.between(inicio, fin).toMillis());

    }
}
