public class Matrices {

    public static void main(String[] args) {
        
        //declaración y inicialización
        int[][] matriz = new int[15][15];

        //recorrido de la matriz
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) { 
                matriz[fila][columna] = (fila+columna)%10;
                System.out.print(matriz[fila][columna]+" ");  
            }                         
            System.out.println();
        }
    }
    
}
