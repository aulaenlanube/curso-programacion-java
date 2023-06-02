package aulaenlanube.tema8.ejemplos.ficheros;
import java.io.FileReader;
import java.io.IOException;

public class EjemploFileReader {

    public static void main(String[] args) {

        String fichero = "fichero.txt";

        try {
            // creamos un objeto FileReader
            FileReader fileReader = new FileReader(fichero);

            // leer y mostrar el contenido del archivo
            int caracter;
            System.out.println("Contenido del archivo " + fichero + ":");
            while ((caracter = fileReader.read()) != -1) {
                System.out.print((char)caracter);
            }

            // cerramos el FileReader
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo");            
        }

    }

}
