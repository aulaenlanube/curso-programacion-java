import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreams7 {

    public static void main(String[] args) {

        // Ejemplo para ordenar las palabras de una cadena de caracteres según la
        // cantidad de veces que aparece la letra 'a', de mayor a menor. Y que no
        // aparezcan las palabras que no tengan ninguna 'a'

        String texto = "Ordenar palabras según la cantidad de veces que aparece la letra a";

        Comparator<String> comparadorPorCantidadDeA = (palabra1, palabra2) -> {
            int countAInPalabra1 = (int) palabra1.chars().filter(c -> c == 'a').count();
            int countAInPalabra2 = (int) palabra2.chars().filter(c -> c == 'a').count();
            return Integer.compare(countAInPalabra2, countAInPalabra1);
        };
        List<String> palabrasOrdenadas = Arrays.stream(texto.split("\\s+"))
                .map(String::toLowerCase)
                .filter(palabra -> palabra.contains("a"))
                .sorted(comparadorPorCantidadDeA)
                .collect(Collectors.toList());

        System.out.println("Palabras ordenadas por cantidad de 'a': " + palabrasOrdenadas);
    }
}
