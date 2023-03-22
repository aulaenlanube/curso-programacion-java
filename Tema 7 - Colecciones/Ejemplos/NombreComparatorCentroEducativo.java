import java.util.Comparator;
public class NombreComparatorCentroEducativo implements Comparator<PersonaCentroEducativo> {
    @Override
    public int compare(PersonaCentroEducativo p1, PersonaCentroEducativo p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }
}


