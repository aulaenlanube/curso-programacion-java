public class Desplazamientos {

    public static void main(String[] args) {

        int a = -1; // 11111111 11111111 11111111 11111111
        int b = -16; // 11111111 11111111 11111111 11110000
        
        int resultado = 0;
        resultado = a << 1; // 11111111 11111111 11111111 11111111 → -1
        resultado = a >>> 1; // 01111111 11111111 11111111 11111111 → 2147483647
        resultado = b >> 1; // 11111111 11111111 11111111 11111000 → -8
        resultado = b >>> 1; // 01111111 11111111 11111111 11111000 → 2147483640
        resultado = b >> 24; // 11111111 11111111 11111111 11111111 → -1
        resultado = b >>> 24; // 00000000 00000000 00000000 11111111 → 255
        
        a >>= 1; // 11111111 11111111 11111111 11111111 → -1
        a >>>= 1; // 01111111 11111111 11111111 11111111 → 2147483647        
        
        a <<= 1; // 11111111 11111111 11111111 11111110 → -2  
        a <<= 1; // 11111111 11111111 11111111 11111110 → -4

        System.out.println(resultado);
        System.out.println(a);    
    }
}
