class Metodos {

    public static void main(String[] args) {

        int num1 = 2, num2 = 4;
        int num3 = suma(num1, num2);
        System.out.println(areaCuadrado(num3));
    }

    static int suma(int a, int b) {
        int resultado = a + b;
        return resultado;
    }

    static double areaCuadrado(double lado) {

        return lado*lado;
    }
}