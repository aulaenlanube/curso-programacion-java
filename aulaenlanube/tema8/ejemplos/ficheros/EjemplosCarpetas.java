package aulaenlanube.tema8.ejemplos.ficheros;
import java.io.File;

public class EjemplosCarpetas {
    public static void main(String[] args) {

        String rutaCarpeta = ".";
        listarArchivos(new File(rutaCarpeta));
    }
    
    // método que lista todos los archivos de un carpeta y sus subcarpetas, con su ruta desde la ubicación actual. No deben aparecer las carpetas
    public static void listarArchivos(File carpeta) {
        
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
    
            for (File archivo : archivos) {
                if (archivo.isFile()) System.out.println(archivo.getPath());
                else if (archivo.isDirectory()) {
                    System.out.println(archivo.getPath());
                    listarArchivos(archivo);  
                }          
            }
        } 
    }  
}
