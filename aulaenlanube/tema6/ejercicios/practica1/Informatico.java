package aulaenlanube.tema6.ejercicios.practica1;
public abstract class Informatico extends Trabajador {
    
    protected String titulacion;

    public Informatico(String dni, String nombre, double salarioBase, String titulacion) {
        super(dni, nombre, salarioBase);
        this.titulacion = titulacion;
    }

}
