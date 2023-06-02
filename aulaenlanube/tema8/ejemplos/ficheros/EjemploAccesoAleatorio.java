package aulaenlanube.tema8.ejemplos.ficheros;

import java.io.IOException;
import java.io.RandomAccessFile;

public class EjemploAccesoAleatorio {
    public static void main(String[] args) {

        try {

            RandomAccessFile raf = new RandomAccessFile("random.dat", "rw");

            for (int i = 0; i < 10; i++) {
                raf.writeInt(i);
            }

            raf.seek(19);
            //1-4:   (num=0) 00000000 00000000 00000000 00000000
            //5-8:   (num=1) 00000000 00000000 00000000 00000001
            //9-12:  (num=2) 00000000 00000000 00000000 00000010
            //13-16: (num=3) 00000000 00000000 00000000 00000011
            //17-20: (num=4) 00000000 00000000 00000000 00000100
            //21-24: (num=5) 00000000 00000000 00000000 00000101
            //25-28: (num=6) 00000000 00000000 00000000 00000110
            //29-32: (num=7) 00000000 00000000 00000000 00000111
            //33-36: (num=8) 00000000 00000000 00000000 00001000
            //37-40: (num=9) 00000000 00000000 00000000 00001001
            
            int sexto = raf.readInt(); //19: 00000100 00000000 00000000 00000000
            System.out.println("El entero es: " + sexto);

            raf.close();

        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
