import java.util.Set;
import java.util.TreeSet;

public class Instituto8 {

    public static void main(String[] args) {

        Set<Alumno> dam = new TreeSet<>();
        Alumno a1 = new Alumno("Pep", "222A", 25);
        Alumno a2 = new Alumno("Sam", "666A", 18);
        Alumno a3 = new Alumno("Sam", "666A", 18);
        Alumno a4 = new Alumno("Kal", "666A", 20);

        dam.add(a1);
        dam.add(a2);
        dam.add(a3);
        dam.add(a4);

        dam.add(a1); 
        dam.add(new Alumno("Sam", "777A", 18));              

        for (Alumno a : dam) {
            System.out.println(a);
        }    
    }
}
