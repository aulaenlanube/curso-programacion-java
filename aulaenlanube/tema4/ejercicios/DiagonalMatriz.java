package aulaenlanube.tema4.ejercicios;
public class DiagonalMatriz {

    public static void main(String[] args) {

        imprimirMatrizInvertida2(crearMatriz(15));        
    }

    static void imprimirMatriz(int[][] m) {

        for (int[] fila : m) {
            for (int columna : fila) {
                if(columna == 1) System.out.print("X ");
                else System.out.print("- ");                
            }
            System.out.println();            
        }
    }
    static void imprimirMatrizInvertida(int[][] m) {

        for(int i=0;i<m.length;i++)
        {
            for(int j=m[i].length-1;j>=0;j--)
            {
                if(m[i][j] == 1) System.out.print("X ");
                else System.out.print("- ");     
            }
            System.out.println();
        }
    }

    static void imprimirMatrizInvertida2(int[][] m) {

        for (int[] fila : m) {
            String linea = "";
            for (int columna : fila) {
                if(columna == 1) linea = "X "+linea;
                else linea = "- "+linea;              
            }
            System.out.println(linea);            
        }
    }

    static int[][] crearMatriz(int n) {

        int[][] m = new int[n][n];
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[i].length;j++)
            {
                if(i == j) m[i][j] = 1;
                else m[i][j] = 0;
            }
        }
        return m;
    }
    
}
