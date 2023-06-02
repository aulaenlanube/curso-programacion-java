package aulaenlanube.tema8.ejemplos.ficheros;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EjemploScanner {

    public static void main(String args[]) {
        File archivo = new File("fichero4.txt");
        try {
               Scanner scn = new Scanner(archivo);
   
               while (scn.hasNextLine()) {
                   String linea = scn.nextLine();
                   System.out.println(linea);
               }
               scn.close();
   
           } catch (FileNotFoundException e) {
               System.err.println("No se pudo encontrar el archivo");
           }
   }
   
    
}
