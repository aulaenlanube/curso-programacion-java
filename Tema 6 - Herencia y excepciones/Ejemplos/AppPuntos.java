import java.util.InputMismatchException;
import java.util.Scanner;

public class AppPuntos {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        try {            
            Punto p1 = new Punto(-3,-1,"p1");
            System.out.println(p1);
        } catch (PuntoNoValidoException e) {
            System.out.println(e);
        } 


        try {            
            Punto p2 = new Punto(1,-5);
            System.out.println(p2);
        } catch (PuntoNoValidoException e) {
            System.out.println(e);
        } 

    }

    public static Punto nuevoPunto() throws PuntoNoValidoException, InputMismatchException {
        System.out.println("Dime x");
        int x = entrada.nextInt(); // posible excepción de tipo InputMismatchException
        System.out.println("Dime y");
        int y = entrada.nextInt(); // posible excepción de tipo InputMismatchException   
        Punto p = new Punto(x, y);
        System.out.println("Punto(" + x + "," + y + ") creado correctamente");
        return p;
    }
}
