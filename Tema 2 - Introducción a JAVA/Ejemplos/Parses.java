public class Parses {

    public static void main(String[] args) {
        
        char num = '3';   
        int a = Character.getNumericValue(num), b = 3; 
        int c = (int)Math.pow(a,b);
        System.out.println(c);

        String num2 = "4";   
        a = Integer.parseInt(num2); b = 3; 
        c = (int)Math.pow(a,b);
        System.out.println(c);
    }    
}
