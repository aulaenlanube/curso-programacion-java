package aulaenlanube.tema5.ejemplos;

public class Inmutables {

    public static void main(String[] args) {

        String s1 = new String("Hola");
        String s2 = new String("Hola");

        if (s1 == s2)
            System.out.println("Son iguales");
        else
            System.out.println("Son distintas");

        if (s1.equals(s2))
            System.out.println("Son iguales");
        else
            System.out.println("Son distintas");

        System.out.println(s1);
        System.out.println(s2);
    }

}
