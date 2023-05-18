package aulaenlanube.tema7.ejemplos;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {

    public static void main(String[] args) {

        Set<String> nombres = new TreeSet<>();
        nombres.add("Pep");
        nombres.add("Tom");
        nombres.add("Sam");
        nombres.add("Ben");
        System.out.println(nombres);

        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(5);
        nums.add(3);
        nums.add(1);
        nums.add(9);
        nums.add(2);
        nums.add(8);
        nums.add(7);
        nums.add(5);
        System.out.println(nums); // [1, 2, 3, 5]
        System.out.println(nums.ceiling(4));
        System.out.println(nums.ceiling(5));
        System.out.println(nums.floor(4));
        System.out.println(nums.floor(5));
        System.out.println(nums.lower(8));
        System.out.println(nums.higher(2));
        System.out.println(nums.pollFirst());
        System.out.println(nums.pollLast());
        System.out.println(nums);

        TreeSet<Alumno> dam = new TreeSet<>(new AlumnoPorEdadComparator());
        Alumno a1 = new Alumno("Pep", "222A", 25);
        Alumno a2 = new Alumno("Sam", "555A", 18);
        Alumno a3 = new Alumno("Pol", "666A", 18);
        Alumno a4 = new Alumno("Kal", "666A", 20);
        Alumno a5 = new Alumno("Tim", "777A", 20);
        Alumno a6 = new Alumno("Pep", "222A", 28);

        dam.add(a1);
        System.out.println(dam);
        dam.add(a2);
        System.out.println(dam);
        dam.add(a3);
        System.out.println(dam);
        dam.add(a4);        
        System.out.println(dam);
        dam.add(a5);
        System.out.println(dam);
        dam.add(a6);
        System.out.println(dam);
    }

}
