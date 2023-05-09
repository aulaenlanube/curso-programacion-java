import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioBufferedReader {

    public static void main(String[] args) {
        String nombreArchivo = "archivo.txt";

        try {
            int palabras = contarPalabras(nombreArchivo);
            System.out.println("El archivo " + nombreArchivo + " contiene " + palabras + " palabras.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Crea un método que reciba un archivo y devuelva la cantidad de palabras de
    // dicho archivo
public static int contarPalabras(String nombreArchivo) throws IOException {

    int palabras = 0;

    try {

        FileReader fileReader = new FileReader(nombreArchivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea;

        while ((linea = bufferedReader.readLine()) != null) {
            String[] words = linea.split("\\s+");
            palabras += words.length;
        }
        //al cerrar el BufferedReader se cierra también el FileReader
        bufferedReader.close();
        
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }
    return palabras;
}
}
