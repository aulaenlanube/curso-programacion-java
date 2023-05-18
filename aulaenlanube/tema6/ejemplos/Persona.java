package aulaenlanube.tema6.ejemplos;
public class Persona {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void mostrarDatos() {
        System.out.println("Nombre: "+nombre);
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }

}
