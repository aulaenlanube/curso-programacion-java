package aulaenlanube.tema8.ejemplos;

import java.io.IOException;
import java.io.RandomAccessFile;

public class EjemploAccesoAleatorio {
    public static void main(String[] args) {

        String fichero = "random.dat";

        try {

            RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

            for (int i = 0; i < 10; i++) {
                raf.writeInt(i);
            }

            raf.seek(5 * 4);
            int sexto = raf.readInt();
            System.out.println("El sexto entero es: " + sexto);

            raf.close();

        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
