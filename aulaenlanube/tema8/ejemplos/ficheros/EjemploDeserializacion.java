package aulaenlanube.tema8.ejemplos.ficheros;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EjemploDeserializacion {

    public static void main(String[] args) {

        try {

            FileInputStream fis = new FileInputStream("archivo.dat");
            ObjectInputStream in = new ObjectInputStream(fis);

            System.out.println((Grupo)in.readObject());
            System.out.println("El entero es: "+(int)in.readInt());
            System.out.println((Alumno)in.readObject());

            in.close();

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } 
    }
}
