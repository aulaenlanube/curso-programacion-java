package aulaenlanube.tema6.ejercicios.practica3;

public class LibroNoEncontradoException extends Exception {

    public LibroNoEncontradoException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "El libro '" + getMessage() + "'' no se ha encontrado en la biblioteca";
    }

}
