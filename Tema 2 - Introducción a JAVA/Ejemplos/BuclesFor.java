import java.util.Scanner;

public class BuclesFor {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        double media = 0;
        int cantidadNumeros = 4;
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.println("Dime un número: "+(i+1)+" de "+cantidadNumeros);
            int num = entrada.nextInt();
            media+=num;
        }
        System.out.println("La media es: "+(media/cantidadNumeros));
        entrada.close();
    }

}
