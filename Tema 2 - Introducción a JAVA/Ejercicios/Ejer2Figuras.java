/**
 * Ejercicio 2 - Figuras en JAVA
 * 
 * Crear un programa en JAVA que dibuje un triángulo rectángulo formado por asteriscos(*). 
 * Se deben pedir la altura del triángulo por teclado. 
 * Además, añade código adicional para que dibuje dicho triángulo sin relleno
 * 
 * Ejemplo para entrada: altura = 5 
 * Salida: 
 *          *
 *          * *
 *          * * *
 *          * * * *
 *          * * * * *
 *
 *          *
 *          * *
 *          *   *
 *          *     *
 *          * * * * *     
 */

import java.util.Scanner;

public class Ejer2Figuras {

    public static void main(String[] args) {
        

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la altura del triángulo");
        int altura = entrada.nextInt();
        System.out.println();        

        // con relleno
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println();

        // sin relleno
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j <= i; j++) {

                if(i == 0 || i == altura - 1 || j == 0 || j == i) System.out.print("* ");
                else System.out.print("  ");

            }
            System.out.println();
        }
        entrada.close();
    }
    
}
