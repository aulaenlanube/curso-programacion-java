package aulaenlanube.tema2.ejercicios;
/**
 * Ejercicio 4 - Strings en JAVA
 * 
 * Crea un programa en JAVA que reciba una palabra por teclado e indique si es un palíndromo.
 * Un palíndromo es una palabra que se lee igual de derecha a izquierda, que de izquierda a derecha.
 * 
 * Ejemplo para entrada: [Reconocer] 
 * Salida:               [Es un palíndromo]
 * 
 */

import java.util.Scanner;

public class Ejer4Strings {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Dime una palabra");
        String palabra = entrada.nextLine().toLowerCase();
        String invertida = "";
        boolean palindromo = true;

        // solución 1: invertir palabra
        for (int i = palabra.length() - 1; i >= 0; i--) {
            invertida += palabra.charAt(i);
        }

        if (palabra.equals(invertida))
            System.out.println("Es un palíndromo");
        else
            System.out.println("NO es un palíndromo");

        // solución 2: maś eficiente, sin String auxiliar y menos pasadas por el bucle
        for (int i = 0; i < palabra.length() / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(palabra.length() - 1 - i)) {
                palindromo = false;
                break;
            }
        }

        if (palindromo)
            System.out.println("Es un palíndromo");
        else
            System.out.println("NO es un palíndromo");

        entrada.close();
    }
}
