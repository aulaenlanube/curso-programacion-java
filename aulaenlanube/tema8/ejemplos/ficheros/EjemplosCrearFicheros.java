package aulaenlanube.tema8.ejemplos.ficheros;
import java.io.File;
import java.io.IOException;

public class EjemplosCrearFicheros {

    public static void main(String[] args) {

        // crear archivo
        File archivo = new File("nuevoArchivo.txt");
        try {
            if (archivo.createNewFile())
                System.out.println("Archivo creado");
            else
                System.out.println("El archivo ya existe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // crear carpeta
        File directorio = new File("nuevoDirectorio");
        if (directorio.mkdir())
            System.out.println("Directorio creado");
        else
            System.out.println("No se pudo crear el directorio");

        // borrar archivo
        File archivoBorrar = new File("ejemplo.txt");
        if (archivoBorrar.delete())
            System.out.println("Archivo eliminado");
        else
            System.out.println("No se pudo eliminar el archivo");

        // listar carpeta
        File directorio2 = new File(".");
        String[] archivos = directorio2.list();
        System.out.println("\nLista de archivos:");
        if (archivos != null)
            for (String a : archivos)
                System.out.println(a);
        else
            System.out.println("No se pudo listar los archivos");
    }
}
