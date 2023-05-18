package aulaenlanube.tema6.ejemplos;
public class Profesor extends Persona{

    private String departamento;

    public Profesor(String nombre, int edad, String departamento) {
        super(nombre, edad);
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + " Profesor [departamento=" + departamento + "]";
    }

    
    
}
