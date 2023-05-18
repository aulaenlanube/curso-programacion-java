package aulaenlanube.tema4.ejercicios;

import aulaenlanube.tema4.bordes.Bordes;

public class EjerciciosFinales {

    public static void mostrarMatrizTranspuesta(int[][] matriz) {

        for (int i = 0; i < matriz.length - 1; i++) {
            if (matriz[i].length != matriz[i + 1].length) {
                System.out.println("\nERROR: No se puede obtener la transpuesta, la matriz no es válida");
                return;
            }
        }

        System.out.println("\nMatriz transpuesta:");
        int[][] transpuesta = new int[matriz.length == 0 ? 0 : matriz[0].length][matriz.length];
        for (int i = 0; i < transpuesta.length; i++) {
            for (int j = 0; j < transpuesta[i].length; j++) {
                transpuesta[i][j] = matriz[j][i];
            }
        }
        Bordes.mostrarMatrizConBordes(transpuesta);
    }

    public static int[] maximosColumnas(int[][] matriz) {

        int anchoMax = 0;
        for (int[] fila : matriz) {
            if (fila.length > anchoMax)
                anchoMax = fila.length;
        }
        int[] arrayMaximos = new int[anchoMax];
        for (int i = 0; i < arrayMaximos.length; i++) {
            arrayMaximos[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > arrayMaximos[j])
                    arrayMaximos[j] = matriz[i][j];
            }
        }
        return arrayMaximos;
    }

    public static int[] maximosFilas(int[][] matriz) {

        int maxFila;
        int[] arrayMaximos = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            maxFila = Integer.MIN_VALUE;
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maxFila)
                    maxFila = matriz[i][j];
            }
            arrayMaximos[i] = maxFila;
        }
        return arrayMaximos;
    }

}
