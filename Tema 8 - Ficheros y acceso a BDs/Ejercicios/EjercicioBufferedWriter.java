import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EjercicioBufferedWriter {

    public static void main(String[] args) {
        String nombreFichero = "archivo.txt";
        int numLineas = 10;

        createFileWithLines(nombreFichero, numLineas);
    }

    // Crea un método que reciba el nombre de un archivo, y un entero. El método
    // deberá crear el archivo y escribir ‘n’ líneas dentro. Cada línea deberá tener
    // escrito “Esta es la línea n”, sustituyendo ‘n’ por el número de la línea.
    public static void createFileWithLines(String nombreFichero, int numLineas) {
        try {
            FileWriter fileWriter = new FileWriter(nombreFichero);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 1; i <= numLineas; i++) {
                bufferedWriter.write("Esta es la línea " + i);
                bufferedWriter.newLine();
            }

            //al cerrar el BufferedWriter se cierra también el FileWriter
            bufferedWriter.close();

            System.out.println("Archivo " + nombreFichero + " creado con " + numLineas + " líneas.");
        } catch (IOException e) {
            System.out.println("Error al crear o escribir en el archivo: " + e.getMessage());
        }
    }
}
