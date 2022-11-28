import java.util.Arrays;

public class EjercicioMatricesIrregulares {

    public static void main(String[] args) {

        int[][] a = { { 1, 2, 1 }, { 4, 5 }, {}, { 7, 8 } };
        int[][] b = { { 5, 6 }, { 7, 5, 2 }, { 1, 8 }, { 1, 1, 2 } };

        mostrarMatrizMaxima(a, b);
    }

    static void mostrarMatrizMaxima(int[][] a, int[][] b) {

        int[][] c = matrizMaxima(a, b);
        for (int[] fila : c) {
            System.out.println(Arrays.toString(fila));
        }
    }

    static int[][] matrizMaxima(int[][] a, int[][] b) {

        int[][] c = crearMatriz(a, b);

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                
                // CASO 1: si en b no existe la fila
                if (i >= b.length)
                    c[i][j] = a[i][j];
                // CASO 2: si en a no existe fila
                else if (i >= a.length)
                    c[i][j] = b[i][j];
                // CASO 3: si en a y b existe la fila
                else {
                    // CASO 3.1: si en b no existe la columna
                    if (j >= b[i].length)
                        c[i][j] = a[i][j];
                    // CASO 3.2: si en a no existe la columna
                    else if (j >= a[i].length)
                        c[i][j] = b[i][j];
                    // CASO 3.3: si en a y en b existe la columna
                    else
                        c[i][j] = a[i][j] > b[i][j] ? a[i][j] : b[i][j];
                }
            }
        }
        return c;
    }

    static int[][] crearMatriz(int[][] a, int[][] b) {

        int filas = a.length > b.length ? a.length : b.length;
        int[][] s = new int[filas][];

        for (int i = 0; i < filas; i++) {

            // CASO 1: si en b no existe la fila
            if (i >= b.length) {
                int columnas = a[i].length;
                s[i] = new int[columnas];
            }
            // CASO 2: si en a no existe fila
            else if (i >= a.length) {
                int columnas = b[i].length;
                s[i] = new int[columnas];
            }
            // CASO 3: si en a y b existe la fila
            else {
                int columnas = a[i].length > b[i].length ? a[i].length : b[i].length;
                s[i] = new int[columnas];
            }
        }
        return s;
    }

}
