import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreams5 {

    public static void main(String[] args) {

        // Ejemplo para ordenar las distintas palabras de una String según la cantidad
        // caracteres que tiene la palabra, de más caracteres a menos
        String texto = "Voy a aprobar programación con buena nota";
        List<String> palabrasOrdenadasPorLongitud = Arrays.stream(texto.split("\\s+"))
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
        System.out.println("Palabras ordenadas por longitud: " + palabrasOrdenadasPorLongitud);

    }
}
