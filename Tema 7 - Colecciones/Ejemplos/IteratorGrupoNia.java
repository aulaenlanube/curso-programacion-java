import java.util.ArrayList;
import java.util.Iterator;

public class IteratorGrupoNia implements Iterable<Alumno>{

    ArrayList<Alumno> alumnos;

    public IteratorGrupoNia(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public Iterator<Alumno> iterator() {
        return new Iterator<Alumno>() {
            private int posicion = 0;

            @Override
            public boolean hasNext() {
                while (posicion < alumnos.size() && alumnos.get(posicion).getNia() == null) {
                    posicion++;
                }
                return posicion < alumnos.size();
            }

            @Override
            public Alumno next() {
                return alumnos.get(posicion++);
            }

            public void remove() {
                alumnos.remove(--posicion);
            }
        };
    }
    
}
