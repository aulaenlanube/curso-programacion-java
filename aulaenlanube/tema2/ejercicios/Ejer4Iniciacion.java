package aulaenlanube.tema2.ejercicios;
/**
 * Ejercicio 4 - Iniciación a JAVA
 * 
 * Dada una secuencia de números enteros positivos acabada en 0.
 * Obtener la suma de aquellos números tales que su número de cifras sea igual a la suma de las mismas.
 * No se pueden utilizar Arrays.
 * 
 * Ejemplo para entrada: [1, -111, 5, 111, 66, 201, 27, 0]
 * Salida:               [1+111+201=313]
 * 
 */

import java.util.Scanner;

public class Ejer4Iniciacion {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String resultado = "";
        int total = 0;
        int num = 0;

        do {
            System.out.println("Introduce un número positivo, cero para terminar");
            num = entrada.nextInt();
            int cifras = 1;
            int suma = num % 10;
            int aux = num;

            while (aux > 9) {
                aux /= 10;
                cifras++;
                suma += aux % 10;
            }
            if (cifras == suma) {
                resultado += num + "+";
                total += num;
            }
        } while (num != 0);

        System.out.println(resultado + "\b=" + total);
        entrada.close();
    }

}
