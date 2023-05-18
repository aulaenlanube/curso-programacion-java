package aulaenlanube.tema6.ejemplos;
import java.io.FileReader;

public class Excepciones1 {

    public static void main(String[] args) {

        // excepciones no verificadas
        try {
            int num1 = 2 / 0;
            int[] arr = new int[3];
            int num2 = arr[5]; // Se producirá una ArrayIndexOutOfBoundsException
            System.out.println(num1 + num2);

        } catch (Exception e) {
            System.out.println("Se ha producido un error en las excepciones no verificadas");
        }

        // excepciones verificadas
        try {
            FileReader file = new FileReader("archivo.txt");
            file.close();
        } catch (Exception e) {
            System.out.println("He capturado la excepción");
        }
    }
}