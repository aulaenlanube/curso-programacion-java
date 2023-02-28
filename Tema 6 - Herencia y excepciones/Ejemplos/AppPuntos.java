import java.util.InputMismatchException;
import java.util.Scanner;

public class AppPuntos {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        try {            
            System.out.println(nuevoPunto());
        } catch (PuntoNoValidoException e) {
            System.out.println("Error: " + e);
        } catch (InputMismatchException e) {
            System.out.println("Valor numérico no válido");
        }
    }

    public static Punto nuevoPunto() throws PuntoNoValidoException, InputMismatchException {
        System.out.println("Dime x");
        int x = entrada.nextInt(); // posible excepción de tipo InputMismatchException
        System.out.println("Dime y");
        int y = entrada.nextInt(); // posible excepción de tipo InputMismatchException
        Punto p = new Punto(x, y);

        if (x < 0 || y < 0) // posible excepción de tipo PuntoNoValidoException
            throw new PuntoNoValidoException(p);
        System.out.println("Punto(" + x + "," + y + ") creado correctamente");
        return p;
    }
}
