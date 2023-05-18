package aulaenlanube.tema2.ejemplos;
public class Ternarias {

    public static void main(String[] args) {

        int a = 1, b = 2, c = 3;
        boolean condicion = a == 1 ? true : false;
        if (condicion)
            System.out.println("a vale 1");
        else
            System.out.println("a no vale 1");

        condicion = a == 3 ? true : b == 3 ? true : c == 3 ? true : false;
        if (condicion)
            System.out.println("Alguna variable vale 3");
        else
            System.out.println("Ninguna variable vale 3");

        a = a != 0 ? 2 : 3; // a vale 2
        b = a == c ? 2 : 1; // b vale 1

        // caso 1
        a = 1;
        b = 2;
        c = 3;
        int resultado = a++ == 2 && c > b++ ? a += b : // b no se incrementa
                a > 0 && a == b ? a += c : a == c ? a++ : a--; // a=5, b=2, c=3,resultado=5
        // caso 2
        a = 1;
        b = 2;
        c = 3;
        resultado = a++ == 1 && a > b++ ? a += b : a > 0 && a == b ? a += c : a == c ? a++ : a--; // a=1, b=3, c=3,
                                                                                                  // resultado=2
        // caso 3
        a = 1;
        b = 2;
        c = 3;
        resultado = a++ == 1 && a > b++ ? a += b : a > 0 && a == b ? a += c : b == c ? a++ : a--; // a=3, b=3, c=3,
                                                                                                  // resultado=2

        System.out.println(resultado);
    }

}
