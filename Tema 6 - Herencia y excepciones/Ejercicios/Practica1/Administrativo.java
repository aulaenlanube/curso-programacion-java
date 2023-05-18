package practica1;
public class Administrativo extends Gestion {
    public Administrativo(String dni, String nombre, double salarioBase, int antiguedad) {
        super(dni, nombre, salarioBase, antiguedad);
    }

    @Override
    public double calcularSalarioFinal() {
        return salarioBase + (antiguedad * 20);
    }
    @Override
    public String toString() {
        return "Administrativo: {dni="+dni+", nombre="+nombre+", salarioB="+salarioBase+", salarioF="+calcularSalarioFinal()+"}";
    }
}