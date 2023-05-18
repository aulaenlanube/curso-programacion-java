package aulaenlanube.tema2.ejemplos;
public class Escapes {

    public static void main(String[] args) {
        
        String texto = "\n\n\t\u221e Esto es una string de programación\n\t\u2605 Esto sigue siendo la string\n";
        char letra = '\u221e';
        System.out.println(letra);
        System.out.println(texto);
    }
    
}
