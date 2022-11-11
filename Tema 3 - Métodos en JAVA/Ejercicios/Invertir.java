public class Invertir {

    public static void main(String[] args) {

        final int NUM = 0;
        invertir(NUM);        
    }

    static void invertir(int n)
    {
        if(n>=0 && n<10) System.out.println(n);
        else {
            System.out.print(n%10);
            invertir(n/10);            
        }           
    }    
}
