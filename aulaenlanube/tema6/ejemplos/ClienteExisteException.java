package aulaenlanube.tema6.ejemplos;

import aulaenlanube.tema5.ejercicios.Cliente;

public class ClienteExisteException extends Exception {

    private Cliente cliente;

    public ClienteExisteException(Cliente cliente) { // constructor utilizado en throw
        this.cliente = cliente;
    }

    public String toString() {
        return "El cliente de nombre " + this.cliente.getNombre() + " ya existe";
    }

    public void mostrarDatos() {
        System.out.println("ERROR: " + toString());
    }

}
