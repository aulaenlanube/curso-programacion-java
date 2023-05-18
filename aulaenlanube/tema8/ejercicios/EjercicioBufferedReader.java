package aulaenlanube.tema8.ejercicios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EjercicioBufferedReader {

    public static void main(String[] args) {

        String nombreArchivo = "archivo.txt";
        contarPalabras(nombreArchivo);           
        
    }

    // Crea un método que reciba un archivo y devuelva la cantidad de palabras de
    // dicho archivo
    public static void contarPalabras(String nombreArchivo) {
        
        try {
            int palabras = 0;            
            Scanner scn = new Scanner(new BufferedReader(new FileReader(nombreArchivo)));
            
            while (scn.hasNextLine()) {
                palabras += Arrays.stream(scn.nextLine().split("\\s+")).count();
            }
            // cerramos el scanner
            scn.close();

            System.out.println("El archivo " + nombreArchivo + " contiene " + palabras + " palabras");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
