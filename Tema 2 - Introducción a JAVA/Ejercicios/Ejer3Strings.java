
/**
 * Ejercicio 3 - Strings en JAVA
 * 
 * Crea un programa en JAVA que lea por teclado una cadena de texto e indique la cantidad de palabras que tiene. 
 * De la clase String, únicamente se pueden utilizar los métodos charAt(), trim() y length(). 
 * 
 * Ejemplo para entrada: [ Hoy es viernes,  27 de octube    de 2022   ] 
 * Salida:               [La frase tiene 8 palabras]
 * 
 */

import java.util.Scanner;

public class Ejer3Strings {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Dime una frase");
        String frase = entrada.nextLine().trim();
        int palabras = 1;        

        for (int i = 0; i < frase.length() - 1; i++) {
            if (frase.charAt(i) == ' ' && frase.charAt(i + 1) != ' ')
                palabras++;    
        }

        System.out.println("La frase tiene "+palabras+" palabra"+(palabras > 1 ? "s" : ""));
        entrada.close();
    }
    
}
