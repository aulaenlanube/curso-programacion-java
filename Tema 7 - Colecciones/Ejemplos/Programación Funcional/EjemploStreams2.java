import java.util.Arrays;
import java.util.List;

public class EjemploStreams2 {

    public static void main(String[] args) {

        List<String> palabras = Arrays.asList("a", "ab", "abc", "abcd");

        String frase = palabras.stream()
                .filter(palabra -> palabra.length() > 2)
                .map(palabra -> palabra += "_")
                .reduce("Frase: ", String::concat);

        System.out.println(frase);

    }
}
