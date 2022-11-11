public class Potencia {
    
    public static void main(String[] args) {

        final int BASE = 3;
        final int EXP = 0;
        System.out.println("El número "+BASE+" elevado a "+EXP+" es igual a "+potencia(BASE, EXP)+".");
        
    }

    static int potencia(int base, int exp)
    {
        if(exp == 0) return 1;
        return base*potencia(base, --exp);
    }
}
