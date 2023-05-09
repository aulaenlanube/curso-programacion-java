import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2FicherosTexto {

    public static void main(String[] args) {
        String nombreArchivo = "archivo.txt";
        try {
            capitalizarPalabras(nombreArchivo);
            System.out.println("Se ha modificado el contenido del archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
        }
    }

    // Crea un método que reciba un archivo de texto y modifique su contenido, de
    // modo que cada palabra del archivo deberá empezar en mayúscula
    public static void capitalizarPalabras(String nombreArchivo) throws IOException {
        List<String> lineasModificadas = new ArrayList<>();

        try (FileReader lectorArchivo = new FileReader(nombreArchivo);
                BufferedReader lectorBuffer = new BufferedReader(lectorArchivo)) {

            String linea;
            while ((linea = lectorBuffer.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                StringBuilder lineaModificada = new StringBuilder();

                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        lineaModificada.append(Character.toUpperCase(palabra.charAt(0)))
                                .append(palabra.substring(1))
                                .append(" ");
                    }
                }

                lineasModificadas.add(lineaModificada.toString().trim());
            }
        }

        try (FileWriter escritorArchivo = new FileWriter(nombreArchivo);
                BufferedWriter escritorBuffer = new BufferedWriter(escritorArchivo)) {

            for (String lineaModificada : lineasModificadas) {
                escritorBuffer.write(lineaModificada);
                escritorBuffer.newLine();
            }
        }
    }
}
