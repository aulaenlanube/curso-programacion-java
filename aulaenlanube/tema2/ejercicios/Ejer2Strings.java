package aulaenlanube.tema2.ejercicios;
/**
 * Ejercicio 2 - Strings en JAVA
 * 
 * Crea un programa en JAVA que reciba 5 palabras y luego nos muestre la que tiene una longitud mayor.
 * Si hay más de una palabra con la longitud mayor, se deberá mostrar la primera que aparezca.
 * 
 * Ejemplo para entrada: [casa, mesa, ab, c, Ana] 
 * Salida:               [casa]
 * 
 */

import java.util.Scanner;

public class Ejer2Strings {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String palabra = "", palabraMax = "";

        for (int i = 1; i <= 5; i++) {

            System.out.println("Dime una palabra: " + i + " de 5");
            palabra = entrada.nextLine();

            if (palabra.length() > palabraMax.length())
                palabraMax = palabra;
        }

        System.out.println("La palabra más larga es: " + palabraMax);
        entrada.close();
    }

}
