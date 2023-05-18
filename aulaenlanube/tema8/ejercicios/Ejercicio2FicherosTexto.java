package aulaenlanube.tema8.ejercicios;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2FicherosTexto {

    public static void main(String[] args) {

        crearFicheros("ed.txt", 5);
    }

    // Crea un método que debe crear n archivos, nombre(1).txt, nombre(2).txt,....
    // nombre(n).txt en la carpeta que se solicita al usuario. Dentro de cada
    // archivo deberá escribirse la frase “Este es el fichero nombre(n).txt”.
    public static void crearFicheros(String ruta, int n) {

        if(new File(ruta).isDirectory()) {
            for (int i = 1; i <= n; i++) {
                String nombreFichero = ruta + "/nombre(" + i + ").txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
                    writer.write("Este es el fichero nombre(" + i + ").txt");
                } 
                catch (IOException e) {
                    System.out.println("Ocurrió un error al crear el archivo " + nombreFichero);
                    e.printStackTrace();
                }
            }
        }
        else System.out.println("La ruta no es válida");        
    }
}
