import java.util.Map;
import java.util.TreeMap;

public class EjemplosTreeMap {

    public static void main(String[] args) {

        TreeMap<String, Double> notas = new TreeMap<>();

        // Agregar alumnos y sus notas.
        notas.put("Pol", 9.8);
        notas.put("Pep", 8.3);
        notas.put("Tom", 7.0);
        notas.put("Sam", 9.6);
        notas.put("Pol", 6.5);
        notas.put("Kal", 9.1);

        System.out.println(notas);

        // Mostrar el primer y último alumno por orden alfabético.
        System.out.println("Primer alumno: " + notas.firstKey());
        System.out.println("Último alumno: " + notas.lastKey());

        // Mostrar alumnos cuyos nombres son alfabéticamente menores que "Sam".
        System.out.println("Alumnos antes de 'Sam': " + notas.headMap("Sam"));

        // Mostrar alumnos cuyos nombres son alfabéticamente mayores o iguales que
        // "Sam".
        System.out.println("Alumnos desde 'Sam': " + notas.tailMap("Sam"));

        // Mostrar alumnos cuyos nombres están en el rango alfabético "Kal" y "Pol".
        System.out.println("Alumnos entre 'Kal' y 'Pol': " + notas.subMap("Kal", "Pol"));

        // Mostrar el alumno inmediatamente anterior a "Pol".
        System.out.println("Alumno anterior o igual a 'Pep': " + notas.floorKey("Pep"));
        System.out.println("Alumno superior o igual a 'Kal': " + notas.ceilingKey("Kal"));
        System.out.println("Alumno anterior a 'Tim': " + notas.lowerKey("Tim"));

        // Mostrar el alumno inmediatamente posterior a "Pol".
        System.out.println("Alumno posterior a 'Pol': " + notas.higherKey("Pol"));

        // Eliminar y mostrar el alumno con la menor nota.
        Map.Entry<String, Double> min = notas.pollFirstEntry();
        System.out.println("Primer alumno: " + min.getKey() + ", nota: " + min.getValue());

        // Eliminar y mostrar el alumno con la mayor nota.
        Map.Entry<String, Double> max = notas.pollLastEntry();
        System.out.println("Último alumno: " + max.getKey() + ", nota: " + max.getValue());

        System.out.println(notas);
    }

}
