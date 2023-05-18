package aulaenlanube.tema8.ejercicios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3FicherosTexto {

    public static void main(String[] args) {

        cantidadPalabras("archivo.txt", "88");
    }

    // Crea un método que debe crear n archivos, nombre(1).txt, nombre(2).txt,....
    // nombre(n).txt en la carpeta que se solicita al usuario. Dentro de cada
    // archivo deberá escribirse la frase “Este es el fichero nombre(n).txt”.
    // Utiliza un búfer para la lectura
    public static void cantidadPalabras(String nombreArchivo, String palabraBuscada) {
        int contador = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            Scanner scn = new Scanner(br);
            while (scn.hasNextLine()) {
                String[] palabrasLinea = scn.nextLine().split("\\s+");
                for (String palabraActual : palabrasLinea) {
                    if (palabraActual.equals(palabraBuscada)) {
                        contador++;
                    }
                }
            }
            scn.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo " + nombreArchivo);
        }
        System.out.println("La palabra '" + palabraBuscada + "' aparece " + contador + " veces en el archivo.");
    }
}
