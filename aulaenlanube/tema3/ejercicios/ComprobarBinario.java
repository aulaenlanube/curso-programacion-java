package aulaenlanube.tema3.ejercicios;
public class ComprobarBinario {

    public static void main(String[] args) {

        final int NUM = 120011;
        if(esBinario(NUM)) System.out.println("El número "+NUM+" está en binario.");
        else System.out.println("El número "+NUM+" NO está en binario.");        
    }

    static boolean esBinario(int n)
    {
        if(n>=0 && n<10)
        {
            if(n == 0 || n == 1) return true;
            return false;
        }
        if(n%10 == 0 || n%10 == 1) return esBinario(n/10);
        return false;        
    }

    static boolean esBinario2(int n)
    {
        if(n>9)
        {
            if(n%10 == 0 || n%10 == 1) return esBinario(n/10);
            return false;  
        }
        if(n == 0 || n == 1) return true;
        return false;           
    }
    
}
