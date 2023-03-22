import java.util.Comparator;

public class AlumnoPorEdadComparator implements Comparator<Alumno> {
    public int compare(Alumno a1, Alumno a2) {
        int comparacion = Integer.compare(a1.getEdad(), a2.getEdad());
        if (comparacion == 0)
            comparacion = a1.getNombre().compareTo(a2.getNombre());
        return comparacion;
    }
}
