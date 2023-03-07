public class ClienteExisteException extends Exception{

    private Cliente cliente;

    public ClienteExisteException(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "El cliente de nombre " + cliente.getNombre() + " ya existe";
    }
    
}
