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

    public void subirSalario(double d) {
        setSalario(salario+salario*d/100);
    }

    public void mostrarDatos() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Permanencia: "+permanencia);
        System.out.println("Salario: "+salario);
    }

    public void mostrarClasificacion() {

        if (permanencia >= 18)
            System.out.println("El empleado "+nombre+" es Senior");
        else if (permanencia > 3)
            System.out.println("El empleado "+nombre+" es Intermedio");
        else
            System.out.println("El empleado "+nombre+" es Principiante");

    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the permanencia
     */
    public int getPermanencia() {
        return permanencia;
    }

    /**
     * @param permanencia the permanencia to set
     */
    public void setPermanencia(int permanencia) {
        if (permanencia < 0)
            this.permanencia = 0;
        this.permanencia = permanencia;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        if (salario < 0)
            this.salario = 0;
        else
            this.salario = salario;
    }

}
