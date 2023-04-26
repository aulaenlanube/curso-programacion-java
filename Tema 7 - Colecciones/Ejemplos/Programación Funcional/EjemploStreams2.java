import java.util.Arrays;
import java.util.List;

public class EjemploStreams2 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);

        int sumaCuadradosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(sumaCuadradosPares); 

    }
}
