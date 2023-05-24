package aulaenlanube.tema7.ejercicios.practica2;

import java.util.List;
import java.util.Map;

public class Practica2Main {

    public static void main(String[] args) {
        AnalizadorTextos analizador = new AnalizadorTextos(
                "Este es un texto de prueba. Este texto es para probar el analizador de texto.");

        System.out.println("Las palabras más frecuentes son:");
        for (Map.Entry<String, Integer> entry : analizador.palabrasMasFrecuentes(3)) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Las palabras menos frecuentes son:");
        for (Map.Entry<String, Integer> entry : analizador.palabrasMenosFrecuentes(3)) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Las palabras agrupadas por longitud son:");
        Map<Integer, List<String>> palabrasPorLongitud = analizador.palabrasPorLongitud();
        for (Map.Entry<Integer, List<String>> entry : palabrasPorLongitud.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
