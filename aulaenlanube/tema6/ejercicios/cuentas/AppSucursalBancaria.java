package aulaenlanube.tema6.ejercicios.cuentas;

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
            try {
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

            } catch (Exception e) {
                System.out.println("Opción no válida, selecciona una opción entre 1 y 4");
            }
        }
        entrada.close();
    }

    static void crearCliente() {

        System.out.println("Dime el nombre del cliente");
        String nombre = validarNombre();
        System.out.println("Dime los apellidos del cliente");
        String apellidos = validarString();
        System.out.println("Dime la dirección del cliente");
        String direccion = entrada.nextLine();
        System.out.println("Dime la ciudad de residencia del cliente");
        String ciudad = entrada.nextLine();
        System.out.println("Dime la fecha de nacimiento del cliente AAAA-MM-DD");
        LocalDate fecha = validarFechaNacimiento();

        clientes.add(new Cliente(nombre, apellidos, direccion, ciudad, fecha));
        System.out.println("El cliente de nombre " + nombre + " " + apellidos + " se ha creado correctamente");
    }

    static LocalDate validarFechaNacimiento() {
        while (true) {
            try {
                return LocalDate.parse(entrada.nextLine());
            } catch (Exception e) {
                System.out.println(
                        "El formato de la fecha no es válido: Introduce una nueva fecha con formato AAAA-MM-DD");
            }
        }
    }

    static String validarString() {
        while (true) {
            String s = entrada.nextLine();
            if (s.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\s]+"))
                return s;
            System.out.println("ERROR: únicamente puedes introducir letras y espacios en blanco");
        }
    }

    static String validarNombre() {
        while (true) {
            try {
                String s = validarString();
                for (Cliente c : clientes) {
                    if (c.getNombre().equals(s))
                        throw new ClienteExisteException(c);
                }
                return s;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static void crearCuenta() {

        // si no hay clientes, no se puede crear cuenta
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes en la sucursal, primero debes crear uno");
            return;
        }

        // obtener cliente
        Cliente cliente = validarCliente();

        // obtenemos la cuenta
        Cuenta cuenta = validarCuenta(cliente);

        // añadimos la cuenta
        cuentas.add(cuenta);
        System.out.println("La cuenta a nombre de " + cliente.nombreCompleto() + " se ha creado correctamente");
    }

    static Cuenta validarCuenta(Cliente c) {
        int opcion;
        while (true) {
            try {
                menuTipoCuenta();
                opcion = Integer.parseInt(entrada.nextLine());
                switch (opcion) {
                    case 1:
                        return new CuentaCorriente(contadorCuenta++, c);
                    case 2:
                        return new CuentaVivienda(contadorCuenta++, c);
                    case 3:
                        return new FondoInversion(contadorCuenta++, c);
                }
            } catch (Exception e) {
                System.out.println("Tipo de cuenta no válida, selecciona una opción entre 1 y 3");
            }
        }
    }

    static Cliente validarCliente() {
        String nombre;
        while (true) {
            System.out.println("Dime el nombre del cliente que quiere abrir una cuenta");
            for (Cliente c : clientes) {
                System.out.println(c.getNombre());
            }
            nombre = entrada.nextLine();
            for (Cliente c : clientes) {
                if (c.getNombre().equals(nombre)) {
                    return c;
                }
            }
        }
    }

    static void seleccionarCuenta() {

        // si no hay cuentas, mostramos mensaje
        if (cuentas.isEmpty()) {
            System.out.println("No hay ninguna cuenta en la sucursal, primero debes crear alguna");
            return;
        }

        // seleccionamos una cuenta
        int numCuenta = 0;
        do {
            try {
                System.out.println("Selecciona un número de cuenta");
                for (Cuenta c : cuentas) {
                    System.out.println(c.toString());
                }
                numCuenta = Integer.parseInt(entrada.nextLine());
            } catch (Exception e) {
                System.out.println("Debes seleccionar un número de cuenta válido, entre 1 y " + (contadorCuenta - 1));
            }

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
            try {
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
            } catch (Exception e) {
                System.out.println("Opción no válida, selecciona una opción entre 1 y 4");
            }
        }
    }

    static void ingresar() {
        try {
            System.out.println("Indica la cantidad a ingresar");
            double cantidad = Double.parseDouble(entrada.nextLine());
            cuentaActiva.ingreso(cantidad);
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir una cantidad numérica válida");
        } catch (IngresoNoValidoException e) {
            System.out.println(e);
        }
    }

    static void retirar() {
        try {
            System.out.println("Indica la cantidad a retirar");
            double cantidad = Double.parseDouble(entrada.nextLine());
            cuentaActiva.retiro(cantidad);
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir una cantidad numérica válida");
        } catch (RetiroNoValidoException e) {
            System.out.println(e);
        }
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

                MENU CUENTA
                1 - Ingresar
                2 - Retirar
                3 - Ver datos cuenta
                4 - Volver al menú principal

                """;
        System.out.println(s);
    }

    static void menuTipoCuenta() {

        String s = """

                QUÉ TIPO DE CUENTA QUIERES CREAR?
                1 - Cuenta Corriente
                2 - Cuenta Vivienda
                3 - Fondo Inversión

                """;
        System.out.println(s);
    }
}
