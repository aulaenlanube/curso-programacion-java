package aulaenlanube.tema6.ejercicios.practica3;

import java.time.LocalDate;

public class Practica3Main {

        public static void main(String[] args) {

                Autor autor1 = new Autor("Edu", "Torregrosa", LocalDate.of(1981, 9, 1),
                                GeneroLiterario.DIDACTICO);

                Libro libro1 = new Libro("Programación en JAVA", autor1, "aulaenlanube", LocalDate.of(2023, 1, 1),
                                "111-22-333-4444-1", 0.0);

                Libro libro2 = new Libro("Programación en C#", autor1, "aulaenlanube", LocalDate.of(2024, 1, 1),
                                "111-22-333-4444-2", 0.0);

                // creamos biblioteca
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.agregarLibro(libro1);
                biblioteca.agregarLibro(libro2);
                biblioteca.mostrarBiblioteca();

                // eliminamos libros
                biblioteca.eliminarLibro("Programación en JAVA");
                biblioteca.eliminarLibro("Programación en JAVA"); // Lanza una excepción porque el libro ya no existe
                System.out.println();
                biblioteca.mostrarBiblioteca();
        }
}
