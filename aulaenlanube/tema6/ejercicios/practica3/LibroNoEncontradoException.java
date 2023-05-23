package aulaenlanube.tema6.ejercicios.practica3;

public class LibroNoEncontradoException extends Exception {

    public LibroNoEncontradoException(String s) {
        super("El libro con isbn '" + s + "' no se ha encontrado en la biblioteca");
    }

}
