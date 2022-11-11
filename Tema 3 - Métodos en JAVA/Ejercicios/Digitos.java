public class Digitos {

    public static void main(String[] args) {

        final int NUM = 2344; //aquí va el número
        final int digitos = digitos(NUM);
        System.out.println("El número "+NUM+" tiene "+digitos+" digito"+ (digitos > 1 ? "s." : "."));        
    }

    static int digitos(int n)
    {
        if(n == 0) return 0;
        return 1 + digitos(n/10);
    }    
}
