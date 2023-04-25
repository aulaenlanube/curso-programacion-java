public class EjemploMetodosReferenciados {

    public static void main(String[] args) {

        final int NUM_1 = 3;
        final int NUM_2 = 5;

        Calculadora suma = EjemploMetodosReferenciados::suma;
        Calculadora resta = EjemploMetodosReferenciados::resta;
        Calculadora multiplicacion = EjemploMetodosReferenciados::multiplicacion;
        Calculadora division = EjemploMetodosReferenciados::division;
        Calculadora cuadradoSuma = EjemploMetodosReferenciados::cuadradoSuma;
        Calculadora calculoComplejo = EjemploMetodosReferenciados::calculoComplejo;

        System.out.println("A + B = " + suma.operacion(NUM_1, NUM_2));
        System.out.println("A - B = " + resta.operacion(NUM_1, NUM_2));
        System.out.println("A * B = " + multiplicacion.operacion(NUM_1, NUM_2));
        System.out.println("A / B = " + division.operacion(NUM_1, NUM_2));
        System.out.println("A^2 + B^2 + 2*A*B = " + cuadradoSuma.operacion(NUM_1, NUM_2));
        System.out.println("Cálculo = " + calculoComplejo.operacion(NUM_1, NUM_2));
    }

    static int suma(int a, int b) {
        return a + b;
    }

    static int resta(int a, int b) {
        return a - b;
    }

    static int multiplicacion(int a, int b) {
        return a * b;
    }

    static int division(int a, int b) {
        return a / b;
    }

    static int cuadradoSuma(int a, int b) {
        return (int) Math.pow(a + b, 2);
    }

    static int calculoComplejo(int a, int b) {
        a += b;
        b += a;
        return a * b;
    }
}
