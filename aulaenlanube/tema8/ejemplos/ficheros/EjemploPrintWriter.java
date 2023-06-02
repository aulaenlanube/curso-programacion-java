package aulaenlanube.tema8.ejemplos.ficheros;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class EjemploPrintWriter {

    public static void main(String args[]) {

        String fichero = "fichero.txt";

        try {
           
            PrintWriter pw = new PrintWriter(new FileWriter(fichero));
            
            pw.print("Esto es un texto sin salto de línea");
            pw.println("NUEVO PALABRA");
            pw.println("Esto es un texto con salto de línea");
            pw.println(4.5455);

            // para repasar programación funcional
            Arrays.stream(new int[] { 1, 2, 3, 4, 10 })
                    .filter(n -> n > 2)
                    .map(n -> n * 2)
                    .forEach(n -> pw.println(n));

            pw.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Problemas al escribir en el fichero");
        }
    }
}
