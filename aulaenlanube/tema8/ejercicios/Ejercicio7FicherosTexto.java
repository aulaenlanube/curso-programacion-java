package aulaenlanube.tema8.ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio7FicherosTexto {

    public static void main(String[] args) {
        String nombreArchivo1 = "archivo1.txt";
        String nombreArchivo2 = "archivo2.txt";
        String nombreArchivoResultado = "archivoCombinado.txt";

        try {
            combinarArchivos(nombreArchivo1, nombreArchivo2, nombreArchivoResultado);
            System.out.println("Se ha combinado el contenido de " + nombreArchivo1 + " y " + nombreArchivo2
                    + " en el archivo " + nombreArchivoResultado);
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en los archivos: " + e.getMessage());
        }
    }

    // Crea un método que reciba 2 archivos de texto y combine el contenido de los 2
    // archivos. Para ello, se creará un nuevo archivo donde se debe añadir una
    // palabra de cada archivo de forma consecutiva mientras queden palabras en cada
    // uno de los archivos, si algún archivo se queda sin palabras se deben añadir
    // las todas las palabras del otro archivo
    public static void combinarArchivos(String nombreArchivo1, String nombreArchivo2, String nombreArchivoResultado)
            throws IOException {
        List<String> palabrasArchivo1 = obtenerPalabrasDeArchivo(nombreArchivo1);
        List<String> palabrasArchivo2 = obtenerPalabrasDeArchivo(nombreArchivo2);

        try (FileWriter escritorArchivo = new FileWriter(nombreArchivoResultado);
                BufferedWriter escritorBuffer = new BufferedWriter(escritorArchivo)) {

            int index1 = 0, index2 = 0;
            while (index1 < palabrasArchivo1.size() || index2 < palabrasArchivo2.size()) {
                if (index1 < palabrasArchivo1.size()) {
                    escritorBuffer.write(palabrasArchivo1.get(index1++) + " ");
                }
                if (index2 < palabrasArchivo2.size()) {
                    escritorBuffer.write(palabrasArchivo2.get(index2++) + " ");
                }
            }
        }
    }

    public static List<String> obtenerPalabrasDeArchivo(String nombreArchivo) throws IOException {
        List<String> palabras = new ArrayList<>();

        try (FileReader lectorArchivo = new FileReader(nombreArchivo);
                BufferedReader lectorBuffer = new BufferedReader(lectorArchivo)) {

            String linea;
            while ((linea = lectorBuffer.readLine()) != null) {
                String[] palabrasLinea = linea.split("\\s+");
                for (String palabra : palabrasLinea) {
                    if (!palabra.isEmpty()) {
                        palabras.add(palabra);
                    }
                }
                palabras.add("\n");// se añade el salto de línea (opcional)
            }
        }

        return palabras;
    }
}
