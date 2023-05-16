public abstract class Gestion extends Trabajador {
    protected int antiguedad;

    public Gestion(String dni, String nombre, double salarioBase, int antiguedad) {
        super(dni, nombre, salarioBase);
        this.antiguedad = antiguedad;
    }
}