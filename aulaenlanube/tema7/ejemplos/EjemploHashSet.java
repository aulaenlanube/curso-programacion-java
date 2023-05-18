package aulaenlanube.tema7.ejemplos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EjemploHashSet {

    public static void main(String[] args) {

        Set<Integer> nums = new HashSet<>();
        nums.add(5);
        nums.add(8);
        nums.add(2);
        nums.add(3);
        nums.add(3);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println(nums);
        System.out.println(nums.contains(1));

        List<Integer> nums2 = new ArrayList<>();
        nums.add(5);
        nums.add(8);
        nums.add(2);
        nums.add(3);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println(nums); // [5, 8, 2, 3, 3, 3, 4, 5]
        Set<Integer> nums3 = new HashSet<>(nums2);
        System.out.println(nums3); // [2, 3, 4, 5, 8]

        Set<String> nombres = new HashSet<>();
        nombres.add("Pep");
        nombres.add("Tom");
        nombres.add("Jon");
        nombres.add("Pep");
        nombres.add("Kal");
        nombres.add("Tom");
        System.out.println(nombres);
        //nombres.remove(2);
        nombres.remove("Tom");
        System.out.println(nombres);

        Set<Alumno> dam = new HashSet<>();
        dam.add(new Alumno("Pep", "222A", 25));
        dam.add(new Alumno("Sam", "666A", 18));
        dam.add(new Alumno("Kal", "777A", 20));

        Iterator<Alumno> iteratorAlumnos = dam.iterator();
        while (iteratorAlumnos.hasNext()) {
            iteratorAlumnos.next().setNia("AAA");
        }
        System.out.println(dam);
    }
}
