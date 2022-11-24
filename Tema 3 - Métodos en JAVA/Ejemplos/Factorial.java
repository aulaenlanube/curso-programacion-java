public class Factorial {

    static int factorial(int n) { 

        int r;  
        if(n == 0) r = 1;             
        else r = n*factorial(n-1);
        return r;
      } 
      
      public static void main(String args[])  {
      
        int f = factorial(4);
        System.out.println(f);
      }  
      

}
