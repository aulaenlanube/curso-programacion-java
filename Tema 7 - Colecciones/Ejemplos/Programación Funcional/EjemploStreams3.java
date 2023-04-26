import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EjemploStreams3 {

    public static void main(String[] args) {

        String texto = "Ejemplo ejemplo texto texto texto";

        Set<String> palabrasUnicas = Arrays.stream(texto.split("\\s+"))
                                           .map(String::toLowerCase)
                                           .collect(Collectors.toSet());
        
        System.out.println("Número de palabras únicas: " + palabrasUnicas.size());

    }
}
