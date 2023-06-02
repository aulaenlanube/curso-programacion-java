package aulaenlanube.tema8.ejemplos.ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploBinarios2 {

    public static void main(String[] args) throws IOException {

        String fileName = "archivoBinario.dat";
        int[] nums = { 1, 2, 3, 4, 5 };

        // Escribir datos en el archivo binario
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            for (int num : nums)
                fos.write(num);
            System.out.println("Datos escritos en el archivo binario.");
            fos.close();

        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Leer datos desde el archivo binario
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int num;
            System.out.println("Datos leídos desde el archivo binario:");
            while ((num = fis.read()) != -1)
                System.out.print(num + " ");
            fis.close();

        } catch (IOException e) {
            System.err.println("Error al leer desde el archivo: " + e.getMessage());
        }
    }
}
