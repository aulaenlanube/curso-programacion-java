package aulaenlanube.tema5.ejemplos;

public class CuentaBancaria {

    int id;
    double saldo;
    Persona propietario;
    String tipo;

    public CuentaBancaria(int num, Persona p) {
        id = num;
        propietario = p;
        saldo = 0;
        tipo = "Corriente";
    }

    public void verSaldo() {
        System.out.println("El saldo de la cuenta " + id + " es: " + saldo + "€");
    }

    public void ingresar(double n) {
        saldo += n;
    }

    public void retirar(double n) {
        if (saldo >= n)
            saldo -= n;
        else
            System.out.println("ERROR: No hay suficiente saldo");
    }

    public void mostrarDatos() {
        propietario.mostrarDatosConBordes();
        verSaldo();
        System.out.println("--------------------------------");
    }

}
