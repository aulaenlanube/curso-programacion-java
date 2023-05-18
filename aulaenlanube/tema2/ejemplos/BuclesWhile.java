package aulaenlanube.tema2.ejemplos;

import java.util.Scanner;

public class BuclesWhile {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int num = 0;
        int total = 0;
        do {
            System.out.println("Introduce un número distinto de cero para seguir en el bucle");
            num = teclado.nextInt();
            total += num;
        } while (num != 0);

        System.out.println("La suma es: " + total);
        teclado.close();

    }

}
