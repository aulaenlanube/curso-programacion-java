package aulaenlanube.tema7.ejemplos;
public class Direccion implements PersonaCentroEducativo {

    @Override
    public String toString() {
        return "Direccion [nombre=" + nombre + ", cargo=" + cargo + "]";
    }

    private String nombre;
    private String cargo;

    public Direccion(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
