import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones4 {
    public static void main(String args[]) {

        Scanner entrada = new Scanner(System.in);
        int minutos;
        System.out.println("Indica los minutos");
        try {
            minutos = entrada.nextInt();
            entrada.close();
            if (minutos < 0 || minutos >= 60) {
                throw new InputMismatchException("Valor fuera de rango, de 0 a 60");
            }
            System.out.println("El número introducido es válido");
        } catch (Exception e) {
            System.out.println("ERROR: El número introducido NO es válido");
        }
    }
}
