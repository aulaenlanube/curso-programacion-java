package aulaenlanube.tema7.ejercicios.practica2;

import java.util.List;
import java.util.Map;

public class Practica2Main {

    public static void main(String[] args) {
        AnalizadorTextos analizador = new AnalizadorTextos(
                "Este.es un texto complejo de   prueba de Prueba\n\nHoy es jueves\n25 de mayo de 2023.");

        System.out.println("Las palabras más frecuentes son:");
        for (Map.Entry<String, Integer> palabras : analizador.palabrasMasFrecuentes(3)) {
            System.out.println(palabras.getKey() + ": " + palabras.getValue());
        }

        System.out.println("Las palabras menos frecuentes son:");
        for (Map.Entry<String, Integer> palabras : analizador.palabrasMenosFrecuentes(3)) {
            System.out.println(palabras.getKey() + ": " + palabras.getValue());
        }

        System.out.println("Las palabras agrupadas por longitud son:");
        Map<Integer, List<String>> palabrasPorLongitud = analizador.palabrasPorLongitud();
        for (Map.Entry<Integer, List<String>> palabras : palabrasPorLongitud.entrySet()) {
            System.out.println(palabras.getKey() + ": " + palabras.getValue());
        }
    }

}
