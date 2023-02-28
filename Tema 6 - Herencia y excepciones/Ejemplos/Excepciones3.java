import java.util.InputMismatchException;

public class Excepciones3 {

    public static void main(String[] args) {

        try {
            int a = 1 / 0;
            System.out.println(a);
        } catch (InputMismatchException e) {
            System.out.println("No se puede dividir un número entre cero");
        }
        finally {
            System.out.println("Fin del programa");
        }
        System.out.println("Mensaje final");
    }
}
