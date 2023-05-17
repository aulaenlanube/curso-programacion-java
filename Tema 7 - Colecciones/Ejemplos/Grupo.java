import java.util.ArrayList;
import java.util.Iterator;

public class Grupo {

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
        Iterator<Alumno> iteradorGrupo = new IteratorGrupoNia(alumnos);
        while (iteradorGrupo.hasNext()) {
            System.out.println(iteradorGrupo.next());
        }
    }

    public void eliminarPorEdad(int n) {
        Iterator<Alumno> iteradorGrupo = new IteratorGrupo(alumnos);
        while (iteradorGrupo.hasNext()) {
            if (iteradorGrupo.next().getEdad() < n)
                iteradorGrupo.remove();
        }
    }

    

}
