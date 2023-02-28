import java.util.ArrayList;

public class AppClientes {

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Pep"));
        clientes.add(new Cliente("Tom"));
        clientes.add(new Cliente("Kal"));

        nuevoCliente("Tom", clientes);
        nuevoCliente("Eddie", clientes);
        System.out.println(clientes);
    }

    public static void nuevoCliente(String nombre, ArrayList<Cliente> clientes) {
        try {
            for (Cliente c : clientes) {
                if (c.getNombre().equals(nombre))
                    throw new ClienteExisteException(c);
            }
            clientes.add(new Cliente(nombre));
            System.out.println("Cliente dado de alta correctamente");

        } catch (ClienteExisteException e) {
            e.mostrarDatos();
        }
    }
}
