package aulaenlanube.tema7.ejemplos.programacionFuncional;
import java.util.Random;

public class Trabajador {

    private static int cantidadTrabajadores = 0;

    private String nombre;
    private int edad;
    private double salario;

    public Trabajador(int edad) {
        this.edad = edad;
    }

    public Trabajador(String nombre) {
        this.nombre = nombre;
        Random r = new Random();
        this.edad = r.nextInt(48)+18;
    }

    public Trabajador() {
    }

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

    @Override
    public String toString() {
        return "Trabajador [nombre=" + nombre + ", edad=" + edad + "]";
    }


}
