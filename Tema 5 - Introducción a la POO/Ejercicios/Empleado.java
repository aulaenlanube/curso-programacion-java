public class Empleado {

    private String nombre;
    private int permanencia;
    private double salario;

    public Empleado(String nombre, int permanencia, double salario) {
        this.nombre = nombre;
        setPermanencia(permanencia);
        setSalario(salario);
    }

    public Empleado() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(int permanencia) {
        if (permanencia < 0)
            this.permanencia = 0;
        else
            this.permanencia = permanencia;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0)
            this.salario = 0;
        else
            this.salario = salario;
    }

    public void subirSalario(double d) {
        setSalario(salario + salario * d / 100);
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Permanencia: " + permanencia);
        System.out.println("Salario: " + salario);
    }

    public void mostrarClasificacion() {

        if (permanencia >= 18)
            System.out.println("El empleado " + nombre + " es Senior");
        else if (permanencia > 3)
            System.out.println("El empleado " + nombre + " es Intermedio");
        else
            System.out.println("El empleado " + nombre + " es Principiante");
    }
}
