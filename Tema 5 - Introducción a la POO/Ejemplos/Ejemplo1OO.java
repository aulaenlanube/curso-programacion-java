public class Ejemplo1OO {

    public static void main(String[] args) {

        Persona p1 = new Persona("Pepe",40,"20202020A");
        Persona p2 = new Persona("Marta",25, "30303030B");

        CuentaBancaria cuenta1 = new CuentaBancaria(1,p1);
        CuentaBancaria cuenta2 = new CuentaBancaria(2,p2);

        cuenta1.ingresar(100);
        cuenta2.ingresar(200);

        cuenta1.mostrarDatos();
        cuenta2.mostrarDatos();

    }

}
