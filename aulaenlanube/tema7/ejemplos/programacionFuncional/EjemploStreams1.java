package aulaenlanube.tema7.ejemplos.programacionFuncional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreams1 {

    public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Ana", "Carlos", "Antonio", "David", "Eva");

        List<String> nombresFiltrados = nombres.stream()
                .filter(nombre -> nombre.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(nombresFiltrados);
    }
}
