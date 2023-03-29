import java.util.Comparator;

public class AlumnoPorEdadComparator implements Comparator<Alumno> {
    public int compare(Alumno a1, Alumno a2) {
        if (a1.getNia().compareTo(a2.getNia()) == 0)
            return 0;
        int comparacion = Integer.compare(a1.getEdad(), a2.getEdad());
        if (comparacion == 0)
            comparacion = a1.getNia().compareTo(a2.getNia());
        return comparacion;
    }

}
