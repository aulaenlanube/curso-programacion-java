package aulaenlanube.tema2.ejercicios;
/**
 * Ejercicio 3 - Figuras en JAVA
 * 
 * Crear un programa en JAVA que dibuje un triángulo equilátero formado por asteriscos(*). 
 * Se deben pedir la altura del triángulo por teclado. 
 * Además, añade código adicional para que dibuje dicho triángulo sin relleno
 * 
 * Ejemplo para entrada: altura = 5 
 * Salida: 
 *                  *
 *                * * *
 *              * * * * *
 *            * * * * * * *
 *          * * * * * * * * *
 *          
 *                  *
 *                *   *
 *              *       *
 *            *           *
 *          * * * * * * * * *   
 */

import java.util.Scanner;

public class Ejer3Figuras {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la altura del triángulo");
        int altura = entrada.nextInt();

        // altura --> 5
        // base = filas*2-1 --> 9
        // 4 blancos 1 asterisco 4 blancos (indice 4)
        // 3 blancos 3 asterisco 3 blancos (indice 3,4,5)
        // 2 blancos 5 asterisco 2 blancos (indice 2,3,4,5,6)
        // 1 blancos 7 asterisco 1 blancos (indice 1,2,3,4,5,6,7)
        // 0 blancos 9 asterisco 0 blancos (indice 0,1,2,3,4,5,6,7,8)

        
        int base = altura * 2 - 1;
        System.out.println();

        // con relleno
        for (int i = 0; i < altura; i++) {
            
            for (int j = 0; j < base; j++) {

                if (j >= altura - 1 - i && j <= altura - 1 + i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println();

        // sin relleno
        for (int i = 0; i < altura; i++) {
            
            for (int j = 0; j < base; j++) {

                if (j == base / 2 - i || j == base / 2 + i || i == altura - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println();

        // con relleno versión 2
        for (int i = 0; i < altura; i++) {

            int cont = i % 2;
            for (int j = 0; j < base; j++) {                
                if (j >= base / 2 - i && j <= base / 2 + i && cont % 2 == 1) 
                    System.out.print("*");
                else
                    System.out.print(" ");
                cont++;
            }
            System.out.println();
        }

        System.out.println();
        entrada.close();
    }
}
