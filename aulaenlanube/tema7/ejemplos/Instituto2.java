package aulaenlanube.tema7.ejemplos;
import java.util.ArrayList;
import java.util.Collections;

public class Instituto2 {

    public static void main(String[] args) {

        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pep", "1111A", 15));
        alumnos.add(new Alumno("Ana", "2222A", 17));
        alumnos.add(new Alumno("Ana", "3333A", 14));
        alumnos.add(new Alumno("Ben", "4444A", 14));
        
        Collections.sort(alumnos); //ordenamos en base al método compareTo de la clase Alumno
        System.out.println(alumnos); //Los muestra ordenados por edad → Ben Jon, Pep, Tom
        
        
    }
}
