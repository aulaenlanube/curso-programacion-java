import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EjemploTreeMapNotas2 {

    public static void main(String[] args) {
        
        Map<Alumno, Map<String, ArrayList<Double>>> notasAlumnos = new TreeMap<>();

        Alumno alumno1 = new Alumno("Pep", "111A", 20);
        Alumno alumno2 = new Alumno("Tom", "222A", 21);
        Alumno alumno3 = new Alumno("Sam", "333A", 22);

        agregarNota(notasAlumnos, alumno1, "Programación", 8.5);
        agregarNota(notasAlumnos, alumno1, "Programación", 7.1);
        agregarNota(notasAlumnos, alumno1, "Bases de datos", 9.0);
        agregarNota(notasAlumnos, alumno1, "Sistemas informáticos", 7.5);

        agregarNota(notasAlumnos, alumno2, "Programación", 9.5);
        agregarNota(notasAlumnos, alumno2, "Bases de datos", 8.0);
        agregarNota(notasAlumnos, alumno2, "Bases de datos", 9.0);
        agregarNota(notasAlumnos, alumno2, "Sistemas informáticos", 7.5);

        agregarNota(notasAlumnos, alumno3, "Programación", 7.5);
        agregarNota(notasAlumnos, alumno3, "Bases de datos", 8.0);
        agregarNota(notasAlumnos, alumno3, "Sistemas informáticos", 8.5);
        agregarNota(notasAlumnos, alumno3, "Sistemas informáticos", 8.2);

        mostrarDatos(notasAlumnos);
    }

    public static void agregarNota(Map<Alumno, Map<String, ArrayList<Double>>> notasAlumnos, Alumno alumno,
            String modulo, double nota) {
        Map<String, ArrayList<Double>> notasAlumno = notasAlumnos.get(alumno);
        if (notasAlumno == null) {
            notasAlumno = new HashMap<>();
            notasAlumnos.put(alumno, notasAlumno);
        }

        ArrayList<Double> notasModulo = notasAlumno.get(modulo);
        if (notasModulo == null) {
            notasModulo = new ArrayList<>();
            notasAlumno.put(modulo, notasModulo);
        }

        notasModulo.add(nota);
    }

    public static void mostrarDatos(Map<Alumno, Map<String, ArrayList<Double>>> notasAlumnos) {

        System.out.println("Notas de los alumnos:");
        for (Map.Entry<Alumno, Map<String, ArrayList<Double>>> pares : notasAlumnos.entrySet()) {
            Alumno alumno = pares.getKey();
            Map<String, ArrayList<Double>> notas = pares.getValue();
            System.out.println("Alumno: " + alumno.getNombre() + "(" + alumno.getNia() + ")");
            for (Map.Entry<String, ArrayList<Double>> notasModulo : notas.entrySet()) {
                String modulo = notasModulo.getKey();
                ArrayList<Double> calificaciones = notasModulo.getValue();
                System.out.println("Módulo: " + modulo +" "+ calificaciones);                
            }
            System.out.println();
        }
    }
}
