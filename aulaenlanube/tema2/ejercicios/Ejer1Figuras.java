package aulaenlanube.tema2.ejercicios;
/**
 * Ejercicio 1 - Figuras en JAVA
 * 
 * Crear un programa en JAVA que dibuje un rectángulo formado por asteriscos(*). 
 * Se deben pedir base y altura por teclado. 
 * Además, añade código adicional para que dibuje dicho rectángulo sin relleno
 * 
 * Ejemplo para entrada: base = 10 , altura = 5 
 * Salida: 
 *          * * * * * * * * * * 
 *          * * * * * * * * * *
 *          * * * * * * * * * *
 *          * * * * * * * * * *
 *          * * * * * * * * * *
 *
 *          * * * * * * * * * *
 *          *                 *
 *          *                 *
 *          *                 *
 *          * * * * * * * * * *       
 */

 import java.util.Scanner;

public class Ejer1Figuras {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la base del rectángulo");
        int base = entrada.nextInt();
        System.out.println("Introduce la altura del rectángulo");
        int altura = entrada.nextInt();        

        // con relleno
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println();

        // sin relleno
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {

                if(i == 0 || i == altura - 1 || j == 0 || j == base-1) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }

        entrada.close();
    }

}
