package aulaenlanube.tema8.ejercicios;
import java.io.File;

public class Ejercicio1FicherosTexto {

    public static void main(String[] args) {

        String ruta = ".";
        String extension = "txt";

        // Llamar al método con una extensión personalizada
        listarPorExtension(ruta, extension);
    }

    // Crea un método que reciba una carpeta y liste el contenido de dicha carpeta
    // de aquellos archivos cuya extensión sea .txt. Crea una sobrecarga para que 
    // el método reciba el tipo de archivo a listar
    public static void listarPorExtension(String ruta, String extension) {

        File carpeta = new File(ruta);

        if (carpeta.isDirectory()) {
            File[] archivos = carpeta
                    .listFiles((dir, name) -> name.toLowerCase().endsWith("." + extension.toLowerCase()));

            if (archivos != null) {
                for (File f : archivos) {
                    System.out.println("Archivo encontrado: " + f.getName());
                }
            } else {
                System.out
                        .println("No se encontraron archivos con la extensión " + extension + " en la carpeta " + ruta);
            }
        } else {
            System.out.println("La ruta proporcionada no es una carpeta válida");
        }
    }
}
