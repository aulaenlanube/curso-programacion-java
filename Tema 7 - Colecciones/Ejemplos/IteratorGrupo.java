import java.util.ArrayList;
import java.util.Iterator;

public class IteratorGrupo implements Iterable<Alumno>{

    ArrayList<Alumno> alumnos;

    public IteratorGrupo(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public Iterator<Alumno> iterator() {
        return new Iterator<Alumno>() {
            private int posicion = 0;

            @Override
            public boolean hasNext() {               
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
