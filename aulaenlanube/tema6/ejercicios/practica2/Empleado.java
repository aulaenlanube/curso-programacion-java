package aulaenlanube.tema6.ejercicios.practica2;
public abstract class Empleado {
    protected String nombre;
    protected String apellidos;
    protected String dni;
    protected double salario;

    public Empleado(String nombre, String apellidos, String dni, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.salario = salario;
    }

    //método abstracto
    public abstract double calcularSalario();

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }    
       
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellidos: " + apellidos + ", DNI: " + dni;
    }


}
