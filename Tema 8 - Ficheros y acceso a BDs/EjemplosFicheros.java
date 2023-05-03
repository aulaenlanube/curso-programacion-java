import java.io.File;

public class EjemplosFicheros {

    public static void main(String[] args) {

        File fichero = new File("ejemplo1.txt");
        File carpeta = new File("../imgs"); // imgs/agenda → agenda dentro de imgs
        File carpetaActual = new File("."); // carpeta actual
        File carpetaPadre = new File(".."); // carpeta superior

        mostrarDatos(fichero);
        mostrarDatos(carpeta);
        mostrarDatos(carpetaActual);
        mostrarDatos(carpetaPadre);
    }

    public static void mostrarDatos(File fichero) {
        
        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Padre: " + fichero.getParent());
        System.out.println("Longitud: " + fichero.length());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        System.out.println("\n");

    }

}
