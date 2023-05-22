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

    public void eliminarLibro(String titulo) {
        try {
            for (Libro libro : libros) {
                if (libro.getTitulo().equals(titulo)) {
                    libros.remove(libro);
                    System.out.println("El libro '"+titulo+"' se ha eliminado de la biblioteca");
                    return;
                }
            }
            throw new LibroNoEncontradoException(titulo);

        } catch (LibroNoEncontradoException e) {
            System.out.println(e);
        }
    }

    public void mostrarBiblioteca() {
        for (Libro l : libros) {
            Bordes.mostrarTextoConBordes(l.toString());
            System.out.println();            
        }
    }
}

