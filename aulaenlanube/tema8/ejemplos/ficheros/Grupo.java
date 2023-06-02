package aulaenlanube.tema8.ejemplos.ficheros;

import java.io.Serializable;
import java.util.ArrayList;

public class Grupo implements Serializable {

    private String nombre;
    private ArrayList<Alumno> alumnos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        alumnos = new ArrayList<>();
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

    public void mostrarAlumnos() {
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        String s = "El nombre del Grupo es: " + getNombre() + "\n";
        for (Alumno alumno : alumnos) {
            s += alumno.toString() + "\n";
        }
        return s;
    }
}
