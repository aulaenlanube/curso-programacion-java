import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones6 {

    public static void ejemplo(int x, int[] v) throws ArrayIndexOutOfBoundsException {
        if (x < 0 || x >= v.length) {
            throw new ArrayIndexOutOfBoundsException("Posición no válida");
        }
        System.out.println(v[x]);
    }

    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        int pos;
        int[] elArray = { 1, 2, 3 };
        do {
            try {
                System.out.println("Dime una posición para saber su valor: 0-2");
                pos = entrada.nextInt();                
                ejemplo(pos, elArray);
                salir = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("ERROR: el número introducido no es válido");
                entrada.next();
            }
        } while (!salir);
        entrada.close();
    }

}
