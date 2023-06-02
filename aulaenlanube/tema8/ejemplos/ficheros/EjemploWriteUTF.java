package aulaenlanube.tema8.ejemplos.ficheros;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploWriteUTF {

    public static void main(String[] args) {

        String fichero = "datos.dat";

        String datos1 = "a\u0056";
        System.out.println(datos1);

        String datos2 = "a\u0159";
        System.out.println(datos2);
        
        String datos3 = "a\u1000";
        System.out.println(datos3);

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
