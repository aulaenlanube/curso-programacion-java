import java.util.ArrayList;
import java.util.Collections;

public class Instituto5 {

    public static void main(String[] args) {

        ArrayList<PersonaCentroEducativo> instituto = new ArrayList<>();
        instituto.add(new Alumno("Pep", "222A", 25));
        instituto.add(new Alumno("Tom", "111A", 20));
        instituto.add(new Alumno("Jon", "444A", 21));
        instituto.add(new Alumno("Tim", "333A", 19));
        instituto.add(new Alumno("Ada", "555A", 18));
        instituto.add(new Docente("Kal", 5, 2000));
        instituto.add(new Docente("Ana", 15, 3000));
        instituto.add(new Docente("Sam", 2, 1800));
        instituto.add(new Docente("Pol", 8, 2500));
        instituto.add(new Docente("Ben", 10, 2700));
        instituto.add(new Direccion("Kim", "Jefe de estudios"));
        
        System.out.println("Alumnos y docentes ordenados por nombre");
        Collections.sort(instituto, new NombreComparatorCentroEducativo());        
        
        for (Object o : instituto) {
            System.out.println(o);            
        }


    }



}
