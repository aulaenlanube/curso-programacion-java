import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class EjemploTreeMapNotas3 {

    static Map<Alumno, ArrayList<Calificacion>> notasAlumnos = new TreeMap<>();

    public static void main(String[] args) {        

        Alumno alumno1 = new Alumno("Pep", "111A", 24);
        Alumno alumno2 = new Alumno("Tom", "222A", 21);
        Alumno alumno3 = new Alumno("Sam", "333A", 22);

        agregarNota(alumno1, Modulo.PROGRAMACION, 8.5);
        agregarNota(alumno1, Modulo.PROGRAMACION, 7.1);
        agregarNota(alumno1, Modulo.LENGUAJES_DE_MARCAS, 7.1);
        agregarNota(alumno1, Modulo.BASES_DE_DATOS, 9.0);
        agregarNota(alumno1, Modulo.SISTEMAS_INFORMATICOS, 7.5);

        agregarNota(alumno2, Modulo.PROGRAMACION, 9.5);
        agregarNota(alumno2, Modulo.BASES_DE_DATOS, 8.0);
        agregarNota(alumno2, Modulo.BASES_DE_DATOS, 9.0);
        agregarNota(alumno2, Modulo.SISTEMAS_INFORMATICOS, 7.5);

        agregarNota(alumno3, Modulo.PROGRAMACION, 7.5);
        agregarNota(alumno3, Modulo.BASES_DE_DATOS, 8.0);
        agregarNota(alumno3, Modulo.SISTEMAS_INFORMATICOS, 8.5);
        agregarNota(alumno3, Modulo.SISTEMAS_INFORMATICOS, 8.2);

        mostrarDatos();
    }

    public static void agregarNota(Alumno alumno, Modulo modulo, double nota) {
        ArrayList<Calificacion> calificacionesAlumno = notasAlumnos.get(alumno);
        if (calificacionesAlumno == null) {
            calificacionesAlumno = new ArrayList<>();
            notasAlumnos.put(alumno, calificacionesAlumno);
        }
        Calificacion calificacion = null;
        for (Calificacion c : calificacionesAlumno) {
            if (c.getModulo() == modulo) {
                calificacion = c;
                break;
            }
        }
        if (calificacion == null) {
            calificacion = new Calificacion(modulo);
            calificacionesAlumno.add(calificacion);
        }
        calificacion.getNotas().add(nota);
    }

    public static void mostrarDatos() {
        String s;
        for (Map.Entry<Alumno, ArrayList<Calificacion>> entry : notasAlumnos.entrySet()) {
            s = "";
            Alumno alumno = entry.getKey();
            ArrayList<Calificacion> calificaciones = entry.getValue();
            s += alumno.getNombre() + "(" + alumno.getNia() + ")\n";
            for (Calificacion calificacion : calificaciones) {
                String modulo = calificacion.getModulo().getNombre();
                ArrayList<Double> notas = calificacion.getNotas();
                s += modulo + " " + notas + "\n";
            }
            System.out.println("\n"+s);
        }
    }
}
