package aulaenlanube.tema8.ejemplos;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploWriteUTF {

    public static void main(String[] args) {

        String fichero = "datos.dat";
        char letra1 = '\u0000';
        char letra2 = '\u0800';
        char letra3 = '\u0800';
        String datos1 = "aa" + letra1;
        String datos2 = "aa" + letra2;
        String datos3 = "aa" + letra3;

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fichero));
            out.writeUTF(datos1);
            out.writeUTF(datos2);
            out.writeUTF(datos3);
            out.close();

        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }
}
