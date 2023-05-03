import java.util.Collection;
import java.util.List;

public class EjemploStreams3 {

    public static void main(String[] args) {

        List<Integer> lista1 = List.of(2, 1,  4,  6, 8, 10);
        List<Integer> lista2 = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<Integer> lista3 = List.of(21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        List<Integer> lista4 = List.of(31, 32, 33, 34, 35, 36, 37, 38, 39, 40);
        List<List<Integer>> listaFinal = List.of(lista1, lista2, lista3, lista4);

        // EJEMPLO 1
        List<Integer> listaFiltrada = listaFinal.stream()
                .flatMap(Collection::stream)
                .peek(n -> System.out.print(n + " "))
                .filter(n -> n % 10 == 0)
                .peek(n -> System.out.print(n + " "))
                .map(n -> n / 10)
                .peek(n -> System.out.print(n + " "))
                .toList();

        System.out.println(listaFiltrada); // [1, 2, 3, 4]

        // EJEMPLO 2
        int cantidad = (int) listaFinal.stream()
                .flatMap(Collection::stream)
                .filter(n -> n % 10 == 0)
                .map(n -> n / 10)
                .count();

        System.out.println(cantidad); // 4

        // EJEMPLO 3
        int total = listaFinal.stream()
                .flatMap(Collection::stream)
                .filter(n -> n % 10 == 0)
                .map(n -> n / 10)
                .reduce(0, (acumulado, n) -> acumulado + n * 2);

        System.out.println(total); // 2 + 4 + 6 + 8 = 20

        // EJEMPLO 4
        List<Integer> menores = listaFinal.stream()
                .flatMap(Collection::stream)
                .takeWhile(n -> n < 20)
                .toList();

        System.out.println(menores); // 1-19

        // EJEMPLO 5
        List<Integer> mayores = listaFinal.stream()
                .flatMap(Collection::stream)
                .dropWhile(n -> n < 20)
                .toList();

        System.out.println(mayores); // 20-40

        // EJEMPLO 6
        List<Integer> ninguno = listaFinal.stream()
                .flatMap(Collection::stream)
                .takeWhile(n -> n % 2 == 0)
                .toList();

        System.out.println(ninguno); // no hay elementos
        
        // EJEMPLO 7
        List<Integer> todos = listaFinal.stream()
                .flatMap(Collection::stream)
                .dropWhile(n -> n % 2 == 0)
                .toList();

        System.out.println(todos); // 1-40
    }
}
