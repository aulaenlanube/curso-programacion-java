package aulaenlanube.tema6.ejercicios.practica3;

import java.time.LocalDate;

public class Autor extends Persona {

    
    private GeneroLiterario generoLiterario;

    public Autor(String nombre, String apellido, LocalDate fechaNacimiento, GeneroLiterario generoLiterario) {
        super(nombre, apellido, fechaNacimiento);
        this.generoLiterario = generoLiterario;
    }

    public String getGeneroLiterario() {
        return generoLiterario.getNombre();
    }

    public void setGeneroLiterario(GeneroLiterario generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    @Override
    public String toString() {
        return "Autor [generoLiterario=" + generoLiterario.getNombre() + ", " + super.toString() + "]";
    }
}

