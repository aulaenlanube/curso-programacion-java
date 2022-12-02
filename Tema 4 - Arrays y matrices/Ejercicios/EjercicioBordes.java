public class EjercicioBordes {

    static final char LINEA_VERTICAL = '║';
    static final char LINEA_HORIZONTAL = '═';
    static final char ESQUINA_SUP_IZQ = '╔';
    static final char ESQUINA_INF_IZQ = '╚';
    static final char ESQUINA_SUP_DER = '╗';
    static final char ESQUINA_INF_DER = '╝';
    static final char SEPARADOR_SUP = '╦';
    static final char SEPARADOR_INF = '╩';

    static final int BORDE_SUP = 0;
    static final int BORDE_INF = 1;

    public static void main(String[] args) {

        String texto = """
                Programación en JAVA
                Tema 4
                Estamos haciendo ejercicios de repaso
                """;

        mostrarTextoConBordes("Hoy es jueves, 1 de diciembre de 2022");
        mostrarTextoConBordes(texto);
        mostrarArrayConBordes(new int[] {1,-2,-112,564,23,1,2323,2,3});

    }

    static void mostrarArrayConBordes(int[] nums) {

        imprimirBordeSuperiorArray(nums);
        imprimirEnterosArray(nums);
        imprimirBordeInferiorArray(nums);
    }

    static void imprimirEnterosArray(int[] array) {

        System.out.print(LINEA_VERTICAL+" ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" "+LINEA_VERTICAL+" ");            
        }
        System.out.println();
    }

    static void imprimirBordeSuperiorArray(int[] array) {
        imprimirBordeArray(array, BORDE_SUP);
    }

    static void imprimirBordeInferiorArray(int[] array) {
        imprimirBordeArray(array, BORDE_INF);
    }

    static void imprimirBordeArray(int[] array, int tipoBorde) {

        //imprimimos la esquina suprior izquierda
        System.out.print(tipoBorde == BORDE_SUP ? ESQUINA_SUP_IZQ : ESQUINA_INF_IZQ);

        //por cada entero del Array
        for (int i = 0; i < array.length; i++) {

            //imprimimos las líneas horizontales
            int lineas = digitos(Math.abs(array[i])) + 2;
            if(array[i]<0) lineas++;
            for (int j = 0; j < lineas; j++)
                System.out.print(LINEA_HORIZONTAL);

            //imprimimos el separador
            if (i < array.length - 1)
                System.out.print(tipoBorde == BORDE_SUP ? SEPARADOR_SUP : SEPARADOR_INF);
        }

        //imprimimos la esquina suprior derecha
        System.out.println(tipoBorde == BORDE_SUP ? ESQUINA_SUP_DER : ESQUINA_INF_DER);
    }

    static void mostrarTextoConBordes(String texto) {

        // pasamos a mayúsculas
        texto = texto.toUpperCase();

        // obtenemos un array de Strings
        String[] lineas = texto.split("\n");

        // obtenemos la longitud de la línea más larga
        int ancho = obtenerAnchoMaximo(lineas);

        // imprimimos el texto con los bordes
        imprimirLetrasBordes(lineas, ancho);
    }

    static void imprimirLetrasBordes(String[] lineas, int ancho) {

        // borde superior
        imprimirBordeSuperior(ancho);

        // líneas centrales
        imprimirLineas(lineas, ancho);

        // borde inferior
        imprimirBordeInferior(ancho);

    }

    static void imprimirBordeSuperior(int ancho) {
        imprimirBorde(BORDE_SUP, ancho);
    }

    static void imprimirBordeInferior(int ancho) {
        imprimirBorde(BORDE_INF, ancho);
    }

    static int obtenerAnchoMaximo(String[] lineas) {
        int anchoMax = 0;
        for (String lineaActual : lineas) {
            if (lineaActual.length() > anchoMax)
                anchoMax = lineaActual.length();
        }
        return anchoMax;
    }

    static void imprimirLineas(String[] lineas, int lineaMax) {
        for (int i = 0; i < lineas.length; i++) {
            System.out.print(LINEA_VERTICAL + "  ");
            for (int j = 0; j < lineaMax; j++) {
                if (j < lineas[i].length())
                    System.out.print(lineas[i].charAt(j) + " ");
                else
                    System.out.print("  ");
            }
            System.out.println(" " + LINEA_VERTICAL);
        }
    }

    static void imprimirBorde(int tipoBorde, int ancho) {

        System.out.print(tipoBorde == BORDE_SUP ? ESQUINA_SUP_IZQ : ESQUINA_INF_IZQ);
        for (int i = 0; i < ancho * 2 + 3; i++)
            System.out.print(LINEA_HORIZONTAL);
        System.out.println(tipoBorde == BORDE_SUP ? ESQUINA_SUP_DER : ESQUINA_INF_DER);

    }

    static int digitos(int n) {

        if (n < 10)
            return 1;
        return 1 + digitos(n / 10);
    }
}
