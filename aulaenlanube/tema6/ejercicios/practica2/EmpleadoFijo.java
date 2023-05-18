package aulaenlanube.tema6.ejercicios.practica2;

public class EmpleadoFijo extends Empleado {


    public EmpleadoFijo(String nombre, String apellidos, String dni, double salario) {
        super(nombre, apellidos, dni, salario);        
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salario: " + calcularSalario();
    }
}
