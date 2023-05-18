package aulaenlanube.tema6.ejercicios.practica1;
public abstract class Trabajador {
    protected String dni;
    protected String nombre;
    protected double salarioBase;

    public Trabajador(String dni, String nombre, double salarioBase) {
        this.dni = dni;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalarioFinal();
}
