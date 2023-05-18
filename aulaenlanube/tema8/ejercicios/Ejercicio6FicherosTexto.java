package aulaenlanube.tema8.ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Ejercicio6FicherosTexto {

    public static void main(String[] args) {

        String nombreArchivo = "archivo.txt";
        convertirPrimeraLetraAMayuscula(nombreArchivo);
    }

    // Crea un método que reciba un archivo de texto y modifique su contenido, de
    // modo que cada palabra del archivo deberá empezar en mayúscula
    public static void convertirPrimeraLetraAMayuscula(String rutaArchivo) {
        
        File archivo = new File(rutaArchivo);
        StringBuilder contenidoModificado = new StringBuilder();
    
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
    
            while ((linea = lector.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        contenidoModificado.append(Character.toUpperCase(palabra.charAt(0)))
                                .append(palabra.substring(1))
                                .append(" ");
                    } else {
                        contenidoModificado.append(" ");
                    }
                }
                contenidoModificado.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            escritor.write(contenidoModificado.toString());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
}
