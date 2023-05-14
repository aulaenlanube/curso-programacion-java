import java.util.ArrayList;
import java.util.Iterator;

public class Grupo implements Iterable<Alumno> {

    private String nombre;
    private ArrayList<Alumno> alumnos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }    

    public void agregarAlumno(Alumno a) {
        alumnos.add(a);
    }

    public void listarAlumnos() {
        Iterator<Alumno> iteradorGrupo = iterator();
        while(iteradorGrupo.hasNext()) {
            System.out.println(iteradorGrupo.next());
        }
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
        };
    }
}
