package practica1;
public class Auxiliar extends Gestion {
    public Auxiliar(String dni, String nombre, double salarioBase, int antiguedad) {
        super(dni, nombre, salarioBase, antiguedad);
    }

    @Override
    public double calcularSalarioFinal() {
        return salarioBase + 100;
    }

    @Override
    public String toString() {
        return "Auxiliar: {dni="+dni+", nombre="+nombre+", salarioB="+salarioBase+", salarioF="+calcularSalarioFinal()+"}";
    }
}