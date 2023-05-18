package aulaenlanube.tema7.ejemplos.programacionFuncional;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreams6 {

    public static void main(String[] args) {

        // Ejemplo para ordenar las palabras de una cadena de caracteres según la
        // cantidad de veces que aparece la letra 'a'
        String texto = "Ordenar palabras según la cantidad de veces que aparece la letra a";
        Comparator<String> comparadorPorCantidadDeA = (palabra1, palabra2) -> {
            int countAInPalabra1 = (int) palabra1.chars().filter(c -> c == 'a' || c == 'A').count();
            int countAInPalabra2 = (int) palabra2.chars().filter(c -> c == 'a' || c == 'A').count();
            return Integer.compare(countAInPalabra1, countAInPalabra2);
        };
        List<String> palabrasOrdenadas = Arrays.stream(texto.split("\\s+"))
                .sorted(comparadorPorCantidadDeA)
                .collect(Collectors.toList());

        System.out.println("Palabras ordenadas por cantidad de 'a': " + palabrasOrdenadas);
    }
}
