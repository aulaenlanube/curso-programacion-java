package aulaenlanube.tema8.ejemplos.ficheros;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploBinariosBuffer {

    public static void main(String[] args) {

        String fichero = "ejemplo.dat";
        String nombre = "PRG";
        int conv = 1;
        double nota = 7.8;
        
        try {
            FileOutputStream fos = new FileOutputStream(fichero);          
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(fos));
            
            out.writeUTF(nombre);
            out.writeInt(conv);
            out.writeDouble(nota);
            out.close();

            DataInputStream in = new DataInputStream(new FileInputStream(fichero));
            System.out.println("Valor leído de nombre: " + in.readUTF());
            System.out.println("Valor leído de convocatoria: " + in.readInt());
            System.out.println("Valor leído de nota: " + in.readDouble());
            in.close();

        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }
}
