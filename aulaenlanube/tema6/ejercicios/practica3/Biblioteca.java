package aulaenlanube.tema6.ejercicios.practica3;

import java.util.ArrayList;
import java.util.List;
import aulaenlanube.tema4.bordes.Bordes;

public class Biblioteca {

    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String isbn) {
        try {
            for (Libro libro : libros) {
                if (libro.getIsbn().equals(isbn)) {
                    libros.remove(libro);
                    System.out.println("El libro con isbn '" + isbn + "' se ha eliminado de la biblioteca");
                    return;
                }
            }
            throw new LibroNoEncontradoException(isbn);

        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarBiblioteca() {
        for (Libro l : libros) {
            Bordes.mostrarTextoConBordes(l.toString());
            System.out.println();
        }
    }
}
