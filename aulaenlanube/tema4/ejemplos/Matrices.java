package aulaenlanube.tema4.ejemplos;

import aulaenlanube.tema4.bordes.Bordes;
import aulaenlanube.tema4.generadores.*;
import aulaenlanube.tema4.ejercicios.*;

public class Matrices {

    public static void main(String[] args) {

        // declaración y inicialización
        int[][] matriz = new int[5][5];

        // recorrido de la matriz
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = (fila + columna) % 10;
            }
        }

        Bordes.mostrarTextoConBordes("matriz cuadrada");
        Bordes.mostrarMatrizConBordes(matriz);

        int[][] matrizA = GeneredorMatrices.generarMatriz(7, 5, 1000);
        int[][] matrizB = GeneredorMatrices.generarMatriz(6, 7, 1000);

        Bordes.mostrarMatricesConBordes(5, matriz, matrizA, matrizB);

        EjerciciosFinales.mostrarMatrizTranspuesta(matrizA);
        EjerciciosFinales.mostrarMatrizTranspuesta(matrizB);
    }

}
