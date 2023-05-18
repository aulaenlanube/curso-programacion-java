package aulaenlanube.tema3.ejercicios;
public class OrdenarAlfabeticamente {

    public static void main(String[] args) {

        final String PALABRA = "aaaaaAAA";
        mostrarPalabraOrdenada(PALABRA);   
    }

    static void mostrarPalabraOrdenada(String cad)
    {
        if (palabraOrdenada(cad.toLowerCase()))
            System.out.println("La palabra [" + cad + "] está ordenada alfabéticamente.");
        else
            System.out.println("La palabra [" + cad + "] NO está ordenada alfabéticamente.");
    }

    static boolean palabraOrdenada(String cad) {
        
        if (cad.length() > 1) {

            if (cad.charAt(0) <= cad.charAt(1))
                return palabraOrdenada(cad.substring(1, cad.length()));
            return false;
        }
        return true;
    }
}
