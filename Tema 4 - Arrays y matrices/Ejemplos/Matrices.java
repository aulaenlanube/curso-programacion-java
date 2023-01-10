public class Matrices {

    public static void main(String[] args) {
        
        //declaración y inicialización
        int[][] matriz = new int[5][5];

        //recorrido de la matriz
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) { 
                matriz[fila][columna] = (fila+columna)%10;               
            }
        }

        BordesMatrices.mostrarTextoConBordes("matriz cuadrada");
        BordesMatrices.mostrarMatrizConBordes(matriz);

        int[][] matrizA = GeneredorMatrices.generarMatriz(7, 5, 1000);
        int[][] matrizB = GeneredorMatrices.generarMatriz(6, 7, 1000);

        BordesMatrices.mostrarMatricesConBordes(5, matriz, matrizA, matrizB);

        EjerciciosFinales.mostrarMatrizTranspuesta(matrizA);
        EjerciciosFinales.mostrarMatrizTranspuesta(matrizB);
    }
    
}
