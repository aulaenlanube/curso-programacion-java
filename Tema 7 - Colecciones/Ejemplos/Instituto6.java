import java.util.LinkedList;

public class Instituto6 {

    public static void main(String[] args) {

        LinkedList<Alumno> dam = new LinkedList<>();
        //métodos interface Collection
        dam.add(new Alumno("Pep", "222A", 25));
        dam.add(new Alumno("Tom", "111A", 20));
        dam.add(new Alumno("Jon", "444A", 21));
        dam.add(new Alumno("Tim", "333A", 19));
        dam.add(new Alumno("Ada", "555A", 18));
        dam.add(new Alumno("Sam", "666A", 18));
        
        //métodos interface List
        dam.set(2,new Alumno("Ana", "777A",20));
        dam.add(2,new Alumno("Bil", "777A",20));

        //métodos interfaces Deque
        dam.pollFirst();
        dam.pollLast();
        dam.offerFirst(new Alumno("Jud", "888A", 24));
        dam.offerLast(new Alumno("Kim", "999A", 28));

        System.out.println(dam.removeFirst());
        System.out.println(dam.removeLast());

        System.out.println(dam);
        
    }

}
