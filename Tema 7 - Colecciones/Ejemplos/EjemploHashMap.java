import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {

    public static void main(String[] args) {

        Map<String, Double> notasDeAlumnos = new HashMap<>();

        // Añadimos las notas de los alumnos
        notasDeAlumnos.put("Tim", 9.7);
        notasDeAlumnos.put("Bob", 8.5);
        notasDeAlumnos.put("Jon", 7.8);
        notasDeAlumnos.put("Bob", 8.8);
        notasDeAlumnos.put("Bob", notasDeAlumnos.getOrDefault("Bob", 0.0) + 1); // Bob → 9.8
        notasDeAlumnos.put("Jon", notasDeAlumnos.getOrDefault("Kal", 5.0) + 1); // Jon → 6.0
        notasDeAlumnos.put("Kal", notasDeAlumnos.getOrDefault("Bob", 5.0)); // Kal → 9.8
        notasDeAlumnos.put("Kal", notasDeAlumnos.getOrDefault("Sam", 0.0)); // Kal → 0.0

        // Mostramos datos con entrySet()
        System.out.println("Notas alumnos:");
        for (Map.Entry<String, Double> pares : notasDeAlumnos.entrySet()) {
            System.out.println("La nota de " + pares.getKey() + " es " + pares.getValue());
        }
        // Mostramos nombres de los alumnos con keySet() y nota media
        System.out.println("Alumnos:" + notasDeAlumnos.keySet()); // Alumnos:[Bob, Kal, Jon, Tim]
        double sumaNotas = 0;
        for (Double nota : notasDeAlumnos.values())
            sumaNotas += nota;
        System.out.println("Nota media: " + sumaNotas / notasDeAlumnos.size()); // Nota media: 6.375
    }
}
