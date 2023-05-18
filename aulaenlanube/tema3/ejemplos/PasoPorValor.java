package aulaenlanube.tema3.ejemplos;
public class PasoPorValor {
 
    public static void main(String[] args) {
        
        System.out.println("num="+num+"  doble="+doble(num));
    }

    static int doble(int num)
    {
        num*=2;
        return num;
    }
    static int num = 2;    
}
