package aulaenlanube.tema7.ejemplos;
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorGrupo implements Iterator<Alumno>{

    private int posicion = 0;
    private ArrayList<Alumno> alumnos;

    public IteratorGrupo(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }    

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
    
}
