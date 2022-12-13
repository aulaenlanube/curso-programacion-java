import java.util.Arrays;

public class CopiarClonar {

    public static void main(String[] args) {

        int[] primos = { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23 };
        int[] copiaClonado;
        int[] copiaReferencia;
        int[] copiaReferencia2;

        // clonación
        copiaClonado = primos.clone();

        // cambio en el clon, sin afectar al original
        copiaClonado[0] = 0;

        // copia de referencia
        copiaReferencia = primos;

        // cambio en la copia, afecta al original
        copiaReferencia[1] = 0;

        // copia de referencia 2
        copiaReferencia2 = copiaReferencia;
        copiaReferencia2[0] = -1;

        // salida
        System.out.println(Arrays.toString(primos)); // [1, 0, 3, 5, 7, 11, 13, 17, 19, 23]
        System.out.println(Arrays.toString(copiaClonado)); // [0, 2, 3, 5, 7, 11, 13, 17, 19, 23]
        System.out.println(Arrays.toString(copiaReferencia));// [1, 0, 3, 5, 7, 11, 13, 17, 19, 23]
        System.out.println(Arrays.toString(copiaReferencia2));// [1, 0, 3, 5, 7, 11, 13, 17, 19, 23]

        //espacios de mem
        System.out.println(primos);
        System.out.println(copiaClonado);
        System.out.println(copiaReferencia);
        System.out.println(copiaReferencia2);

    }

}
