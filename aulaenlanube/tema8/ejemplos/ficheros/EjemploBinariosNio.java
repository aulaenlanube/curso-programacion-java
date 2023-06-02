package aulaenlanube.tema8.ejemplos.ficheros;

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
            buffer.position(1);

            //buffer
            // bytes 1-4(int=0):   00000000 00000000 00000000 00000000 
            // bytes 5-8(int=1):   00000000 00000000 00000000 00000001 
            // bytes 9-12(int=2):  00000000 00000000 00000000 00000010 
            // bytes 13-16(int=3): 00000000 00000000 00000000 00000011 

            //(0)   --> 00000000 00000000 00000000 00000000
            //(256) --> 00000000 00000000 00000001 00000000
            //(512) --> 00000000 00000000 00000010 00000000
            //error --> 00000000 00000000 00000011 --------

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
