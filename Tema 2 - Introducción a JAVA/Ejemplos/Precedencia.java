public class Precedencia {

    public static void main(String[] args) {
        
        int n = 2;
        int m = n++*3+2+(++n); //2*3+2+4=12
        System.out.println(m);

        n = 2;
        int x = ++n+2+3*(n+++1); //3+2+3*(3+1)=17
        System.out.println(n);
    }
    
}
