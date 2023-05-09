import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EjemploPrintWriter2 {

    public static void main(String args[]) {

        String frase = "Frase intermedia";
        String nombreFichero  = "ficheroEnteros.txt";

        try {
            


            Scanner scn = new Scanner(new FileReader(nombreFichero ));
            while (scn.hasNext()) {
                if (scn.hasNextInt())  System.out.println("Valor leído: " + scn.nextInt());
                else scn.next();
            }
            scn.close();

        } catch (IOException e) {
            System.out.println("Problemas en el fichero");
        }
    }

}
