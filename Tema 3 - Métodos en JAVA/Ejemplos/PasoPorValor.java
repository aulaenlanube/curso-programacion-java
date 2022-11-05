public class PasoPorValor {

    static int num = 2;

    public static void main(String[] args) {
        
        System.out.println("num="+num+"  doble="+doble(num));
    }

    static int doble(int num)
    {
        num*=2;
        return num;
    }
    
}
