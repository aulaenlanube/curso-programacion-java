class Metodos {

    public static void main(String[] args) {

        int num1 = 2, num2 = 4;
        int num3 = suma(num1, num2);
        System.out.println(areaCuadrado(num3));
        prueba();
    }

    static void prueba()
    {
        int x = 1;
        System.out.println("Prueba");
        if(x == 1) return;
        System.out.println("Prueba final");
        return;
    }

    static int suma(int a, int b) {
        int resultado = a + b;
        return resultado;
    }

    static double areaCuadrado(double lado) {

        return lado*lado;
    }
}