import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones7 {

    static Scanner entrada = new Scanner(System.in);

    public static int obtenerDatos(int[] v) throws ArrayIndexOutOfBoundsException, InputMismatchException {
        System.out.println("Dime una posición entre 0 y " + (v.length - 1));
        int n = entrada.nextInt(); // posible excepción de tipo InputMismatchException
        if (n < 0 || n >= v.length) // posible excepción de tipo ArrayIndexOutOfBoundsException
            throw new ArrayIndexOutOfBoundsException("ERROR: índice no válido");
        return n;
    }

    public static void main(String args[]) {
        boolean salir = false;
        int pos;
        int[] array = { 15, 2, 8, 19, 8 };
        do {
            try {
                pos = obtenerDatos(array);
                System.out.println("array[" + pos + "] = " + array[pos]);
                salir = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("ERROR: número no válido");
                entrada.next();
            } catch (Exception e) {
                System.out.println("ERROR desconocido");
            }
        } while (!salir);
        entrada.close();
    }
}
