public class Excepciones5 {

    static void dividir(int n, int m) {
        try {
            if (m == 0)
                throw new ArithmeticException(); // lanzamos la excepción
            else
                System.out.println(n + "/" + m + "=" + (n / m));
        } catch (ArithmeticException e) {
            System.out.println("Capturando excepción dentro de un método");
        }
    }

    public static void main(String args[]) {

        dividir(3, 0);
    }

}
