public class MatricesIrregulares {

    public static void main(String[] args) {

        int[][] b = new int[10][];     
        int contador = 0;   

        // recorrido de la matriz
        for (int fila = 0; fila < b.length; fila++) {
            b[fila] = new int[fila+1];
            for (int columna = 0; b[fila] != null && columna < b[fila].length; columna++) {
                b[fila][columna] = ++contador%10 == 0 ? ++contador%10 : contador%10;
                System.out.print(b[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}
