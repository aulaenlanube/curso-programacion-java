import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EjemploStreams9 {

    public static void main(String[] args) {

        // Ejemplo para ordenar las distintas palabras de una String según la cantidad
        // de veces que aparece cada palabra, de mayor a menor

        String texto = "casa casa otro be be be a a a a a a";

        Map<String, Long> palabrasOrdenadas = Arrays.stream(texto.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Palabras ordenadas por frecuencia: " + palabrasOrdenadas);

    }
}
