import java.util.Arrays;

public class EjemploStreams4 {

    public static void main(String[] args) {

        // Ejemplo para ordenar las palabras de una String en orden alfabético
        String texto = "Ejemplo de ordenamiento alfabético utilizando la API Stream de Java";

        System.out.println("Palabras ordenadas alfabéticamente:");
        Arrays.stream(texto.split("\\s+"))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::println);

    }
}
