package aulaenlanube.tema7.ejemplos;
import java.util.ArrayList;
import java.util.Comparator;

public class Instituto3 {

    public static void main(String[] args) {

        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pep", "222A", 25));
        alumnos.add(new Alumno("Tom", "111A", 20));
        alumnos.add(new Alumno("Jon", "444A", 21));
        alumnos.add(new Alumno("Tim", "333A", 19));

        ordenarAlumnosPorEdad(alumnos);
        System.out.println("Alumnos ordenados por edad");
        System.out.println(alumnos);

        ordenarAlumnosPorNia(alumnos);
        System.out.println("Alumnos ordenados por NIA");
        System.out.println(alumnos);
    }


    public static void ordenarAlumnosPorEdad(ArrayList<Alumno> alumnos) {
        alumnos.sort(new Comparator<Alumno>() {
            @Override
            public int compare(Alumno a1, Alumno a2) {
                if (a1.getEdad() < a2.getEdad())
                    return 1;
                if (a1.getEdad() > a2.getEdad())
                    return -1;
                return a1.getNombre().compareTo(a2.getNombre());
            }
        });
    }

    public static void ordenarAlumnosPorNia(ArrayList<Alumno> alumnos) {
        alumnos.sort(new Comparator<Alumno>() {
            @Override
            public int compare(Alumno a1, Alumno a2) {
                return a1.getNia().compareTo(a2.getNia());
            }
        });
    }

}
