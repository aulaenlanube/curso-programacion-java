package aulaenlanube.tema8.ejemplos.ficheros;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class EjemploTextoNio {
    public static void main(String[] args) {
        
        try {

            List<String> lineasEscritas = Arrays.asList("Hola", "Mundo", "Desde", "Java", "NIO");
            Path fichero = Paths.get("archivoNIO.txt");

            // Escribe las líneas en el archivo
            Files.write(fichero, lineasEscritas, StandardCharsets.UTF_8);

            // Lee todas las líneas del archivo
            List<String> lineasLeidas  = Files.readAllLines(fichero, StandardCharsets.UTF_8);
            
            for (String s : lineasLeidas) {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
