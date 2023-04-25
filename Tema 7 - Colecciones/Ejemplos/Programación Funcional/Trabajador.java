public class Trabajador {

    private static int cantidadTrabajadores = 0;

    private String nombre;
    private int edad;
    private double salario;

    public Trabajador(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        cantidadTrabajadores++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public static void getTrabajadores() {
        System.out.println("Se han creado " + cantidadTrabajadores + " trabajadores");
    }

}
