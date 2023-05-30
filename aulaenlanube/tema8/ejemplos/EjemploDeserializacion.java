package aulaenlanube.tema8.ejemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EjemploDeserializacion {

    public static void main(String[] args) {

        try {

            Grupo dam = null;
            FileInputStream fis = new FileInputStream("archivo.dat");
            ObjectInputStream in = new ObjectInputStream(fis);

            dam = (Grupo) in.readObject();
            dam.mostrarAlumnos();
            System.out.println(dam.getNombre());

            in.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
