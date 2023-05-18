package aulaenlanube.tema8.ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4FicherosTexto {

    public static void main(String[] args) {

        eliminarPalabras("archivo.txt", "Sd");
    }

    // Crea un método que permita eliminar todas las ocurrencias de una palabra dada
    // en un fichero de texto. Este código producirá automáticamente un nuevo
    // fichero con la siguiente nomenclatura: Si el fichero de entrada se llama
    // fichero.txt, el fichero generado se llamará fichero_2.txt.
    public static void eliminarPalabras(String nombreFichero, String palabra) {

        try {
            File fichero = new File(nombreFichero);
            if (!fichero.exists() || !fichero.isFile()) {
                throw new FileNotFoundException();
            }

            // lector del fichero origen
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            Scanner scn = new Scanner(br);

            // escritor del fichero destino
            String nombreFicheroNuevo = nombreFichero.replace(".txt", "_2.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFicheroNuevo));

            String linea;
            while (scn.hasNextLine()) {
                linea = scn.nextLine().replaceAll(palabra, "");
                bw.write(linea+"\n");
            }
            scn.close();
            bw.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + nombreFichero + " no existe o no es un archivo válido");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al procesar el archivo");
        }
    }
}
