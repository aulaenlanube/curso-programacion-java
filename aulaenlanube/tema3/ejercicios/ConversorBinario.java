package aulaenlanube.tema3.ejercicios;
public class ConversorBinario {

    public static void main(String[] args) {

        final int NUM = 15;
        System.out.println("El número "+NUM+" en binario es "+convertir(NUM)+".");
        imprimirFraseBinario(NUM);        
    }

    static int convertir(int n)
    {
        if(n == 0 || n == 1) return n;
        else
            return n%2+10*convertir(n/2);
    }

    static void imprimirFraseBinario(int n)
    {
        System.out.print("El número "+n+" en binario es ");
        imprimirBinario(n);
        System.out.println(".");
    }

    static void imprimirBinario(int n)
    {
        if(n == 0 || n == 1) System.out.print(n);
        else {
            imprimirBinario(n/2);
            System.out.print(n%2);
        }
    }    
}
