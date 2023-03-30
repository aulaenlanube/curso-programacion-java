import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class EjemploTreeMapNotas {

    public static void main(String[] args) {

        // TreeMap para almacenar las notas de los alumnos en distintos módulos
        Map<Alumno, ArrayList<Double>> notasDam = new TreeMap<>();

        Alumno a1 = new Alumno("Pep", "111A", 20);
        Alumno a2 = new Alumno("Jon", "222A", 18);
        Alumno a3 = new Alumno("Sam", "333A", 21);
        Alumno a4 = new Alumno("Bil", "444A", 19);
        Alumno a5 = new Alumno("Kal", "111A", 22);

        // Añadimos las notas de los alumnos a las asignaturas
        agregarNota(notasDam, a1, 9.2);
        agregarNota(notasDam, a1, 7.5);
        agregarNota(notasDam, a2, 8.1);
        agregarNota(notasDam, a2, 9.0);
        agregarNota(notasDam, a3, 7.5);
        agregarNota(notasDam, a4, 8.2);        
        agregarNota(notasDam, a5, 10.0);        

        // Mostrar todas las notas de los alumnos en cada asignatura
        System.out.println("Notas de los alumnos:");
        for (Map.Entry<Alumno, ArrayList<Double>> entry : notasDam.entrySet()) {
            System.out.println(entry.getKey() + " --> Notas: " + entry.getValue());
        }
    }

    // Método para añadir notas de los alumnos a las asignaturas en el mapa
    public static void agregarNota(Map<Alumno, ArrayList<Double>> notasDam, Alumno a, double nota) {
        ArrayList<Double> notas = notasDam.getOrDefault(a, new ArrayList<>());
        notas.add(nota);
        notasDam.put(a, notas);
    }
}
