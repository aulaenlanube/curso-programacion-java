package aulaenlanube.tema9.ejemplos;

import javax.swing.JOptionPane;

public class EjemplosJOptionPane {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Mensaje de información", "Info", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Mensaje de error", "Error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Mensaje de advertencia", "Advertencia", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "¿Estás seguro?", "Pregunta", JOptionPane.QUESTION_MESSAGE);

        // solicitar entrada de datos
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
        System.out.println("Hola " + nombre + "!");

        // usar un conjunto de opciones para que el usuario elija:
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?");
        if (respuesta == JOptionPane.YES_OPTION)
            System.out.println("Has elegido " + ANSI_GREEN + "SI" + ANSI_RESET);
        else if (respuesta == JOptionPane.NO_OPTION)
            System.out.println("Has elegido " + ANSI_RED + "NO" + ANSI_RESET);
        else
            System.out.println(ANSI_PURPLE + "No has elegido ninguna opción" + ANSI_RESET);

        // usar un conjunto de opciones para que el usuario elija:
        Object[] opciones = { "Blanco", "Rojo", "Verde", "Amarillo", "Azul", "Morado", "Cyan", "Negro" };
        int seleccion = JOptionPane.showOptionDialog(null, "Elige un color", "Colores", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case 0 -> System.out.println("Has elegido: " + ANSI_WHITE + opciones[seleccion] + ANSI_RESET);
            case 1 -> System.out.println("Has elegido: " + ANSI_RED + opciones[seleccion] + ANSI_RESET);
            case 2 -> System.out.println("Has elegido: " + ANSI_GREEN + opciones[seleccion] + ANSI_RESET);
            case 3 -> System.out.println("Has elegido: " + ANSI_YELLOW + opciones[seleccion] + ANSI_RESET);
            case 4 -> System.out.println("Has elegido: " + ANSI_BLUE + opciones[seleccion] + ANSI_RESET);
            case 5 -> System.out.println("Has elegido: " + ANSI_PURPLE + opciones[seleccion] + ANSI_RESET);
            case 6 -> System.out.println("Has elegido: " + ANSI_CYAN + opciones[seleccion] + ANSI_RESET);
            case 7 -> System.out.println("Has elegido: " + ANSI_BLACK + opciones[seleccion] + ANSI_RESET);
            default -> System.out.println("No has seleccionado ningún color");
        }
    }
}
