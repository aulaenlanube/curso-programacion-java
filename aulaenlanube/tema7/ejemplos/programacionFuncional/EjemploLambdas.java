package aulaenlanube.tema7.ejemplos.programacionFuncional;
import java.time.LocalTime;

public class EjemploLambdas {

    public static void main(String[] args) {

        final int NUM_1 = 8;
        final int NUM_2 = 2;

        Calculadora suma = (a, b) -> a + b;
        Calculadora resta = (a, b) -> a - b;
        Calculadora multiplicacion = (a, b) -> a * b;
        Calculadora division = (a, b) -> a / b;
        Calculadora cuadradoSuma = (a, b) -> (int) Math.pow(a + b, 2.0);
        Calculadora calculoComplejo = (a, b) -> {
            a += b;
            b += a;
            return a * b;
        };

        

        System.out.println("A + B = " + suma.operacion(NUM_1, NUM_2));
        System.out.println("A - B = " + resta.operacion(NUM_1, NUM_2));
        System.out.println("A X B = " + multiplicacion.operacion(NUM_1, NUM_2));
        System.out.println("A / B = " + division.operacion(NUM_1, NUM_2));
        System.out.println("A^2 + B^2 + 2*A*B = " + cuadradoSuma.operacion(NUM_1, NUM_2));
        System.out.println("Cálculo = " + calculoComplejo.operacion(NUM_1, NUM_2));

        Saludador saludoSimple = () -> System.out.println("Hola mundo!!");
        Saludador saludoHora = () -> System.out.println("Hola, son las "+LocalTime.now().getHour() + " horas y "+LocalTime.now().getMinute() + " minutos");

        saludoSimple.saludar();
        saludoHora.saludar();
    }
}
