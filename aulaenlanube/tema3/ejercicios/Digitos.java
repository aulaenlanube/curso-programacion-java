package aulaenlanube.tema3.ejercicios;
public class Digitos {

    public static void main(String[] args) {

        final int NUM = 5; //aquí va el número
        mostrarDigitos(NUM);
    }

    static void mostrarDigitos(int n)
    {
        int digitos = digitos(n);
        System.out.println("El número "+n+" tiene "+digitos+" dígito"+ (digitos > 1 ? "s." : "."));  
    }

    static int digitos(int n)
    {
        if(n == 0) return 0;
        return 1 + digitos(n/10);

    }    

}
