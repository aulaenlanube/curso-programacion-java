package aulaenlanube.tema3.ejemplos;
public class BusquedaBinaria {

    public static void main(String[] args) {

        int[] numeros = { 1, 5, 20, 45, 120, 245, 512, 1004, 2005 };
        int numeroBuscado = 5122;
        mostrarBusquedaBinaria(numeros, numeroBuscado);
    }

    static void mostrarBusquedaBinaria(int[] numeros, int numeroBuscado) {

        if (busquedaBinaria(numeros, numeroBuscado, 0, numeros.length - 1))
            System.out.println("El número " + numeroBuscado + " está en el Array.");
        else
            System.out.println("El número " + numeroBuscado + " NO está en el Array.");
    }

    static boolean busquedaBinaria(int[] numeros, int numeroBuscado, int limiteInferior, int limiteSuperior) {

        if (limiteInferior > limiteSuperior)
            return false;
        int mitad = (limiteInferior + limiteSuperior) / 2;
        if (numeros[mitad] < numeroBuscado)
            return busquedaBinaria(numeros, numeroBuscado, mitad + 1, limiteSuperior);
        else if (numeros[mitad] > numeroBuscado)
            return busquedaBinaria(numeros, numeroBuscado, limiteInferior, mitad - 1);
        else
            return true;
    }
}
