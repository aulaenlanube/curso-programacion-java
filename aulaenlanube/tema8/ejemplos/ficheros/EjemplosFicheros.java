package aulaenlanube.tema8.ejemplos.ficheros;
import java.io.File;

public class EjemplosFicheros {

    public static void main(String[] args) {

        //fichero
        File fichero = new File("../imgs/default/default.jpg");
        if (fichero.exists())
            System.out.println("El fichero existe");
        else
            System.out.println("El fichero no existe");
        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Longitud: " + fichero.length());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath()+"\n\n");

        //carpeta
        File carpeta = new File("../imgs");
        if (carpeta.exists())
            System.out.println("La carpeta existe");
        else
            System.out.println("La carpeta no existe");
        System.out.println("Nombre: " + carpeta.getName());
        System.out.println("Longitud: " + carpeta.length());
        System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());
    }
}
