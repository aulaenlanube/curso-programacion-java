import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppSucursalBancaria {

    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Cuenta> cuentas = new ArrayList<>();
    private static Cuenta cuentaActiva = null;
    private static int contadorCuenta = 1;

    public static void main(String[] args) {

        int opcion = 0;
        while (opcion != 4) {
            menuPrincipal();
            opcion = Integer.parseInt(entrada.nextLine()); 
            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    seleccionarCuenta();
                    break;
                case 4:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción no válida, selecciona una opción entre 1 y 4");
            }
        }
        entrada.close();
    }

    static void crearCliente() {

        System.out.println("Dime el nombre del cliente");
        String nombre = entrada.nextLine();
        System.out.println("Dime los apellidos del cliente");
        String apellidos = entrada.nextLine();
        System.out.println("Dime la dirección del cliente");
        String direccion = entrada.nextLine();
        System.out.println("Dime la ciudad de residencia del cliente");
        String ciudad = entrada.nextLine();
        System.out.println("Dime la fecha de nacimiento del cliente AAAA-MM-DD");
        String fecha = entrada.nextLine();

        clientes.add(new Cliente(nombre, apellidos, direccion, ciudad, LocalDate.parse(fecha)));
    }

    static void crearCuenta() {

        // si no hay clientes, no se puede crear cuenta
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes en la sucursal, primero debes crear uno");
            return;
        }

        String nombre;
        Cliente cliente;
        do {
            System.out.println("Dime el nombre del cliente que quiere abrir una cuenta");
            for (Cliente c : clientes) {
                System.out.println(c.getNombre());
            }
            nombre = entrada.nextLine();
            cliente = validarCliente(nombre);

        } while (cliente == null);

        cuentas.add(new Cuenta(contadorCuenta++, 0, cliente));
    }

    static Cliente validarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    static void seleccionarCuenta() {

        // si no hay cuentas, mostramos mensaje
        if (cuentas.isEmpty()) {
            System.out.println("No hay ninguna cuenta en la sucursal, primero debes crear alguna");
            return;
        }

        // seleccionamos una cuenta
        int numCuenta;
        do {
            System.out.println("Selecciona un número de cuenta");
            for (Cuenta c : cuentas) {
                System.out.println(c.toString());
            }
            numCuenta = Integer.parseInt(entrada.nextLine());  
        } while (!validarCuenta(numCuenta));

        // mostramos el menú de la cuenta
        seleccionarOpcionCuenta();
    }

    static boolean validarCuenta(int numCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() == numCuenta) {
                cuentaActiva = c;
                return true;
            }
        }
        return false;
    }

    static void seleccionarOpcionCuenta() {

        int opcionCuenta = 0;
        while (opcionCuenta != 4) {
            menuCuenta();
            opcionCuenta = Integer.parseInt(entrada.nextLine());  
            switch (opcionCuenta) {
                case 1:
                    ingresar();
                    break;
                case 2:
                    retirar();
                    break;
                case 3:
                    cuentaActiva.verDatos();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    static void ingresar() {
        System.out.println("Indica la cantidad a ingresar");
        int cantidad = Integer.parseInt(entrada.nextLine());        
        cuentaActiva.ingreso(cantidad);
    }

    static void retirar() {
        System.out.println("Indica la cantidad a retirar");
        int cantidad = Integer.parseInt(entrada.nextLine());          
        cuentaActiva.retiro(cantidad);
    }

    static void menuPrincipal() {

        String s = """

                MENU PRINCIPAL
                1 - Crear Cliente
                2 - Crear Cuenta
                3 - Mantenimiento de cuenta
                4 - Salir

                """;
        System.out.println(s);
    }

    static void menuCuenta() {

        String s = """

                MENU PRINCIPAL
                1 - Ingresar
                2 - Retirar
                3 - Ver datos cuenta
                4 - Volver al menú principal

                """;
        System.out.println(s);
    }
}
