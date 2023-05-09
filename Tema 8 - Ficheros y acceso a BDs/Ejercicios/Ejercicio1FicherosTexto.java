import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1FicherosTexto {

    public static void main(String[] args) {
        String fileName = "archivo.txt";
        int lines = 10;

        createFileWithLines(fileName, lines);
    }

    // Crea un método que reciba el nombre de un archivo, y un entero. El método
    // deberá crear el archivo y escribir ‘n’ líneas dentro. Cada línea deberá tener
    // escrito “Esta es la línea n”, sustituyendo ‘n’ por el número de la línea.
    public static void createFileWithLines(String fileName, int numLines) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 1; i <= numLines; i++) {
                bufferedWriter.write("Esta es la línea " + i);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            System.out.println("Archivo " + fileName + " creado con " + numLines + " líneas.");
        } catch (IOException e) {
            System.out.println("Error al crear o escribir en el archivo: " + e.getMessage());
        }
    }
}
