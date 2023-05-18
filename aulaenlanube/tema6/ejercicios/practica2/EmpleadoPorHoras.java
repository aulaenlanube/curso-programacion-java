package aulaenlanube.tema6.ejercicios.practica2;

public class EmpleadoPorHoras extends Empleado {
    
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoPorHoras(String nombre, String apellidos, String dni,int horasTrabajadas,
            double tarifaPorHora) {
        super(nombre, apellidos, dni, horasTrabajadas*tarifaPorHora);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salario: " + calcularSalario();
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }
    
}