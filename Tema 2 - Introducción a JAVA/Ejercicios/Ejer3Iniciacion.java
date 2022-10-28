
/**
 * Ejercicio 3 - Iniciación a JAVA
 * 
 * Escribir un programa que pida números enteros positivos hasta que se introduzca un cero.
 * A continuación debe mostrar la suma total de dichos números. 
 * Se deben incluir todos los números positivos que hemos ido introduciendo por teclado. 
 * No se pueden utilizar Arrays.
 * 
 * Ejemplo para entrada: [3, 4, 5, 6, -2, 8, 0] 
 * Salida:               [3+4+5+6+8=26]
 * 
 */

import java.util.Scanner;

public class Ejer3Iniciacion {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int num;
        int total = 0;
        String textoSuma = "";

        do {
            System.out.println("Introduce un entero positivo, cero para salir");
            num = entrada.nextInt();

            if (num > 0) {
                total += num;
                textoSuma += num + "+";
            }

        } while (num != 0);
        System.out.println(textoSuma + "\b=" + total);
        entrada.close();
    }
}
