public class Programador extends Informatico {
    public Programador(String dni, String nombre, double salarioBase, String titulacion) {
        super(dni, nombre, salarioBase, titulacion);
    }

    @Override
    public double calcularSalarioFinal() {
        return salarioBase + (salarioBase * 0.15);
    }

    @Override
    public String toString() {
        return "Programador: {dni="+dni+", nombre="+nombre+", salarioB="+salarioBase+", salarioF="+calcularSalarioFinal()+"}";
    }
}