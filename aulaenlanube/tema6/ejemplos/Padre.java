package aulaenlanube.tema6.ejemplos;
public class Padre {

    String nombre;

    public Padre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Padre: " + nombre);
    }
}
