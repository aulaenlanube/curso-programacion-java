public class Hija extends Padre {

    String nombre;
    int edad;

    public Hija(int edad, String padre, String hija) {
        super(padre);
        this.nombre = hija;
        this.edad = edad;
    }

    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Hija: " + this.nombre + " tiene " + edad + " años");
        
    }

}
