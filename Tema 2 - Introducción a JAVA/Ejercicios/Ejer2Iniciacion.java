
/**
 * Ejercicio 2 - Iniciación a JAVA
 * 
 * Dado un número entero positivo, determinar cuántos dígitos tiene. 
 * No se pueden utilizar ni variables, ni funciones de tipo String. 
 * 
 * Ejemplo para entrada: [12343]
 * Salida:               [El número introducido tiene 5 cifras]
 *        
 */

import java.util.Scanner;

public class Ejer2Iniciacion {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un número");
        int num = entrada.nextInt();
        int cifras = 1;

        if (num < 0) {
            System.out.println("No se pueden introducir números negativos");
        } else {
            while (num > 9) {
                num /= 10;
                cifras++;
            }
            System.out.println("El número introducido tiene " + cifras + " " + (cifras == 1 ? "cifra" : "cifras"));
        }
        entrada.close();
    }
}
