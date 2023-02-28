import java.util.Scanner;

/**
 * 
 * Crea un método que obtenga la suma de los números naturales desde 1 hasta N.
 * Se debe pasar como parámetro el número N, debe ser mayor que cero. Se debe
 * imprimir toda la cadena por consola. Por ejemplo, para N=4 → ( 1+2+3+4 = 10).
 * 
 * @author Javier Sánchez Ibáñez
 */

public class SumarNumeros2 {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce n: ");

        try {
            n = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Número incorrecto");
            sc.close();
        }

        System.out.println("\b=" + suma(n));
        sc.close();
    }

    public static int suma(int n) {
        if (n > 0) {
            if (n == 1) {
                System.out.print("1+");
                return 1;
            } else {
                int aux = suma(n - 1);
                System.out.print(n + "+");
                return n + aux;
            }
        }
        return 0;
    }
}
