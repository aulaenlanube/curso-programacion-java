public class SumarNumeros {

    public static void main(String[] args) {

        mostrarSumaDecreciente(8);
        mostrarSumaCreciente(8);

    }

    static void mostrarSumaDecreciente(int n) {
        sumaDecreciente(n, 0);
    }

    static void sumaDecreciente(int n, int total) {
        if (n == 1)
            System.out.println(1 + "=" + (total + 1));
        else {
            System.out.print(n + "+");
            total += n;
            sumaDecreciente(n - 1, total);
        }
    }

    static void mostrarSumaCreciente(int n) {
        sumaCreciente(1, n, 0);
    }

    static void sumaCreciente(int contador, int n, int total) {

        if (contador <= n) {
            System.out.print(contador + "+");
            total += contador;
            sumaCreciente(++contador, n, total);
        } else {
            System.out.println("\b=" + total);
        }
    }

}
