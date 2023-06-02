package aulaenlanube.tema8.ejemplos.ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploBinarios {

    public static void main(String[] args) {

        String fichero = "ejemplo.dat";
        boolean aprobado = false;
        String nombreAlumno = "Pepe";
        int conv = Integer.MAX_VALUE;
        float nota = 7.8f;
       
        
        try {
            //escribimos datos en el fichero binario
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fichero));
            out.writeBoolean(aprobado);
            out.writeUTF(nombreAlumno);
            out.writeInt(conv);
            out.writeFloat(nota);
            out.close();

            //leemos datos del fichero binario
            DataInputStream in = new DataInputStream(new FileInputStream(fichero));
            System.out.println("Valor leído de aprobado: " + in.readBoolean());
            System.out.println("Valor leído de nombreAlumno: " + in.readUTF());
            System.out.println("Valor leído de convocatoria: " + in.readInt());
            System.out.println("Valor leído de nota: " + in.readFloat());
            in.close();

        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }
}
