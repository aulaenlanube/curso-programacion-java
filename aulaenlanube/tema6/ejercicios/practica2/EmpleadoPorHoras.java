package aulaenlanube.tema6.ejercicios.practica2;
public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoPorHoras(String nombre, String apellidos, String dni, double salario, int horasTrabajadas, double tarifaPorHora) {
        super(nombre, apellidos, dni, salario);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public String toString() {
        return super.toString()+", Salario: "+calcularSalario();
    }
}