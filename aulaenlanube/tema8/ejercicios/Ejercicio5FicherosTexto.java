package aulaenlanube.tema8.ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5FicherosTexto {

    private static final int DESPLAZAMIENTO = 3;
    private static final String NOMBRE_FICHERO = "fichero.txt";

    public static void main(String[] args) {

        encriptarArchivo(NOMBRE_FICHERO, "fichero_encriptado.txt");
        desencriptarArchivo("fichero_encriptado.txt", "fichero_desencriptado.txt");
    }

    // método que desencripta datos en el archivo con código césar = DESPLAZAMIENTO
    public static void desencriptarArchivo(String rutaEntrada, String rutaSalida) {
        procesarArchivo(rutaEntrada, rutaSalida, true);
    }

    // método que encripta datos en el archivo con código césar = DESPLAZAMIENTO
    public static void encriptarArchivo(String rutaEntrada, String rutaSalida) {
        procesarArchivo(rutaEntrada, rutaSalida, false);
    }

    // método que encripta/desencripta en base al booleano
    public static void procesarArchivo(String rutaEntrada, String rutaSalida, boolean estaEncriptado) {
        try {
            File archivoEntrada = new File(rutaEntrada);
            if (!archivoEntrada.exists() || !archivoEntrada.isFile()) {
                throw new FileNotFoundException();
            }

            File archivoSalida = new File(rutaSalida);
            BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

            int datos;
            while ((datos = lector.read()) != -1) {
                char c = (char) datos;
                if (estaEncriptado)
                    escritor.write(c - DESPLAZAMIENTO); // desencriptamos
                else
                    escritor.write(c + DESPLAZAMIENTO); // encriptamos
            }
            lector.close();
            escritor.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: el fichero no existe o no es un archivo válido");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al procesar el archivo");
        }
    }

}
