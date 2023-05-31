package aulaenlanube.tema8.ejemplos;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.*;

public class EjemploBinariosNio {
    public static void main(String[] args) {
        
        try {

            //ESCRITURA UTILIZANDO UN CANAL
            // Crea un nuevo archivo y obtén un canal para escribir en él
            FileOutputStream fos = new FileOutputStream("integers.bin");
            FileChannel canal = fos.getChannel();

            // Crea un buffer y pone algunos enteros en él
            ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES * 4);
            for (int i = 0; i < 4; i++) {
                buffer.putInt(i);
            }

            // Prepara el buffer para escribir
            buffer.flip();

            // Escribe el buffer en el archivo
            canal.write(buffer);
           
            fos.close();


            //LECTURA UTILIZANDO UN CANAL
            FileInputStream fis = new FileInputStream("integers.bin");
            canal = fis.getChannel();

            // Crea un buffer para almacenar los enteros
            buffer = ByteBuffer.allocate(Integer.BYTES * 4);

            // Lee del archivo en el buffer
            canal.read(buffer);
            // Prepara el buffer para la lectura
            buffer.flip();

            // Lee los enteros del buffer
            while (buffer.hasRemaining()) {
                System.out.println(buffer.getInt());
            }
            fis.close();

        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
