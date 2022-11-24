public class Fibonacci {

    public static void main(String[] args) {

        int f = fibonacci(40);
        System.out.println(f);

    }

    // obtener el número de fibonacci de n
    static int fibonacci(int n) {
        if (n <= 1)
            return n; // caso base
        else
            return fibonacci(n - 1) + fibonacci(n - 2); // caso general
    }

}
