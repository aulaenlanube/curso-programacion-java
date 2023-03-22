import java.util.Comparator;

public class AlumnoPorNiaComparator implements Comparator<Alumno> {
    public int compare(Alumno a1, Alumno a2) {
        return a1.getNia().compareTo(a2.getNia());
    }
}
