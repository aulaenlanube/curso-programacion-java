import java.io.File;

public class EjemplosCarpetas {
public static void main(String[] args) {

    String rutaCarpeta = "";
    listarArchivos(rutaCarpeta);
}

public static void listarArchivos(String rutaCarpeta) {
    File carpeta = new File(rutaCarpeta);

    if (carpeta.isDirectory()) {
        File[] archivos = carpeta.listFiles();

        for (File archivo : archivos) {
            if (archivo.isFile()) {
                System.out.println(archivo.getName() + " - " + archivo.length() + "bytes");
            }
        }
    } else
        System.err.println("La ruta proporcionada no es una carpeta.");

}

}
